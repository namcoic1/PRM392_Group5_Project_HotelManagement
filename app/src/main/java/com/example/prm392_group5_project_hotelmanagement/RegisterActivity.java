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

public class RegisterActivity extends AppCompatActivity {
    private EditText txtName ,txtPhone, txtPassword, txtRePassword;
    private Button btnRegister;
    private TextView tvArrowBack, tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initUi();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { register(); }
        });

        //event back click
        arrowBackClick();
        //event Sign in click
        signInClick();
        //hide title app
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void register() {
        String strName = txtName.getText().toString().trim();
        String strPhone = txtPhone.getText().toString().trim();
        String strPassword = txtPassword.getText().toString().trim();
        String strRePassword = txtRePassword.getText().toString().trim();

        if(strName.isEmpty() || strRePassword.isEmpty()) {
            Toast.makeText(RegisterActivity.this,"Error input. Please re-check your input",Toast.LENGTH_LONG).show();
            return;
        }

        if(!new User().isValidPhone(strPhone) || !new User().isValidPassword(strPassword) ){
            Toast.makeText(RegisterActivity.this,"Your phone or password is not valid. Please re-check your input",Toast.LENGTH_LONG).show();
            return;
        }

        if(!strPassword.trim().equals(strRePassword.trim())){
            Toast.makeText(RegisterActivity.this,"Your password is not matched. Please re-check your input",Toast.LENGTH_LONG).show();
            return;
        }
        //Register successful
        AppDatabase.getInstance(this).userDao().register(strPhone,strPassword,strName);
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        intent.putExtra("Register","Successful");
        startActivity(intent);
        finish();
    }

    private void initUi(){
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhoneR);
        txtPassword = findViewById(R.id.txtPasswordR);
        txtRePassword = findViewById(R.id.txtRePassword);

        btnRegister = findViewById(R.id.btnRegister);
        tvArrowBack = findViewById(R.id.tvArrowBack);
        tvSignIn = findViewById(R.id.tvAnyAccount);
    }

    private void arrowBackClick() {
        tvArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void signInClick() {
        String text = tvSignIn.getText().toString();
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        ss.setSpan(clickableSpan,26,33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvSignIn.setText(ss);
        tvSignIn.setMovementMethod(LinkMovementMethod.getInstance());
    }
}