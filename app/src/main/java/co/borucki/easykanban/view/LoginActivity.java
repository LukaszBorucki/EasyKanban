package co.borucki.easykanban.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.borucki.easykanban.R;
import co.borucki.easykanban.asyncTask.UserAsyncTask;
import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;
import co.borucki.easykanban.repository.style.LoginStyleRepository;
import co.borucki.easykanban.repository.style.LoginStyleRepositoryImpl;
import co.borucki.easykanban.statics.CustomLayoutViewSetup;
import co.borucki.easykanban.statics.DateTimeCounter;

public class LoginActivity extends AppCompatActivity {
    private LoginStyleRepository mLoginStyleRepo = LoginStyleRepositoryImpl.getInstance();
    private final UserRepository mUserRep = UserRepositoryImpl.getInstance();
    private final CustomDataRepository mCustomRep = CustomDataRepositoryImpl.getInstance();
    private List<User> mUsers;
    private User user;
    private List<String> spinnerArray = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private StringBuilder passwordBuilder = new StringBuilder();
    private List<Button> buttons = new ArrayList<>();

    @BindView(R.id.login_activity_spinner)
    Spinner mSpinner;
    @BindView(R.id.login_tool_bar)
    Toolbar navigationToolBar;
    @BindView(R.id.login_button_digit_0)
    Button buttonDigit0;
    @BindView(R.id.login_button_digit_1)
    Button buttonDigit1;
    @BindView(R.id.login_button_digit_2)
    Button buttonDigit2;
    @BindView(R.id.login_button_digit_3)
    Button buttonDigit3;
    @BindView(R.id.login_button_digit_4)
    Button buttonDigit4;
    @BindView(R.id.login_button_digit_5)
    Button buttonDigit5;
    @BindView(R.id.login_button_digit_6)
    Button buttonDigit6;
    @BindView(R.id.login_button_digit_7)
    Button buttonDigit7;
    @BindView(R.id.login_button_digit_8)
    Button buttonDigit8;
    @BindView(R.id.login_button_digit_9)
    Button buttonDigit9;
    @BindView(R.id.login_button_digit_clear)
    Button buttonDigitClear;

