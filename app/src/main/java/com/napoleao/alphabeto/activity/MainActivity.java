package com.napoleao.alphabeto.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.activity.util.ComponentesAuxiliares;
import com.napoleao.alphabeto.controller.GerenteDeDesafios;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int TEMA_CORES = 0;
    private static final int TEMA_OBJETOS = 1;
    private static final int TEMA_ANIMAIS = 2;
    private static final int TEMA_FRUTAS = 3;
    private static final int TEMA_BRINQUEDOS = 4;
    private static final int TEMA_PARTES_DO_CORPO = 5;
    private static final int TEMA_PAISES = 6;

    private int temaSelecionado;
    private GerenteDeDesafios gerenteDeDesafios;
    private ComponentesAuxiliares componentesAuxiliares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gerenteDeDesafios = new GerenteDeDesafios();
        componentesAuxiliares = new ComponentesAuxiliares();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtCores:
            case R.id.btnCores:
                componentesAuxiliares.impedirDuploClique(this);
                gerenteDeDesafios.ditarPalavra("Cores");
                temaSelecionado = TEMA_CORES;
                invocarIntent();
                break;
            case R.id.txtObjetos:
            case R.id.btnObjetos:
                componentesAuxiliares.impedirDuploClique(this);
                gerenteDeDesafios.ditarPalavra("Objetos");
                temaSelecionado = TEMA_OBJETOS;
                invocarIntent();
                break;
            case R.id.txtAnimais:
            case R.id.btnAnimais:
                componentesAuxiliares.impedirDuploClique(this);
                gerenteDeDesafios.ditarPalavra("Animais");
                temaSelecionado = TEMA_ANIMAIS;
                invocarIntent();
                break;
            case R.id.txtFrutas:
            case R.id.btnFrutas:
                componentesAuxiliares.impedirDuploClique(this);
                gerenteDeDesafios.ditarPalavra("Frutas");
                temaSelecionado = TEMA_FRUTAS;
                invocarIntent();
                break;
            case R.id.txtPaises:
            case R.id.btnPaises:
                componentesAuxiliares.impedirDuploClique(this);
                gerenteDeDesafios.ditarPalavra("Países");
                temaSelecionado = TEMA_PAISES;
                invocarIntent();
                break;
            case R.id.txtBrinquedos:
            case R.id.btnBrinquedos:
                componentesAuxiliares.impedirDuploClique(this);
                gerenteDeDesafios.ditarPalavra("Brinquedos");
                temaSelecionado = TEMA_BRINQUEDOS;
                invocarIntent();
                break;
            case R.id.txtPartesDoCorpo:
            case R.id.btnPartesDoCorpo:
                componentesAuxiliares.impedirDuploClique(this);
                gerenteDeDesafios.ditarPalavra("Partes do Corpo");
                temaSelecionado = TEMA_PARTES_DO_CORPO;
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
