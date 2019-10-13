package com.napoleao.alphabeto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.controller.SingletonAudio;

public class NiveisActivity extends AppCompatActivity implements View.OnClickListener{

    private int tema_select;
    private SingletonAudio tts;

    int[] botoes = {R.id.txtVogais, R.id.txtConsoantes, R.id.txtAlfabeto};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.niveis_screen);
        super.onCreate(savedInstanceState);

        instanciarBotoes();

        Bundle extras = getIntent().getExtras();

        tts = SingletonAudio.getSingleton(this);
        tema_select = extras.getInt("tema");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtVogais:
            case R.id.btnVogais:
                impedirDuploClique();
                tts.ditarFoto("Vogais");

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent it = new Intent(NiveisActivity.this, VogalActivity.class);
                        it.putExtra("tema", tema_select);
                        startActivity(it);
                        finish();
                    }
                }, 1300);
                break;

            case R.id.txtConsoantes:
            case R.id.btnConsoantes:
                impedirDuploClique();
                tts.ditarFoto("Consoantes");

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent it = new Intent(NiveisActivity.this, ConsoanteActivity.class);
                        it.putExtra("tema", tema_select);
                        startActivity(it);
                        finish();
                    }
                }, 1300);
                break;

            case R.id.txtAlfabeto:
            case R.id.btnAlfabeto:
                impedirDuploClique();
                tts.ditarFoto("Alfabeto");

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent it = new Intent(NiveisActivity.this, AlfabetoActivity.class);
                        it.putExtra("tema", tema_select);
                        startActivity(it);
                        finish();
                    }
                }, 1300);
                break;

            case R.id.btnVoltarNiveis:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed(){
        Intent it = new Intent(NiveisActivity.this, MainActivity.class);
        startActivity(it);
        finish();
    }

    public void instanciarBotoes(){
        int i;
        for(i = 0; i < botoes.length; i++){
            TextView btn = findViewById(botoes[i]);
            btn.setOnClickListener(this);
        }
    }

    // Desativa a Activity (impedir clique em outro botão)
    public void impedirDuploClique(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }
}
