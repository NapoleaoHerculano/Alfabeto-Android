package com.napoleao.alphabeto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.napoleao.alphabeto.R;

public class NiveisActivity extends AppCompatActivity implements View.OnClickListener{

    int select;

    int[] botoes = {R.id.txtVogais, R.id.txtConsoantes, R.id.txtAlfabeto};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.niveis_screen);
        super.onCreate(savedInstanceState);

        instanciarBotoes();

        Bundle extras = getIntent().getExtras();
        select = extras.getInt("tema");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtVogais:
            case R.id.btnVogais:
                Intent it = new Intent(NiveisActivity.this, VogalActivity.class);
                it.putExtra("tema", select);
                startActivity(it);
                finish();
                break;
            case R.id.txtConsoantes:
            case R.id.btnConsoantes:
                it = new Intent(NiveisActivity.this, ConsoanteActivity.class);
                it.putExtra("tema", select);
                startActivity(it);
                finish();
                break;
            case R.id.txtAlfabeto:
            case R.id.btnAlfabeto:
                it = new Intent(NiveisActivity.this, AlfabetoActivity.class);
                it.putExtra("tema", select);
                startActivity(it);
                finish();
                break;
        }
    }

    public void instanciarBotoes(){
        int i;
        for(i = 0; i < botoes.length; i++){
            TextView btn = findViewById(botoes[i]);
            btn.setOnClickListener(this);
        }
    }
}
