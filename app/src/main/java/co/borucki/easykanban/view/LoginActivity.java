package co.borucki.easykanban.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.easykanban.R;

public class LoginActivity extends AppCompatActivity {
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

        List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Jan Kowalski");
        spinnerArray.add("Jan Nowak");
        spinnerArray.add("Janusz Nowak");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.login_spinner_style, spinnerArray) {
            public @NonNull View   getView(int position, View convertView, @NonNull ViewGroup parent) {

                View v = super.getView(position, convertView, parent);

                ((TextView) v).setTextSize(16);

                return v;

            }

            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {

                View v = super.getDropDownView(position, convertView, parent);

                ((TextView) v).setGravity(Gravity.CENTER);

                return v;

            }

        };
        mSpinner.setAdapter(adapter);
        showSoftKeyboard();
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

    void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();

            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    void checkLoginData() {
        String userName = mSpinner.getSelectedItem().toString();


        int password = Integer.valueOf(mFirstDigit.getText().toString()) * 1000;
        password += Integer.valueOf(mSecondDigit.getText().toString()) * 100;
        password += Integer.valueOf(mThirdDigit.getText().toString()) * 10;
        password += Integer.valueOf(mFourthDigit.getText().toString());


        if (password != 1234) {
            showErrorDialog();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
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

    void showErrorDialog() {
        final AlertDialog.Builder builer = new AlertDialog.Builder(this);
        builer.setTitle(R.string.login_activity_alert_dialog_title);
        builer.setMessage(R.string.login_activity_alert_dialog_message);
        builer.setCancelable(true);
        builer.setPositiveButton(R.string.login_activity_alert_dialog_positive_button_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                resetDigits();
                showSoftKeyboard();
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
}
