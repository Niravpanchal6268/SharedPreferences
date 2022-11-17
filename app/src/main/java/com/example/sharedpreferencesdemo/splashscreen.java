package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pre = getSharedPreferences("auth",MODE_PRIVATE);
                Intent inext;
                boolean check= pre.getBoolean("flag",false);

                if (check)
                {       //for true (user login in)
                    Toast.makeText(splashscreen.this, "user", Toast.LENGTH_SHORT).show();
                    inext= new Intent(splashscreen.this,HomeActivity.class);
                }
                else
                {   //for false (user first time loigin )
                    Toast.makeText(splashscreen.this, "first time login", Toast.LENGTH_SHORT).show();
                    inext=new Intent(splashscreen.this,LoginActivity.class);
                }
                startActivity(inext);

            }
        },2000);
    }
}