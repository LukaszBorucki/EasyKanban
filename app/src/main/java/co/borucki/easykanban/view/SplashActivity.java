package co.borucki.easykanban.view;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.borucki.easykanban.R;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.statics.Device;

public class SplashActivity extends AppCompatActivity {
    private CustomDataRepository mRepository = CustomDataRepositoryImpl.getInstance();
    private static final int PERMISSIONS_REQUEST_READ_PHONE_STATUS = 1;
    private boolean handlerFlag = false;

    @BindView(R.id.splash_activity_logo)
    ImageView mLogo;
    @BindView(R.id.splash_activity_skip_counter)
    TextView mSkipCounter;
    @BindView(R.id.splash_activity_customized_text)
    TextView mCustomizedText;
    @BindView(R.id.splash_activity_thanks_text)
    TextView mThanksText;

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

    private void runMainScrees() {

        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                mSkipCounter.setVisibility(View.VISIBLE);
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
                    TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
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
        dialog.setTitle("Warning");
        dialog.setMessage("Easy Kanban app need read phone status to identification devices in supplier system. If you deny permission, application will be closed.");
        dialog.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                askPermission();
            }
        });
        dialog.setNegativeButton("Close app", new DialogInterface.OnClickListener() {
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
