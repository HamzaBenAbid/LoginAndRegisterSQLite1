package com.example.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText email, password, confirmpassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        confirmpassword = findViewById(R.id.reg_confirm);
        register = findViewById(R.id.reg_btn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = email.getText().toString();
                String passwordtext = password.getText().toString();
                String confirmtext = confirmpassword.getText().toString();
                if (emailtext.equals("") || passwordtext.equals("") || confirmtext.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG);
                } else {
                    if (passwordtext.equals(confirmtext)) {
                        Boolean chkemail = db.chkeamil(emailtext);
                        if (chkemail == true) {
                            Boolean insert = db.insert(emailtext, passwordtext);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT);

                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email Already exists", Toast.LENGTH_LONG);
                        }
                    }
                    Toast.makeText(getApplicationContext(), "password do not match", Toast.LENGTH_LONG);

                }
            }
        });


    }
}