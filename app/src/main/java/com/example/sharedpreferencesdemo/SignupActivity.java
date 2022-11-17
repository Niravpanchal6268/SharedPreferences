package com.example.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {

    MaterialButton signup_v;
    TextInputLayout name_v, email_v, password_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup_v = findViewById(R.id.signup_btn_id);
        name_v = findViewById(R.id.name_s_id);
        email_v = findViewById(R.id.Email_s_id);
        password_v = findViewById(R.id.password_s_id);
        signup_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBClass dbClass = new DBClass(SignupActivity.this);
                String Name = name_v.getEditText().getText().toString();
                String Email = email_v.getEditText().getText().toString();
                String Password = password_v.getEditText().getText().toString();
                String err = "Please fill all the filed";




                if (Name.isEmpty() || Email.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "fill all the fild", Toast.LENGTH_SHORT).show();
                    name_v.setError(err);
                    email_v.setError(err);
                    password_v.setError(err);


                } else {
                    name_v.getEditText().setError(null);
                    email_v.getEditText().setError(null);
                    password_v.getEditText().setError(null);
                    name_v.setErrorEnabled(false);
                    password_v.setErrorEnabled(false);
                    email_v.setErrorEnabled(false);

                   boolean insert =dbClass.InsertData(Name,Email,Password);
                    if (insert==true)
                    {
                        Toast.makeText(SignupActivity.this, "fail", Toast.LENGTH_SHORT).show();


                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this, "Sign up", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                        finish();
                    }


                    Toast.makeText(SignupActivity.this, "f", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}