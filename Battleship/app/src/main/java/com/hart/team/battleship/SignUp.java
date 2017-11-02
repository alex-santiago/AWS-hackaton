package com.hart.team.battleship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity
    implements View.OnClickListener {

    private EditText loginEmail;
    private EditText password;
    private EditText passwordConfirm;
    private Button btnOkay;
    private Button btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        loginEmail = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        passwordConfirm = findViewById(R.id.editConfirmPassword);
        btnOkay = findViewById(R.id.buttonOkay);
        btnCancel = findViewById(R.id.buttonCancel);

        btnOkay.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonOkay:
                if (validateSignUp()) {
                    signUpUser();
                    returnToSignIn();
                }
                break;
            case R.id.buttonCancel:
                returnToSignIn();
                break;
        }
    }

    private void returnToSignIn(){
        finish();
    }

    private Boolean validateSignUp(){
        if (loginEmail.getText().toString().isEmpty()) {
            Toast.makeText(this,
                    "You must inform the e-mail for user login.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (this.password.getText().toString().isEmpty()) {
            Toast.makeText(this,
                    "You must inform the user password.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (this.passwordConfirm.getText().toString().isEmpty()) {
            Toast.makeText(this,
                    "You must confirm the user password.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(this.password.getText().toString().equals(this.passwordConfirm.getText().toString()))) {
            Toast.makeText(this,
                    "The password confirmation does not match the informed password.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(this,
                "User signed-up.",
                Toast.LENGTH_SHORT).show();
        return true;

    }

    private void signUpUser(){

    }

}
