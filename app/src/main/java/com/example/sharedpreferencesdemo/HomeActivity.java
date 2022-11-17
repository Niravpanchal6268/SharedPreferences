package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences pre = getSharedPreferences("auth",MODE_PRIVATE);
        SharedPreferences.Editor editor= pre.edit();
        editor.putBoolean("flag",true);
        editor.apply();

    }

    public void logout(View view) {
        setContentView(R.layout.activity_home);
        SharedPreferences pre = getSharedPreferences("auth",MODE_PRIVATE);
        SharedPreferences.Editor editor= pre.edit();
        editor.putBoolean("flag",false);
        editor.apply();
        startActivity(new Intent(HomeActivity.this,LoginActivity.class));
    }

}