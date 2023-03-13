package com.example.prm392_group5_project_hotelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prm392_group5_project_hotelmanagement.connections.AppDatabase;
import com.example.prm392_group5_project_hotelmanagement.models.User;

public class LoginActivity extends AppCompatActivity {
    private EditText txtPhone, txtPassword;
    private Button btnLogin;

    // variable for shared preferences.
    SharedPreferences sharedpreferences;
    String phone, password;

    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //hide title app
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //add session
        // getting the data which is stored in shared preferences.
        sharedpreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        // default value is
        // set to null if not present.
        phone = sharedpreferences.getString("PHONE", null);
        password = sharedpreferences.getString("PASSWORD", null);

        initUi();

        if(getIntent() != null){
            String register_Toast = getIntent().getStringExtra("Register");
            if(register_Toast != null){
                Toast.makeText(LoginActivity.this,"Register successfully",Toast.LENGTH_LONG).show();
            }
        }
        //event Login click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { login(); }
        });
        //event Sign up click
        signUpClick();
    }

    private void login() {
        String strPhone = txtPhone.getText().toString();
        String strPassword = txtPassword.getText().toString();

        if(!new User().isValidPhone(strPhone) || !new User().isValidPassword(strPassword)){
            Toast.makeText(LoginActivity.this,"Error input. Please re-check your input",Toast.LENGTH_SHORT).show();
            return;
        }

        User findUser = AppDatabase.getInstance(this).userDao().checkLogin(strPhone,strPassword);
        if(findUser ==  null){
            Toast.makeText(LoginActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
            return;
        }
        //Passed login
        Toast.makeText(LoginActivity.this,"Login successfully",Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        // below two lines will put values for
        // email and password in shared preferences.
        editor.putString("PHONE", strPhone);
        editor.putString("PASSWORD", strPassword);

        // to save our data with key and value.
        editor.apply();

        // intent new activity
//        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//        startActivity(i);
//        finish();
    }

    private void initUi(){
        txtPhone = findViewById(R.id.txtPhone);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvHaveAccount);
    }

    private void signUpClick(){
        String text = tvSignUp.getText().toString();

        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        };

        ss.setSpan(clickableSpan,24,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvSignUp.setText(ss);
        tvSignUp.setMovementMethod(LinkMovementMethod.getInstance());
    }
}