package com.example.prm392_group5_project_hotelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        //hide title app
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void login() {
        String strPhone = txtPhone.getText().toString();
        String strPassword = txtPassword.getText().toString();

        if(!new User().isValidPhone(strPhone) || !new User().isValidPassword(strPassword)){
            Toast.makeText(LoginActivity.this,"Error input. Please re-check your input",Toast.LENGTH_LONG).show();
            return;
        }

        User findUser = AppDatabase.getInstance(this).userDao().checkLogin(strPhone,strPassword);
        if(findUser ==  null){
            Toast.makeText(LoginActivity.this,"Authentication failed",Toast.LENGTH_LONG).show();
            return;
        }

        //Passed login

        Toast.makeText(LoginActivity.this,"Login successfully",Toast.LENGTH_LONG).show();

    }

    private void initUi(){
        txtPhone = findViewById(R.id.txtPhone);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin = findViewById(R.id.btnLogin);
    }

    private void signUpClick(){
        TextView textView = findViewById(R.id.tvHaveAccount);
        String text = "Don't have any account? Sign up";

        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        };

        ss.setSpan(clickableSpan,24,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}