    @Override
    protected void onResume() {
        super.onResume();
        passwordBuilder.delete(0, passwordBuilder.length());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        CustomLayoutViewSetup.setLoginLayout(this, navigationToolBar);
        setSupportActionBar(navigationToolBar);
        mUsers = mUserRep.getAllUsers();

        if (mUsers.size() == 0) {
            disableEditTexts();
            showErrorDialog(getString(R.string.login_activity_no_users_loaded), false);
        }
        buttons.add(buttonDigit0);
        buttons.add(buttonDigit1);
        buttons.add(buttonDigit2);
        buttons.add(buttonDigit3);
        buttons.add(buttonDigit4);
        buttons.add(buttonDigit5);
        buttons.add(buttonDigit6);
        buttons.add(buttonDigit7);
        buttons.add(buttonDigit8);
        buttons.add(buttonDigit9);
        buttons.add(buttonDigitClear);
        setSpinnerArray();
        adapter = new ArrayAdapter<String>(
                this, R.layout.login_spinner_style, spinnerArray) {
            public @NonNull
            View getView(int position, View convertView, @NonNull ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                ((TextView) v).setTextSize(25);
                ((TextView) v).setTextColor(Color.parseColor(mLoginStyleRepo.getTextColor()));
                return v;
            }

            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
                ((TextView) v).setGravity(Gravity.CENTER);
                ((TextView) v).setTextColor(Color.parseColor(mLoginStyleRepo.getTextColor()));
                ((TextView) v).setTextSize(25);
                v.setBackgroundColor(Color.parseColor(mLoginStyleRepo.getLayoutColor()));
                return v;
            }
        };
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user = mUsers.get(mSpinner.getSelectedItemPosition());
                if (user.getPossibleLoginTry() <= 0) {
                    disableEditTexts();
                    if (user.isBlocked()) {
                        showErrorDialog(getString(R.string.login_activity_error_user_is_blocked, user.getName(), user.getSurname()), true);
                    } else {
                        long periodInSeconds;
                        if (user.getLastLogin() != null) {
                            periodInSeconds = DateTimeCounter.getPeriodInSeconds(user.getLastLogin());
                        } else {
                            periodInSeconds = 900;
                        }
                        if (periodInSeconds < 900) {
                            showErrorDialog(
                                    getString(
                                            R.string.login_activity_error_acount_temporarily_blocked
                                            , (901 - periodInSeconds) / 60
                                            , 901 - periodInSeconds - (((901 - periodInSeconds) / 60) * 60))
                                    , false);
                        } else {
                            user.setPossibleLoginTry(10);
                            mUserRep.updateUser(user);
                            enableEditTexts();
                        }
                    }
                } else {
                    enableEditTexts();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setSpinnerArray() {
        for (User mUser : mUsers) {
            spinnerArray.add(mUser.getName() + " " + mUser.getSurname());
        }
    }

    private void disableEditTexts() {
        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }

    private void enableEditTexts() {
        for (Button button : buttons) {
            button.setEnabled(true);
        }
    }

    void checkLoginData() {
        int password = Integer.valueOf(passwordBuilder.toString());
        passwordBuilder.delete(0, 4);
        if (password != Integer.valueOf(user.getPassword())) {
            if (DateTimeCounter.getPeriodInSeconds(user.getLastLogin()) > 900) {
                user.setPossibleLoginTry(10);
            }
            user.setPossibleLoginTry(user.getPossibleLoginTry() - 1);
            user.setLastLogin(DateTimeCounter.getDateTime());
            mUserRep.updateUser(user);
            if (user.getPossibleLoginTry() > 0) {
                showErrorDialog(
                        getString(
                                R.string.login_activity_alert_dialog_message
                                , user.getPossibleLoginTry())
                        , false);
            } else {
                disableEditTexts();
                showErrorDialog(
                        getString(
                                R.string.login_activity_alert_dialog_message_account_blocked)
                        , false);
            }
        } else {
            user.setPossibleLoginTry(10);
            user.setLastLogin(DateTimeCounter.getDateTime());
            mUserRep.updateUser(user);
            mCustomRep.setLoginTimestamp(DateTimeCounter.getDateTime());
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("USER_ID", user.getId());
            startActivity(intent);
        }
    }


    void showErrorDialog(String message, boolean cancelable) {
        final AlertDialog.Builder builer = new AlertDialog.Builder(this);
        builer.setTitle(R.string.login_activity_alert_dialog_title);
        builer.setMessage(message);
        builer.setCancelable(cancelable);
        builer.setPositiveButton(R.string.login_activity_alert_dialog_positive_button_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builer.setNegativeButton(R.string.login_activity_alert_dialog_negative_button_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                closeApp();
            }
        });
        builer.show();
    }

    void closeApp() {
        System.exit(0);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        } else if (item.getItemId() == R.id.load_data) {
            new UserAsyncTask(false, spinnerArray, adapter, LoginActivity.this).execute();
            spinnerArray.clear();
            adapter.notifyDataSetChanged();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info_menu, menu);
        return true;
    }

    @OnClick(R.id.login_button_digit_0)
    public void clickedDigit0() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(0);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_1)
    public void clickedDigit1() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(1);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_2)
    public void clickedDigit2() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(2);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_3)
    public void clickedDigit3() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(3);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_4)
    public void clickedDigit4() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(4);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_5)
    public void clickedDigit5() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(5);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_6)
    public void clickedDigit6() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(6);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_7)
    public void clickedDigit7() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(7);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_8)
    public void clickedDigit8() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(8);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_9)
    public void clickedDigit9() {
        if (passwordBuilder.length() < 4) {
            passwordBuilder.append(9);
        }
        if (passwordBuilder.length() >= 4) {
            checkLoginData();
        }
    }

    @OnClick(R.id.login_button_digit_clear)
    public void clickedDigitClear() {
        passwordBuilder.delete(0, passwordBuilder.length());
    }
}
