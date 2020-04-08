package com.napoleao.alphabeto.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.controller.DesafioFacade;

public class NiveisActivity extends AppCompatActivity implements View.OnClickListener{

    private int temaSelecionado;
    private DesafioFacade desafioFacade;

    int[] botoes = {R.id.txtVogais, R.id.txtConsoantes, R.id.txtAlfabeto};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.niveis_screen);
        super.onCreate(savedInstanceState);

        instanciarTextButtons();

        desafioFacade = new DesafioFacade();

        Bundle extras = getIntent().getExtras();
        temaSelecionado = extras.getInt("tema");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtVogais:
            case R.id.btnVogais:
                desafioFacade.getComponentesAuxiliares().impedirDuploClique(this);
                desafioFacade.ditarPalavra("Vogais");

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        invocarIntent(VogalActivity.class);
                    }
                }, 1300);
                break;

            case R.id.txtConsoantes:
            case R.id.btnConsoantes:
                desafioFacade.getComponentesAuxiliares().impedirDuploClique(this);
                desafioFacade.ditarPalavra("Consoantes");

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        invocarIntent(ConsoanteActivity.class);
                    }
                }, 1300);
                break;

            case R.id.txtAlfabeto:
            case R.id.btnAlfabeto:
                desafioFacade.getComponentesAuxiliares().impedirDuploClique(this);
                desafioFacade.ditarPalavra("Alfabeto");

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        invocarIntent(AlfabetoActivity.class);
                    }
                }, 1300);
                break;

            case R.id.btnVoltarNiveis:
                onBackPressed();
                break;
        }
    }

    /**
     * Mapeia o botão de voltar nativo do Android, para que feche a Activity atual e retorne à
     * Activity anterior.
     */
    @Override
    public void onBackPressed(){
        Intent it = new Intent(NiveisActivity.this, MainActivity.class);
        startActivity(it);
        finish();
    }

    /**
     * Define os ID's dos TextView's e adicionam eventos de clique.
     */
    private void instanciarTextButtons(){
        for (int buttons : botoes) {
            TextView btn = findViewById(buttons);
            btn.setOnClickListener(this);
        }
    }

    /**
     * Abre uma nova Activity.
     * @param novaActivity Activity a ser aberta
     */
    private void invocarIntent(Class novaActivity){
        Intent it = new Intent(NiveisActivity.this, novaActivity);
        it.putExtra("tema", temaSelecionado);
        startActivity(it);
        finish();
    }
}
