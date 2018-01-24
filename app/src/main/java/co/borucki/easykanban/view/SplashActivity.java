package co.borucki.easykanban.view;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.borucki.easykanban.R;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.statics.Device;
import co.borucki.easykanban.statics.ImageBitmap;
import co.borucki.easykanban.statics.LocaleHelper;

public class SplashActivity extends AppCompatActivity {
    private CustomDataRepository mRepository = CustomDataRepositoryImpl.getInstance();
    private static final int PERMISSIONS_REQUEST_READ_PHONE_STATUS = 1;
    private boolean handlerFlag = false;

    @BindView(R.id.splash_activity_layout)
    RelativeLayout mLayout;
    @BindView(R.id.splash_activity_logo)
    ImageView mLogo;
    @BindView(R.id.splash_activity_skip_counter)
    TextView mSkipCounter;
    @BindView(R.id.splash_activity_customized_text)
    TextView mCustomizedText;
    @BindView(R.id.splash_activity_thanks_text)
    TextView mThanksText;
    @BindView(R.id.splash_activity_author)
    TextView mAuthor;

    @Override
    protected void onPause() {
        super.onPause();
        handlerFlag = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        handlerFlag = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        loadCustomDesign();
        mSkipCounter.setVisibility(View.INVISIBLE);
        if (mRepository.getIMEI().equals("")) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                saveImeiInSharedPreference();
                runMainScrees();
            } else {
                askPermission();
            }
        } else {
            runMainScrees();
        }
    }

    private void loadCustomDesign() {
        mCustomizedText.setText(mRepository.getSplashScreenCustomText());
        mCustomizedText.setTextSize(mRepository.getSplashScreenCustomTextSize());
        mCustomizedText.setTextColor(Color.parseColor(mRepository.getSplashTextColor()));
        if ((mRepository.getSplashScreenTextVisible() & 1) == 1) {
            mCustomizedText.setVisibility(View.VISIBLE);
        } else {
            mCustomizedText.setVisibility(View.GONE);
        }
        mThanksText.setText(mRepository.getSplashScreenThanksText());
        mThanksText.setTextSize(mRepository.getSplashScreenThanksTextSize());
        mThanksText.setTextColor(Color.parseColor(mRepository.getSplashTextColor()));
        if ((mRepository.getSplashScreenTextVisible() & 2) == 2) {
            mThanksText.setVisibility(View.VISIBLE);
        } else {
            mThanksText.setVisibility(View.GONE);
        }
        if ((mRepository.getSplashScreenTextVisible() & 4) == 4) {
            mSkipCounter.setVisibility(View.VISIBLE);
        } else {
            mSkipCounter.setVisibility(View.GONE);
        }
        if (!mRepository.getLogo().equals("")) {
            mLogo.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mRepository.getLogo()));
        }
        mSkipCounter.setTextColor(Color.parseColor(mRepository.getSplashTextColor()));
        mAuthor.setTextColor(Color.parseColor(mRepository.getSplashTextColor()));
        mLayout.setBackgroundColor(Color.parseColor(mRepository.getSplashLayoutColor()));
    }

    private void runMainScrees() {
        new CountDownTimer(mRepository.getSplashScreenTime() * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                if ((mRepository.getSplashScreenTextVisible() & 4) == 4) {
                    mSkipCounter.setVisibility(View.VISIBLE);
                }
                mSkipCounter.setText(getString(R.string.splash_activity_counter_text, millisUntilFinished / 1000));
            }

            public void onFinish() {
                if (!handlerFlag) {
                    navigateToLoginScreen();
                }
            }
        }.start();
    }

    private void navigateToLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.splash_activity_skip_counter)
    void OnSkipCounterClicked() {
        navigateToLoginScreen();
    }

    private void askPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSIONS_REQUEST_READ_PHONE_STATUS);
        } else {
            saveImeiInSharedPreference();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult);
        switch (requestCode) {
            case PERMISSIONS_REQUEST_READ_PHONE_STATUS:
                if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    saveImeiInSharedPreference();
                    runMainScrees();
                } else {
                    showAlertDialogReadStatusPhonePermissionDenied();
                }
        }
    }

    private void showAlertDialogReadStatusPhonePermissionDenied() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        dialog.setTitle(R.string.splash_activity_permission_warning);
        dialog.setMessage(R.string.splash_activity_permission_alert_message);
        dialog.setPositiveButton(R.string.splash_activity_permission_alert_positive_action, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                askPermission();
            }
        });
        dialog.setNegativeButton(R.string.splash_activity_permission_alert_negative_action, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        dialog.show();
    }

    private void saveImeiInSharedPreference() {
        mRepository.setIMEI(Device.getDeviceID(this));
    }
}
