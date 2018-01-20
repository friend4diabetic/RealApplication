package com.example.yggdrasil.realapplication;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.yggdrasil.realapplication.DatabaseHelper.DBHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yggdrasil on 20/1/2561.
 */

public class LoginActivity extends AppCompatActivity{

    private TextInputLayout emailInputLayout;
    private TextInputLayout passwordInputLayout;
    private String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;
    private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailInputLayout = (TextInputLayout) findViewById(R.id.activity_login_emailInputLayout);
        passwordInputLayout = (TextInputLayout) findViewById(R.id.activity_login_passwordInputLayout);
        button = (Button) findViewById(R.id.activity_login_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //hideKeyboard();
                String Email = emailInputLayout.getEditText().getText().toString();
                String Password = passwordInputLayout.getEditText().getText().toString();
                if (!validateEmail(Email)) {
                    emailInputLayout.setError("Not a valid email address!");
                } else {
                    emailInputLayout.setErrorEnabled(false);
                    passwordInputLayout.setErrorEnabled(false);
                    login(Email, Password);
                }
            }
        });
    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void login(String email, String password){
        DBHelper dbHelper = new DBHelper(this);
        if( dbHelper.searchEmail(email, 1) ){

        }

    }


}
