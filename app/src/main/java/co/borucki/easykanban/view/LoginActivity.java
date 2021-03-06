package co.borucki.easykanban.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    @BindView(R.id.login_activity_spinner)
    Spinner mSpinner;
    @BindView(R.id.login_first_digit)
    EditText mFirstDigit;
    @BindView(R.id.login_second_digit)
    EditText mSecondDigit;
    @BindView(R.id.login_third_digit)
    EditText mThirdDigit;
    @BindView(R.id.login_fourth_digit)
    EditText mFourthDigit;
    @BindView(R.id.login_tool_bar)
    Toolbar navigationToolBar;

    @Override
    protected void onStop() {
        super.onStop();
        hideKeyboard();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideKeyboard();
    }

    @Override
    protected void onPause() {
        super.onPause();
        hideKeyboard();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideKeyboard();
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
            hideKeyboard();
            showErrorDialog(getString(R.string.login_activity_no_users_loaded), false, false);
        }

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
                        hideKeyboard();
                        disableEditTexts();
                        if (user.isBlocked()) {
                            showErrorDialog(getString(R.string.login_activity_error_user_is_blocked, user.getName(), user.getSurname()), true, false);
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
                                        , false, false);
                            } else {
                                user.setPossibleLoginTry(10);
                                mUserRep.updateUser(user);
                                enableEditTexts();
                                showSoftKeyboard();
                            }
                        }
                    } else {
                        showSoftKeyboard();
                        enableEditTexts();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

        mFirstDigit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mSecondDigit.requestFocus();
            }
        });
        mSecondDigit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mThirdDigit.requestFocus();
            }
        });
        mThirdDigit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mFourthDigit.requestFocus();
            }
        });
        mFourthDigit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mFourthDigit.getText().length() >= 1) {
                    hideKeyboard();
                    if (mFirstDigit.getText().length() == 1
                            && mSecondDigit.getText().length() == 1
                            && mThirdDigit.getText().length() == 1
                            && mFourthDigit.getText().length() == 1) {
                        checkLoginData();
                    }
                }
            }
        });
    }

    private void setSpinnerArray() {
        for (User mUser : mUsers) {
            spinnerArray.add(mUser.getName() + " " + mUser.getSurname());
        }
    }

    private void disableEditTexts() {
        mFirstDigit.setEnabled(false);
        mSecondDigit.setEnabled(false);
        mThirdDigit.setEnabled(false);
        mFourthDigit.setEnabled(false);
    }

    private void enableEditTexts() {
        mFirstDigit.setEnabled(true);
        mSecondDigit.setEnabled(true);
        mThirdDigit.setEnabled(true);
        mFourthDigit.setEnabled(true);
    }

    void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    void checkLoginData() {
        int password = Integer.valueOf(mFirstDigit.getText().toString()) * 1000;
        password += Integer.valueOf(mSecondDigit.getText().toString()) * 100;
        password += Integer.valueOf(mThirdDigit.getText().toString()) * 10;
        password += Integer.valueOf(mFourthDigit.getText().toString());

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
                        , false, true);
            } else {
                disableEditTexts();
                showErrorDialog(
                        getString(
                                R.string.login_activity_alert_dialog_message_account_blocked)
                        , false, false);
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

    void resetDigits() {
        mFirstDigit.setText("");
        mSecondDigit.setText("");
        mThirdDigit.setText("");
        mFourthDigit.setText("");
        mFourthDigit.clearFocus();
        mFirstDigit.requestFocus(1);
    }

    void showErrorDialog(String message, boolean cancelable, final boolean keyboard) {
        final AlertDialog.Builder builer = new AlertDialog.Builder(this);
        builer.setTitle(R.string.login_activity_alert_dialog_title);
        builer.setMessage(message);
        builer.setCancelable(cancelable);
        builer.setPositiveButton(R.string.login_activity_alert_dialog_positive_button_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                resetDigits();
                if (keyboard) showSoftKeyboard();
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

    void showSoftKeyboard() {
        mFirstDigit.requestFocus();
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                .toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
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
}