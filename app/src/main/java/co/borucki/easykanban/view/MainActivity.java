package co.borucki.easykanban.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.easykanban.Mail;
import co.borucki.easykanban.R;
import co.borucki.easykanban.asyncTask.AppConfigurationConfirmAsyncTask;
import co.borucki.easykanban.asyncTask.SendEmailAsyncTask;
import co.borucki.easykanban.model.EventLog;
import co.borucki.easykanban.model.ScannedType;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.EventLogRepository;
import co.borucki.easykanban.repository.EventLogRepositoryImpl;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;
import co.borucki.easykanban.statics.CustomLayoutViewSetup;
import co.borucki.easykanban.statics.DateTimeCounter;
import co.borucki.easykanban.statics.Session;

public class MainActivity extends AppCompatActivity {
    private final UserRepository mUserRepo = UserRepositoryImpl.getInstance();
    private final EventLogRepository mLogRepo = EventLogRepositoryImpl.getInstance();
    private final CustomDataRepository mRepository = CustomDataRepositoryImpl.getInstance();
    @BindView(R.id.usedProductButton)
    RelativeLayout mUsedProductButton;
    @BindView(R.id.usedProductButtonText)
    TextView mUsedProductButtonText;
    @BindView(R.id.usedProductButtonBadge)
    TextView mUsedProductButtonBadge;
    @BindView(R.id.receivedProductButton)
    RelativeLayout mReceivedProductButton;
    @BindView(R.id.receivedProductButtonText)
    TextView mReceivedProductButtonText;
    @BindView(R.id.receivedProductButtonBadge)
    TextView mReceivedProductButtonBadge;
    @BindView(R.id.messageButton)
    RelativeLayout mMessageButton;
    @BindView(R.id.messageButtonText)
    TextView mMessageButtonText;
    @BindView(R.id.messageButtonBadge)
    TextView mMessageButtonBadge;
    @BindView(R.id.stocktakingProductButton)
    RelativeLayout mStocktakingProductButton;
    @BindView(R.id.stocktakingProductButtonText)
    TextView mStocktakingProductButtonText;
    @BindView(R.id.stocktakingProductButtonBadge)
    TextView mStocktakingProductButtonBadge;
    @BindView(R.id.main_activity_logo)
    ImageView mLogo;
    @BindView(R.id.main_activity_author)
    TextView mAuthor;
    @BindView(R.id.main_activity_layout)
    RelativeLayout mLayout;
    @BindView(R.id.main_activity_tool_bar)
    Toolbar mToolBar;
    private long userId;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        userId = intent.getLongExtra("USER_ID", 0);
        mUser = mUserRepo.getUserById(userId);
        mToolBar.setTitle(mUser.toString());
        setUpButtons();
        setButtonOnClick();
        CustomLayoutViewSetup.setMainLayoutView(mToolBar, mLogo, mAuthor, mLayout, this);
        CustomLayoutViewSetup.setMessageBadge(mMessageButtonBadge);
        CustomLayoutViewSetup.setScannedBadge(mUsedProductButtonBadge, ScannedType.USED.getType().toUpperCase());
        CustomLayoutViewSetup.setScannedBadge(mReceivedProductButtonBadge, ScannedType.RECEIVED.getType().toUpperCase());
        CustomLayoutViewSetup.setScannedBadge(mStocktakingProductButtonBadge, ScannedType.STOCKTAKING.getType().toUpperCase());
        setSupportActionBar(mToolBar);
        Session.checkIfSessionIsActive(this);
        sendAppLogs();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Session.checkIfSessionIsActive(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Session.checkIfSessionIsActive(this);
        setUpButtons();
        sendAppLogs();
        setButtonOnClick();
        CustomLayoutViewSetup.setMainLayoutView(mToolBar, mLogo, mAuthor, mLayout, this);
        CustomLayoutViewSetup.setMessageBadge(mMessageButtonBadge);
        CustomLayoutViewSetup.setScannedBadge(mUsedProductButtonBadge, ScannedType.USED.getType().toUpperCase());
        CustomLayoutViewSetup.setScannedBadge(mReceivedProductButtonBadge, ScannedType.RECEIVED.getType().toUpperCase());
        CustomLayoutViewSetup.setScannedBadge(mStocktakingProductButtonBadge, ScannedType.STOCKTAKING.getType().toUpperCase());

    }

