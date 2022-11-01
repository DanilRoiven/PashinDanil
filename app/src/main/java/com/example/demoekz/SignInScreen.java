package com.example.demoekz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInScreen extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login; // кнопка "Войти"
    private TextView loginLocked;
    private TextView attempts;
    private TextView numberOfAttempts;

    int numberOfRemainingLoginAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        email = (EditText) findViewById(R.id.emailFieldSignIn);
        password = (EditText) findViewById(R.id.passwordFieldSignIn);
        login = (Button) findViewById(R.id.btnSignIn);
        loginLocked = (TextView) findViewById(R.id.logLock);
        attempts = (TextView) findViewById(R.id.attemptsCounter);
        numberOfAttempts = (TextView) findViewById(R.id.attemptsCount);
        numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

    }

    public void Login(View view){
        if (email.getText().toString().equals("pashin@bk.ru") && password.getText().toString().equals("123")){
            Toast.makeText(getApplicationContext(), "Вход выполнен", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignInScreen.this,MainScreen.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Неправильные данные", Toast.LENGTH_SHORT).show();
            numberOfRemainingLoginAttempts--;

            attempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

            if (numberOfRemainingLoginAttempts == 0){
                login.setEnabled(false);
                loginLocked.setVisibility(View.VISIBLE);
                loginLocked.setBackgroundColor(Color.RED);
                loginLocked.setText("Вход заблокирован");
            }
        }
    }
    public void startNewActivity(View view){
        Intent intent = new Intent(this, SignUpScreen.class);
        startActivity(intent);
    }
    public void startActiv(View view){
        Intent intent = new Intent(this, ImageNet.class);
        startActivity(intent);
    }
}