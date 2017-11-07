package com.hart.team.battleship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainLogin extends AppCompatActivity
    implements OnClickListener {


    private EditText loginName;
    private EditText password;
    private Button btnLogin;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        loginName = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.buttonSignin);
        btnSignup = findViewById(R.id.buttonSignUp);

        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSignin:
                signInUser();
                break;
            case R.id.buttonSignUp:
                signUpUser();
                break;
        }
    }

    private Boolean validateSignIn(){
        if (loginName.getText().toString().isEmpty()) {
            Toast.makeText(this,
                    "You must inform the user login.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.getText().toString().isEmpty()) {
            Toast.makeText(this,
                    "You must inform the user password.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void signInUser() {
        if (validateSignIn()) {
            Toast.makeText(this,
                    "User signed-in",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent("com.hart.team.battleship.Board");
            startActivity(intent);
        }
    }

    private void signUpUser() {
        Toast.makeText(this,
                "Sign-up user",
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent("com.hart.team.battleship.SignUpForm");
        startActivity(intent);
    }
}
