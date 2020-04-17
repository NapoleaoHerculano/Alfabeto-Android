package com.napoleao.alphabeto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.controller.DesafioFacade;
import com.napoleao.alphabeto.controller.JogadorSingleton;
import com.willy.ratingbar.BaseRatingBar;
import com.willy.ratingbar.ScaleRatingBar;

public class FimDeJogoActivity extends AppCompatActivity implements View.OnClickListener {

    private JogadorSingleton jogador = JogadorSingleton.getJogador();
    private int select;
    private DesafioFacade desafioFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_parabens);

        Bundle extras = getIntent().getExtras();
        select = extras.getInt("tema");
        desafioFacade = new DesafioFacade();

        TextView txt = findViewById(R.id.txtFraseFim);

        if(jogador.getPontuacao() <= 1){
            txt.setText("Você é capaz!\nContinue tentando!");
        }else if(jogador.getPontuacao() > 1 && jogador.getPontuacao() <= 2){
            txt.setText("Parabéns!\nVocê foi muito bem!");
        }else if(jogador.getPontuacao() > 2 && jogador.getPontuacao() <= 3){
            txt.setText("Parabéns!\n Você foi demais!");
        }

        final ScaleRatingBar ratingBar = findViewById(R.id.simpleRatingBar);
        ratingBar.setNumStars(3);//Número de estrelas que aparecem
        ratingBar.setMinimumStars(0);//Número mínimo de de estrelas que iniciam preenchidas
        ratingBar.setRating(jogador.getPontuacao());//Número que define o preenchimento das estrelas
        ratingBar.setStarPadding(10);
        ratingBar.setStepSize(0.5f);
        ratingBar.setIsIndicator(false);
        ratingBar.setClickable(false);
        ratingBar.setScrollable(false);
        ratingBar.setClearRatingEnabled(false);
        ratingBar.setEmptyDrawableRes(R.drawable.estrela_vazia);
        ratingBar.setFilledDrawableRes(R.drawable.estrela_preenchida);
        ratingBar.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(BaseRatingBar ratingBar, float rating, boolean fromUser) {
            }
        });
        jogador.resetarPontuacao();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.voltar_temas:
                Intent it = new Intent(FimDeJogoActivity.this, MainActivity.class);
                startActivity(it);
                finish();
                break;
            case R.id.repetir:
                it = new Intent(FimDeJogoActivity.this, NiveisActivity.class);
                it.putExtra("tema", select);
                startActivity(it);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed(){
        desafioFacade.getComponentesAuxiliares().exibirConfirmacaoFechar(this);
    }
}
