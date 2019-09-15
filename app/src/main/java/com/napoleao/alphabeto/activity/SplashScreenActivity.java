package com.napoleao.alphabeto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.napoleao.alphabeto.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.splash_screen);
        super.onCreate(savedInstanceState);

        //Inserindo tempo de delay para Splash Screen
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarJogo();
            }
        }, 2000);

    }

    protected void mostrarJogo(){
        Intent it = new Intent(SplashScreenActivity.this,  TelaInicialActivity.class);
        startActivity(it);
        finish();
    }
}
