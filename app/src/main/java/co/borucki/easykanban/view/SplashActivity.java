package co.borucki.easykanban.view;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.borucki.easykanban.LocaleHelper;
import co.borucki.easykanban.R;

public class SplashActivity extends AppCompatActivity {
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
        runMainScrees();
    }
    private void runMainScrees() {

        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
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
    void OnSkipCounterClicked(){
        navigateToLoginScreen();
    }
}
