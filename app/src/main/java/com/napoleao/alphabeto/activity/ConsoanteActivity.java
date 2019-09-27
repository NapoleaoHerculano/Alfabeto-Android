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
import com.napoleao.alphabeto.controller.DesafioSingleton;
import com.napoleao.alphabeto.controller.FabricaTemas;
import com.napoleao.alphabeto.controller.JogadorSingleton;
import com.napoleao.alphabeto.controller.SingletonAudio;
import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;


public class ConsoanteActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imagem;
    private TextView txtQuiz;
    private char alternativa;
    private FabricaTemas temas;
    private ArrayList<Tema> listTema;
    private DesafioSingleton desafioSingleton;
    int select;
    char[] desafio;//Array responsável por guardar e atualizar o desafio de acordo com as respostas
    boolean acertou;
    int indice;
    private SingletonAudio tts;
    private JogadorSingleton jogador;


    int[] botoes = {R.id.btnB,R.id.btnC,R.id.btnD,R.id.btnF,R.id.btnG,R.id.btnH,R.id.btnJ,R.id.btnK,R.id.btnL,
            R.id.btnM,R.id.btnN,R.id.btnP,R.id.btnQ,R.id.btnR,R.id.btnS,R.id.btnT,R.id.btnV,R.id.btnW,R.id.btnX,
            R.id.btnY,R.id.btnZ};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_model_consoantes);

        //Inicialização das classes e variaveis
        listTema = new ArrayList<>();
        temas = new FabricaTemas(listTema);
        desafioSingleton = desafioSingleton.getSingleton();
        acertou = false;
        indice = 0;
        tts = tts.getSingleton(this);
        jogador = jogador.getJogador();

        instanciarBotoes();

        //Pegando o tema escolhido
        Bundle extras = getIntent().getExtras();
        select = extras.getInt("tema");

        //Carregando os temas de acordo com a escolha
        temas.escolhaDeTema(select);
        listTema = desafioSingleton.carregarTemas(listTema);

        //Instanciando a interface
        imagem = findViewById(R.id.imageConsoante);
        txtQuiz = findViewById(R.id.textConsoante);

        //Definindo os primeiros elementos a serem iniciados
        imagem.setImageResource(listTema.get(indice).getImagem());
        txtQuiz.setText(desafioSingleton.definirPalavraConsoante(desafioSingleton.dandoEspacos(listTema.get(indice).getNomeImagem())));
        desafio = desafioSingleton.definirPalavraConsoante(listTema.get(indice).getNomeImagem()).toCharArray();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnB:
                alternativa = 'B';
                verificaResposta(alternativa);
                break;
            case R.id.btnC:
                alternativa = 'C';
                verificaResposta(alternativa);
                break;
            case R.id.btnD:
                alternativa = 'D';
                verificaResposta(alternativa);
                break;
            case R.id.btnF:
                alternativa = 'F';
                verificaResposta(alternativa);
                break;
            case R.id.btnG:
                alternativa = 'G';
                verificaResposta(alternativa);
                break;
            case R.id.btnH:
                alternativa = 'H';
                verificaResposta(alternativa);
                break;
            case R.id.btnJ:
                alternativa = 'J';
                verificaResposta(alternativa);
                break;
            case R.id.btnK:
                alternativa = 'K';
                verificaResposta(alternativa);
                break;
            case R.id.btnL:
                alternativa = 'L';
                verificaResposta(alternativa);
                break;
            case R.id.btnM:
                alternativa = 'M';
                verificaResposta(alternativa);
                break;
            case R.id.btnN:
                alternativa = 'N';
                verificaResposta(alternativa);
                break;
            case R.id.btnP:
                alternativa = 'P';
                verificaResposta(alternativa);
                break;
            case R.id.btnQ:
                alternativa = 'Q';
                verificaResposta(alternativa);
                break;
            case R.id.btnR:
                alternativa = 'R';
                verificaResposta(alternativa);
                break;
            case R.id.btnS:
                alternativa = 'S';
                verificaResposta(alternativa);
                break;
            case R.id.btnT:
                alternativa = 'T';
                verificaResposta(alternativa);
                break;
            case R.id.btnV:
                alternativa = 'V';
                verificaResposta(alternativa);
                break;
            case R.id.btnW:
                alternativa = 'W';
                verificaResposta(alternativa);
                break;
            case R.id.btnX:
                alternativa = 'X';
                verificaResposta(alternativa);
                break;
            case R.id.btnY:
                alternativa = 'Y';
                verificaResposta(alternativa);
                break;
            case R.id.btnZ:
                alternativa = 'Z';
                verificaResposta(alternativa);
                break;
        }
    }

    public void falarImagem(View v){
        tts.ditarFoto(listTema.get(indice).getNomeImagem());

    }

    private void verificaResposta(char alternativa){
        String resposta = desafioSingleton.verificarAlternativa(this, alternativa,listTema.get(indice).getNomeImagem(),desafio, jogador);
        txtQuiz.setText(desafioSingleton.dandoEspacos(resposta));

        acertou = desafioSingleton.verificaResposta(listTema.get(indice).getNomeImagem(), resposta);
        if (acertou == true){
            desafioSingleton.acertou(this);
            indice++;
            if(indice == listTema.size()) {
                Intent it = new Intent(ConsoanteActivity.this, FimDeJogoActivity.class);
                it.putExtra("tema", select);
                startActivity(it);
                finish();
            }else if(indice < listTema.size()){
                Handler handle = new Handler();
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        desafioSingleton.setAtributosConsoantes(imagem, txtQuiz, listTema, indice);
                        desafio = desafioSingleton.definirPalavraConsoante(listTema.get(indice).getNomeImagem()).toCharArray();
                        //Mudando o desafio. Para isso é chamado o método que seta a quantidade de espaços que formam a palavra
                        txtQuiz.setText(desafioSingleton.definirPalavraConsoante(desafioSingleton.dandoEspacos(listTema.get(indice).getNomeImagem())));
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

}