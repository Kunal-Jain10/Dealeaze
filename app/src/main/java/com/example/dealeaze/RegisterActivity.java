package com.example.dealeaze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText mEditTextEmail, mEditTextPassword, mEditTextName, mEditTextCnfPassword;
    Button mBtnRegister;
    TextView mTextViewLogin,mNo_match_password,mRegisterChecker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEditTextName = (EditText)findViewById(R.id.editTextName);
        mEditTextEmail = (EditText)findViewById(R.id.editTextEmailAddress);
        mEditTextPassword = (EditText)findViewById(R.id.editTextPassword);
        mEditTextCnfPassword = (EditText)findViewById(R.id.editTextCoPassword);
        mBtnRegister = (Button)findViewById(R.id.btnRegister);
        mTextViewLogin = (TextView)findViewById(R.id.textViewRLogin);
        mNo_match_password = (TextView)findViewById(R.id.No_match_password);
        mRegisterChecker = (TextView)findViewById(R.id.register_checker);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this,loginActivity.class);
                startActivity(loginIntent);
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = mEditTextPassword.getText().toString();
                String cnf_password = mEditTextCnfPassword.getText().toString();
                String userEmail = mEditTextEmail.getText().toString();
                String check_name = mEditTextName.getText().toString();

                DatabaseHelper databaseHelper = new DatabaseHelper(RegisterActivity.this);

                if (password.equals("") || cnf_password.equals("") || userEmail.equals("") || check_name.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Please fill all boxes", Toast.LENGTH_LONG).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    mEditTextEmail.setError("Enter a valid email");
                } else if (password.length() < 8) {
                    mEditTextPassword.setError("Minimum length is 8");
                } else {
                    boolean email_checker = databaseHelper.checkUser(userEmail);

                    if (email_checker == true) {

                        if (!password.equals(cnf_password)) {
                            mNo_match_password.setVisibility(View.VISIBLE);
                        } else {

                            Login_register login_register = new Login_register(mEditTextName.getText().toString(), mEditTextEmail.getText().toString(), mEditTextPassword.getText().toString());

                            boolean success = databaseHelper.insertdata(login_register);

                            Toast.makeText(RegisterActivity.this, "Successfully Registered !!", Toast.LENGTH_LONG).show();
                            Intent loginIntent = new Intent(RegisterActivity.this, loginActivity.class);
                            startActivity(loginIntent);
                        }
                    } else {
                        mRegisterChecker.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}