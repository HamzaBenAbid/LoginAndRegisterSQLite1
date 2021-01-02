package com.example.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText email ,password ;
Button login;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
        email=findViewById(R.id.log_email);
        password=findViewById(R.id.log_password);
        login=findViewById(R.id.log_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext =email.getText().toString();
                String passwordtext =password.getText().toString();
                Boolean chkemailpassword =db.emailpassword(emailtext,passwordtext);
                if (chkemailpassword==true){
                    Toast.makeText(getApplicationContext(), "Successfully login ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "wrong email or email ", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}