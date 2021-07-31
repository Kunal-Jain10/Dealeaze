package com.example.dealeaze;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    DatabaseHelper mylogin;
    EditText mEditTextEmail, mEditTextPassword;
    Button mBtnLogin;
    TextView mTextViewRegister,mLogin_Matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mylogin = new DatabaseHelper(this);

        mEditTextEmail = (EditText) findViewById(R.id.editTextEmailAddress);
        mEditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
        mTextViewRegister = (TextView) findViewById(R.id.textViewRegister);
        mLogin_Matcher = (TextView) findViewById(R.id.login_matcher);


        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(loginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEditTextEmail.getText().toString();
                String password = mEditTextPassword.getText().toString();

                DatabaseHelper databaseHelper = new DatabaseHelper(loginActivity.this);

                String psw = databaseHelper.checkPassword(email);

                if (password.equals(psw) && !email.equals("") && !password.equals("")) {
                    Toast.makeText(loginActivity.this, "Welcome !!", Toast.LENGTH_LONG).show();
                    Intent homeIntent = new Intent(loginActivity.this, MainActivity.class);
                    startActivity(homeIntent);
                }
                else {
                    mLogin_Matcher.setVisibility(View.VISIBLE);
                }
            }


        });
}



    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);

        builder.setTitle("Exit?")
                .setMessage("Are you Sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        loginActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No",null);

        AlertDialog alert = builder.create();
        alert.show();
    }
}