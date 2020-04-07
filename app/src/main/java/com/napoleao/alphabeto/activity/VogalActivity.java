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
import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;


public class VogalActivity extends AppCompatActivity implements View.OnClickListener {
    //Componentes da interface
    private ImageView imagem;
    private TextView txtQuiz;
    //----------------------------------------------------------------------------------------------//
    private ArrayList<Tema> listTema = new ArrayList<>();//Lista com os temas carregados
    private DesafioFacade desafioFacade = new DesafioFacade();//Classe responsável pela lógica do aplicativo
    private FabricaTemas temas = new FabricaTemas(listTema);//Classe responsável por instanciar o tema escolhido
    private int select;//Valor que indica qual o tema a ser carregado
    private final int TEMA_SELECT = 0;//Valor que indica quais desafios serão carregados
    private char[] desafio;//Array responsável por guardar e atualizar o desafio de acordo com as respostas
    private boolean acertou;
    private int indice;
    private JogadorSingleton jogador;

    private int[] botoes = {R.id.btnA,R.id.btnE,R.id.btnI,R.id.btnO,R.id.btnU};
    private View viewBotoes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_model_vogais);

        //Inicialização das variaveis
        acertou = false;
        indice = 0;
        jogador = jogador.getJogador();

        instanciarBotoes();

        //Pegando o tema escolhido
        Bundle extras = getIntent().getExtras();
        select = extras.getInt("tema");

        //Carregando os temas de acordo com a escolha
        temas.escolhaDeTema(select);
        listTema = desafioFacade.carregarTemas(listTema, TEMA_SELECT);

        //Instanciando a interface
        imagem = findViewById(R.id.imageVogal);
        txtQuiz = findViewById(R.id.txtQuiz);
        viewBotoes = findViewById(R.id.botoesVogais);

        //Definindo os primeiros elementos a serem iniciados
        imagem.setImageResource(listTema.get(indice).getImagem());
        txtQuiz.setText(desafioFacade.dandoEspacos(desafioFacade.definirPalavraVogal(listTema.get(indice).getNomeImagem())));
        desafio = desafioFacade.definirPalavraVogal(listTema.get(indice).getNomeImagem()).toCharArray();
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String alternativa = button.getText().toString();
        verificaResposta(alternativa.charAt(0));
    }

    public void falarImagem(View v){
        desafioFacade.falarImagem(listTema, indice);
    }

    private void verificaResposta(char alternativa){
        String resposta = desafioFacade.verificarAlternativa(this, alternativa,listTema.get(indice).getNomeImagem(),desafio, jogador);
        txtQuiz.setText(desafioFacade.dandoEspacos(resposta));

        acertou = desafioFacade.verificaResposta(listTema.get(indice).getNomeImagem(), resposta);
        if (acertou){
            desafioFacade.acertou(this, AppConfig.getInstance(this).getCurrentSound());
            indice++;
            if(indice == listTema.size()) {
                Intent it = new Intent(VogalActivity.this, FimDeJogoActivity.class);
                it.putExtra("tema", select);
                startActivity(it);
                finish();
            }else if(indice < listTema.size()){
                desafioFacade.getComponentesAuxiliares().desligarBotoes(botoes, viewBotoes);
                Handler handle = new Handler();
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        desafioFacade.setAtributosVogais(imagem, txtQuiz, listTema, indice);
                        desafio = desafioFacade.definirPalavraVogal(listTema.get(indice).getNomeImagem()).toCharArray();
                        //Mudando o desafio. Para isso é chamado o método que seta a quantidade de espaços que formam a palavra
                        txtQuiz.setText(desafioFacade.dandoEspacos(desafioFacade.definirPalavraVogal(listTema.get(indice).getNomeImagem())));
                        desafioFacade.getComponentesAuxiliares().ligarBotoes(botoes, viewBotoes);
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

    public void voltarVogais(View v){
        onBackPressed();
    }

    public void fecharVogais(View v){
        desafioFacade.getComponentesAuxiliares().exibirConfirmacaoFechar(this);
    }

}

