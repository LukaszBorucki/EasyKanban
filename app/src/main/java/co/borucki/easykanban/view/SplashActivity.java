package co.borucki.easykanban.view;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import co.borucki.easykanban.asyncTask.CustomerAsyncTask;
import co.borucki.easykanban.asyncTask.UserAsyncTask;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.EventLogRepository;
import co.borucki.easykanban.repository.EventLogRepositoryImpl;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;
import co.borucki.easykanban.repository.style.SplashStyleRepository;
import co.borucki.easykanban.repository.style.SplashStyleRepositoryImpl;
import co.borucki.easykanban.service.MyReceiver;
import co.borucki.easykanban.statics.Device;
import co.borucki.easykanban.statics.ImageBitmap;
import co.borucki.easykanban.statics.InternetAccess;

public class SplashActivity extends AppCompatActivity {
    private CustomDataRepository mRepository = CustomDataRepositoryImpl.getInstance();
    private final SplashStyleRepository mStyleRepo = SplashStyleRepositoryImpl.getInstance();
    private final UserRepository mUserRepo = UserRepositoryImpl.getInstance();
    private static final int PERMISSIONS_REQUEST_READ_PHONE_STATUS = 101;
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
        runMainScrees();
        handlerFlag = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        scheduleAlarm();
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

    private void scheduleAlarm() {
        Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, MyReceiver.REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long firstMillis = System.currentTimeMillis();
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES, pIntent);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        loadDataAsyncTask();

    }

    private void loadDataAsyncTask() {
        if (!mRepository.getIMEI().equals("")) {
            if (mUserRepo.getAllUsers().size() == 0) {
                new UserAsyncTask(false, null, null, null).execute();
            }
            if (InternetAccess.isOnLine(this)
                    && mRepository.getCustomerName().equals("")
                    && mRepository.isCommercialLicence()) {
                new CustomerAsyncTask().execute();
            }

        }
    }

    private void loadCustomDesign() {
        SplashActivity.this.getWindow().setStatusBarColor(Color.parseColor(mStyleRepo.getStatusBarColor()));
        mCustomizedText.setText(mStyleRepo.getScreenCustomText());
        mCustomizedText.setTextSize(mStyleRepo.getScreenCustomTextSize());
        mCustomizedText.setTextColor(Color.parseColor(mStyleRepo.getTextColor()));
        if ((mStyleRepo.getScreenTextVisible() & 1) == 1) {
            mCustomizedText.setVisibility(View.VISIBLE);
        } else {
            mCustomizedText.setVisibility(View.GONE);
        }
        mThanksText.setText(mStyleRepo.getScreenThanksText());
        mThanksText.setTextSize(mStyleRepo.getScreenThanksTextSize());
        mThanksText.setTextColor(Color.parseColor(mStyleRepo.getTextColor()));
        if ((mStyleRepo.getScreenTextVisible() & 2) == 2) {
            mThanksText.setVisibility(View.VISIBLE);
        } else {
            mThanksText.setVisibility(View.GONE);
        }
        if ((mStyleRepo.getScreenTextVisible() & 4) == 4) {
            mSkipCounter.setVisibility(View.VISIBLE);
        } else {
            mSkipCounter.setVisibility(View.GONE);
        }
        if (!mRepository.getLogo().equals("")) {
            mLogo.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mRepository.getLogo()));
        }
        if (!mStyleRepo.getTextColor().equals("")) {
            mSkipCounter.setTextColor(Color.parseColor(mStyleRepo.getTextColor()));
            mAuthor.setTextColor(Color.parseColor(mStyleRepo.getTextColor()));
        }
        if (!mStyleRepo.getLayoutColor().equals(""))
            mLayout.setBackgroundColor(Color.parseColor(mStyleRepo.getLayoutColor()));
    }

    private void runMainScrees() {
        new CountDownTimer(mStyleRepo.getScreenTime() * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                if ((mStyleRepo.getScreenTextVisible() & 4) == 4) {
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
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.splash_activity_skip_counter)
    void OnSkipCounterClicked() {
        navigateToLoginScreen();
    }

    private void askPermission() {

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSIONS_REQUEST_READ_PHONE_STATUS);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult);
        switch (requestCode) {
            case PERMISSIONS_REQUEST_READ_PHONE_STATUS:
                if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    saveImeiInSharedPreference();
                    loadDataAsyncTask();
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
