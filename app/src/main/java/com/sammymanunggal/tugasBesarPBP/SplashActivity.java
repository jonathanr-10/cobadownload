package com.sammymanunggal.tugasBesarPBP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.sammymanunggal.tugasBesarPBP.model.MainActivity;
import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.SignIn;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int SPLASH_TIME=3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences mSettings = getApplicationContext().getSharedPreferences("MyPref2", Context.MODE_PRIVATE);
                int isLogin = mSettings.getInt("isLogin",-1);
                if(isLogin == 1){
                    Intent intent= new Intent(SplashActivity.this, MainActivity.class); //SignIn Class
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                }else{
                    Intent intent= new Intent(SplashActivity.this, SignIn.class); //SignIn Class
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                }


            }
        }, SPLASH_TIME);
    }
}