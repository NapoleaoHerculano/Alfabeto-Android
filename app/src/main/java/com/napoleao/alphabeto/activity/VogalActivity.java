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


public class VogalActivity extends AppCompatActivity implements View.OnClickListener {
    //Componentes da interface
    private ImageView imagem;
    private TextView txtQuiz;
    //----------------------------------------------------------------------------------------------//
    private char alternativa;//Armazena o caractere pressionado no botão
    private FabricaTemas temas;//Classe responsável por instanciar o tema escolhido
    private ArrayList<Tema> listTema;//Lista com os temas carregados
    private DesafioSingleton desafioSingleton;//Classe responsável pela lógica do aplicativo
    int select;//Valor que indica qual o tema a ser carregado
    char[] desafio;//Array responsável por guardar e atualizar o desafio de acordo com as respostas
    private boolean acertou;
    private int indice;
    private SingletonAudio tts;
    private Button btn;
    private JogadorSingleton jogador;

    int[] botoes = {R.id.btnA,R.id.btnE,R.id.btnI,R.id.btnO,R.id.btnU};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_model_vogais);

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
        imagem = findViewById(R.id.imageVogal);
        txtQuiz = findViewById(R.id.txtQuiz);

        //Definindo os primeiros elementos a serem iniciados
        imagem.setImageResource(listTema.get(indice).getImagem());
        txtQuiz.setText(desafioSingleton.dandoEspacos(desafioSingleton.definirPalavraVogal(listTema.get(indice).getNomeImagem())));
        desafio = desafioSingleton.definirPalavraVogal(listTema.get(indice).getNomeImagem()).toCharArray();

    }

    @Override
    public void onClick(View v) {
        btn = findViewById(v.getId());
        switch (v.getId()){
            case R.id.btnA:
                alternativa = 'A';
                verificaResposta(alternativa);
                break;
            case R.id.btnE:
                alternativa = 'E';
                verificaResposta(alternativa);
                break;
            case R.id.btnI:
                alternativa = 'I';
                verificaResposta(alternativa);
                break;
            case R.id.btnO:
                alternativa = 'O';
                verificaResposta(alternativa);
                break;
            case R.id.btnU:
                alternativa = 'U';
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
                Intent it = new Intent(VogalActivity.this, FimDeJogoActivity.class);
                it.putExtra("tema", select);
                startActivity(it);
                finish();
            }else if(indice < listTema.size()){
                desligarBotoes();
                Handler handle = new Handler();
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        desafioSingleton.setAtributosVogais(imagem, txtQuiz, listTema, indice);
                        desafio = desafioSingleton.definirPalavraVogal(listTema.get(indice).getNomeImagem()).toCharArray();
                        //Mudando o desafio. Para isso é chamado o método que seta a quantidade de espaços que formam a palavra
                        txtQuiz.setText(desafioSingleton.dandoEspacos(desafioSingleton.definirPalavraVogal(listTema.get(indice).getNomeImagem())));
                        ligarBotoes();
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

    public void desligarBotoes(){
        int i;
        for(i = 0; i < botoes.length; i++){
            Button btn = findViewById(botoes[i]);
            btn.setEnabled(false);
        }
    }

    public void ligarBotoes(){
        int i;
        for(i = 0; i < botoes.length; i++){
            Button btn = findViewById(botoes[i]);
            btn.setEnabled(true);
        }
    }

    @Override
    public void onBackPressed(){
        desafioSingleton.exibirConfirmacao(this);
    }

}