    private void setButtonOnClick() {
        mUsedProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ScannedProductActivity.class);
                intent.putExtra("USER_ID", userId);
                intent.putExtra("LIST_TYPE", ScannedType.USED.getType().toUpperCase());
                v.getContext().startActivity(intent);
            }
        });
        mReceivedProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ScannedProductActivity.class);
                intent.putExtra("USER_ID", userId);
                intent.putExtra("LIST_TYPE", ScannedType.RECEIVED.getType().toUpperCase());
                v.getContext().startActivity(intent);
            }
        });
        mMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), IncomingMessageActivity.class);
                intent.putExtra("USER_ID", userId);
                v.getContext().startActivity(intent);
            }
        });
        mStocktakingProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ScannedProductActivity.class);
                intent.putExtra("USER_ID", userId);
                intent.putExtra("LIST_TYPE", ScannedType.STOCKTAKING.getType().toUpperCase());
                v.getContext().startActivity(intent);
            }
        });
    }

    private void setUpButtons() {
        CustomLayoutViewSetup
                .setButtonView(mUsedProductButton
                        , mUsedProductButtonText
                        , mUsedProductButtonBadge
                        , getString(R.string.main_button_used_product)
                        , mUser.getPermissions() > 1);
        CustomLayoutViewSetup
                .setButtonView(mReceivedProductButton
                        , mReceivedProductButtonText
                        , mReceivedProductButtonBadge
                        , getString(R.string.main_button_received_product)
                        , mUser.getPermissions() > 2);
        CustomLayoutViewSetup
                .setButtonView(mMessageButton
                        , mMessageButtonText
                        , mMessageButtonBadge
                        , getString(R.string.main_button_incoming_message)
                        , mUser.getPermissions() > 4);

        CustomLayoutViewSetup
                .setButtonView(mStocktakingProductButton
                        , mStocktakingProductButtonText
                        , mStocktakingProductButtonBadge
                        , getString(R.string.main_button_stocktaking)
                        , mUser.getPermissions() == 8);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        } else if (item.getItemId() == R.id.change_password) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.change_password, null);
            final TextView title = dialogView.findViewById(R.id.change_password_user_name);
            final EditText oldPassword = dialogView.findViewById(R.id.change_password_current);
            final EditText newPassword = dialogView.findViewById(R.id.change_password_new);
            final EditText confirmPassword = dialogView.findViewById(R.id.change_password_confirm);
            title.setText(getResources().getString(R.string.change_password_dialog_title, mUser.getName(), mUser.getSurname()));
            builder.setPositiveButton(R.string.change_password_positive_buton, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (oldPassword.getText().length() < 4
                            || newPassword.getText().length() < 4
                            || confirmPassword.getText().length() < 4) {
                        Toast.makeText(MainActivity.this, R.string.change_password_to_short, Toast.LENGTH_LONG).show();
                    } else if (!oldPassword.getText().toString().equals(mUser.getPassword())) {
                        Toast.makeText(MainActivity.this, R.string.change_password_incorrect_old, Toast.LENGTH_LONG).show();
                    } else if (!newPassword.getText().toString().equals(confirmPassword.getText().toString())) {
                        Toast.makeText(MainActivity.this, R.string.change_password_different, Toast.LENGTH_LONG).show();
                    } else {
                        mUser.setPassword(newPassword.getText().toString());
                        mUserRepo.updateUser(mUser);
                        Toast.makeText(MainActivity.this, R.string.change_password_changed, Toast.LENGTH_LONG).show();
                    }
                }
            });
            builder.setNegativeButton(R.string.change_password_negative_button, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setView(dialogView);
            builder.create().show();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info_menu_main, menu);
        return true;
    }

    private void sendAppLogs() {
        if (mRepository.isSendLog()) {
            mRepository.setSendLog(false);
            StringBuilder builder = new StringBuilder();
            builder.append(DateTimeCounter.getDateTime());
            builder.append("\n");
            for (EventLog eventLog : mLogRepo.getAll()) {
                builder.append(eventLog.toString());
                builder.append("\n");
            }
            String[] recipients = mRepository.getMailTo().split(";");
            SendEmailAsyncTask email = new SendEmailAsyncTask();
            email.m = new Mail(mRepository.getMailAddress(), mRepository.getMailPassword());
            email.m.set_from(mRepository.getMailAddress());
            email.m.setBody(builder.toString());
            email.m.set_to(recipients);
            email.m.set_host(mRepository.getMailHost());
            email.m.set_port(String.valueOf(mRepository.getMailSMTPPort()));
            email.m.set_sport(String.valueOf(mRepository.getMailSMTPPort()));
            email.m.set_subject("Log from device >>" + mRepository.getIMEI() + "<< Used by: >>" + mRepository.getCustomerName() + "<<");
            email.execute();
            mLogRepo.removeAll();
            new AppConfigurationConfirmAsyncTask().execute("send_all");
        }
    }
}
