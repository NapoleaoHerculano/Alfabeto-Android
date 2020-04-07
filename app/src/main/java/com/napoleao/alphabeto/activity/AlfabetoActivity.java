package com.napoleao.alphabeto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.config.AppConfig;
import com.napoleao.alphabeto.controller.DesafioFacade;
import com.napoleao.alphabeto.controller.FabricaTemas;
import com.napoleao.alphabeto.controller.JogadorSingleton;
import com.napoleao.alphabeto.controller.SingletonAudio;
import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;

public class AlfabetoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imagem;
    private TextView txtQuiz;
    private FabricaTemas temas;
    private ArrayList<Tema> listTema;
    private DesafioFacade desafioFacade;
    private int select;
    private final int TEMA_SELECT = 2;
    private char[] desafio;//Array responsável por guardar e atualizar o desafio de acordo com as respostas
    private boolean acertou;
    private int indice;
    private JogadorSingleton jogador;

    int[] botoes = {R.id.btnA,R.id.btnB,R.id.btnC,R.id.btnD,R.id.btnE,R.id.btnF,R.id.btnG,R.id.btnH,R.id.btnI,R.id.btnJ,R.id.btnK,R.id.btnL,
            R.id.btnM,R.id.btnN,R.id.btnO,R.id.btnP,R.id.btnQ,R.id.btnR,R.id.btnS,R.id.btnT,R.id.btnU,R.id.btnV,R.id.btnW,R.id.btnX,R.id.btnY,
            R.id.btnZ};
    private View botoesAlfabeto;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_model_alfabeto);

        listTema = new ArrayList<>();
        temas = new FabricaTemas(listTema);
        desafioFacade = new DesafioFacade();
        indice = 0;
        jogador = jogador.getJogador();

        instanciarBotoes();

        Bundle extras = getIntent().getExtras();
        select = extras.getInt("tema");

        //Carregando os temas de acordo com a escolha
        temas.escolhaDeTema(select);
        listTema = desafioFacade.carregarTemas(listTema, TEMA_SELECT);

        imagem = findViewById(R.id.imageAlfabeto);
        txtQuiz = findViewById(R.id.textAlfabeto);
        botoesAlfabeto = findViewById(R.id.botoesAlfabeto);

        //Definindo os primeiros elementos a serem iniciados
        imagem.setImageResource(listTema.get(indice).getImagem());
        txtQuiz.setText(desafioFacade.definirPalavraAlfabeto(desafioFacade.dandoEspacos(listTema.get(indice).getNomeImagem())));
        desafio = desafioFacade.definirPalavraAlfabeto(listTema.get(indice).getNomeImagem()).toCharArray();
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String alternativa = button.getText().toString();
        verificaResposta(alternativa.charAt(0));
    }

    //Método que fala o nome da imagem que está sendo mostrada
    public void falarImagem(View v){
        desafioFacade.falarImagem(listTema, indice);
    }

    //Método que veriifica se a reposta está correta
    private void verificaResposta(char alternativa){
        String resposta = desafioFacade.verificarAlternativa(this, alternativa,listTema.get(indice).getNomeImagem(),desafio, jogador);
        txtQuiz.setText(desafioFacade.dandoEspacos(resposta));

        acertou = desafioFacade.verificaResposta(listTema.get(indice).getNomeImagem(), resposta);
        if (acertou){
            desafioFacade.acertou(this, AppConfig.getInstance(this).getCurrentSound());
            indice++;
            if(indice == listTema.size()) {
                Intent it = new Intent(AlfabetoActivity.this, FimDeJogoActivity.class);
                it.putExtra("tema", select);
                startActivity(it);
                finish();
            }else if(indice < listTema.size()){
                desafioFacade.getComponentesAuxiliares().desligarBotoes(botoes, botoesAlfabeto);
                Handler handle = new Handler();
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        desafioFacade.setAtributosAlfabeto(imagem, txtQuiz, listTema, indice);
                        desafio = desafioFacade.definirPalavraAlfabeto(listTema.get(indice).getNomeImagem()).toCharArray();
                        //Mudando o desafio. Para isso é chamado o método que seta a quantidade de espaços que formam a palavra
                        txtQuiz.setText(desafioFacade.definirPalavraAlfabeto(desafioFacade.dandoEspacos(listTema.get(indice).getNomeImagem())));
                        desafioFacade.getComponentesAuxiliares().ligarBotoes(botoes, botoesAlfabeto);
                    }
                }, 2000);
            }
        }
    }

    public void instanciarBotoes(){
        int i;
        for(i = 0; i < botoes.length; i++){
            Button btn = findViewById(botoes[i]);
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onBackPressed(){
        desafioFacade.getComponentesAuxiliares().exibirConfirmacaoVoltar(this);
    }

    public void voltarAlfabeto(View v){
        onBackPressed();
    }

    public void fecharAlfabeto(View v){
        desafioFacade.getComponentesAuxiliares().exibirConfirmacaoFechar(this);
    }

}
