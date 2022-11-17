package com.example.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    MaterialButton login_v;
    TextInputLayout lemail_v, lpassword_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_v = findViewById(R.id.login_btn_id);
        lemail_v = findViewById(R.id.email_l_id);
        lpassword_v = findViewById(R.id.password_l_id);

        DBClass dbClass = new DBClass(this);


        login_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = lemail_v.getEditText().getText().toString();
                String Password = lpassword_v.getEditText().getText().toString();

                SharedPreferences pre = getSharedPreferences("auth", MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                editor.putBoolean("flag", true);
                editor.apply();
                boolean validation = dbClass.CheckEmailPassword(Email, Password);
                if (validation == true) {
                    Toast.makeText(LoginActivity.this, "home", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    public void signup(View view) {
        startActivity(new Intent(LoginActivity.this, SignupActivity.class));
    }
}