package com.napoleao.alphabeto.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.controller.SingletonAudio;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int tema_select;
    private SingletonAudio tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = SingletonAudio.getSingleton(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtCores:
            case R.id.btnCores:
                impedirDuploClique();
                tts.ditarFoto("Cores");
                tema_select = 0;
                invocarIntent();
                break;
            case R.id.txtObjetos:
            case R.id.btnObjetos:
                impedirDuploClique();
                tts.ditarFoto("Objetos");
                tema_select = 1;
                invocarIntent();
                break;
            case R.id.txtAnimais:
            case R.id.btnAnimais:
                impedirDuploClique();
                tts.ditarFoto("Animais");
                tema_select = 2;
                invocarIntent();
                break;
            case R.id.txtFrutas:
            case R.id.btnFrutas:
                impedirDuploClique();
                tts.ditarFoto("Frutas");
                tema_select = 3;
                invocarIntent();
                break;
            case R.id.txtPaises:
            case R.id.btnPaises:
                impedirDuploClique();
                tts.ditarFoto("Países");
                tema_select = 4;
                invocarIntent();
                break;
            case R.id.btnMenuInicial:
                onBackPressed();
        }
    }

    private void invocarIntent(){
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(MainActivity.this, NiveisActivity.class);
                it.putExtra("tema", tema_select);
                startActivity(it);
                finish();
            }
        }, 1300);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    // Desativa a Activity (impedir clique em outro botão)
    public void impedirDuploClique(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

}
