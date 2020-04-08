package com.napoleao.alphabeto.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.controller.DesafioFacade;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int TEMA_CORES = 0;
    private static final int TEMA_OBJETOS = 1;
    private static final int TEMA_ANIMAIS = 2;
    private static final int TEMA_FRUTAS = 3;
    private static final int TEMA_PAISES = 4;

    private int temaSelecionado;
    private DesafioFacade desafioFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        desafioFacade = new DesafioFacade();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtCores:
            case R.id.btnCores:
                desafioFacade.getComponentesAuxiliares().impedirDuploClique(this);
                desafioFacade.ditarPalavra("Cores");
                temaSelecionado = TEMA_CORES;
                invocarIntent();
                break;
            case R.id.txtObjetos:
            case R.id.btnObjetos:
                desafioFacade.getComponentesAuxiliares().impedirDuploClique(this);
                desafioFacade.ditarPalavra("Objetos");
                temaSelecionado = TEMA_OBJETOS;
                invocarIntent();
                break;
            case R.id.txtAnimais:
            case R.id.btnAnimais:
                desafioFacade.getComponentesAuxiliares().impedirDuploClique(this);
                desafioFacade.ditarPalavra("Animais");
                temaSelecionado = TEMA_ANIMAIS;
                invocarIntent();
                break;
            case R.id.txtFrutas:
            case R.id.btnFrutas:
                desafioFacade.getComponentesAuxiliares().impedirDuploClique(this);
                desafioFacade.ditarPalavra("Frutas");
                temaSelecionado = TEMA_FRUTAS;
                invocarIntent();
                break;
            case R.id.txtPaises:
            case R.id.btnPaises:
                desafioFacade.getComponentesAuxiliares().impedirDuploClique(this);
                desafioFacade.ditarPalavra("Países");
                temaSelecionado = TEMA_PAISES;
                invocarIntent();
                break;
            case R.id.btnMenuInicial:
                onBackPressed();
        }
    }

    /**
     * Abre a Activity de Níveis passando o tema selecionado.
     */
    private void invocarIntent(){
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(MainActivity.this, NiveisActivity.class);
                it.putExtra("tema", temaSelecionado);
                startActivity(it);
                finish();
            }
        }, 1300);
    }

    /**
     * Mapeia o botão de voltar nativo do Android, para que feche a Activity atual e retorne à
     * Activity anterior.
     */
    @Override
    public void onBackPressed() {
        finish();
    }

}
