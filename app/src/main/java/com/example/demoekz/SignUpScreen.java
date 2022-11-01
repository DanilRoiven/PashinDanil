package com.example.demoekz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class SignUpScreen extends AppCompatActivity {
    private EditText name;
    private EditText lastname;
    private EditText email;
    private EditText password;
    private EditText rep_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
    }
    public void signUpCheck(View view){
        name = findViewById(R.id.namefield);
        lastname = findViewById(R.id.lastnamefield);
        email = findViewById(R.id.emailFieldSignUp);
        password = findViewById(R.id.passwordFieldSignUp);
        rep_password = findViewById(R.id.passwordFieldRepeatSignUp);
        if(name.getText().toString().length()>1 && lastname.getText().toString().length()>1 && email.getText().toString().length()>1 && password.getText().toString().length()>1 && rep_password.getText().toString().length()>1) {
            Intent intent = new Intent(this, SignInScreen.class);
            startActivity(intent);
        }
        else {
            FragmentManager manager = getSupportFragmentManager();
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            myDialogFragment.show(manager, "myDialog");
        }
    }
    public void startSignIn(){
        Intent intent = new Intent(this, SignInScreen.class);
        startActivity(intent);
    }
}