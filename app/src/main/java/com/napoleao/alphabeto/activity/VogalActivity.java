package com.napoleao.alphabeto.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.activity.util.ComponentesAuxiliares;
import com.napoleao.alphabeto.config.AppConfig;
import com.napoleao.alphabeto.controller.GerenteDeDesafios;
import com.napoleao.alphabeto.controller.FabricaTemas;
import com.napoleao.alphabeto.controller.SingletonJogador;
import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;

public class VogalActivity extends AppCompatActivity implements View.OnClickListener {
    //Componentes da interface
    private ImageView imagem;
    private TextView txtQuiz;
    private View botoesVogais;
    private int[] botoes = {R.id.btnA,R.id.btnE,R.id.btnI,R.id.btnO,R.id.btnU};
    //--------------------------------------------------------------------------------------------//
    private ArrayList<Tema> listTema = new ArrayList<>();//Lista com os temas carregados;
    private GerenteDeDesafios gerenteDeDesafios = new GerenteDeDesafios();//Classe responsável pela lógica do aplicativo;
    private ComponentesAuxiliares componentesAuxiliares;
    private FabricaTemas temas = new FabricaTemas(listTema);//Classe responsável por instanciar os desafios do tema escolhido;
    private static final int NIVEL_SELECIONADO = 0;//Variável que indica o nível para seleção dos desafios;
    private int temaSelecionado;//Variável que indica qual o tema a ser carregado;
    private char[] desafio;//Array responsável por guardar e atualizar o desafio de acordo com as respostas;
    private int indice = 0;//Variável que indica o índice atual na lista de temas;
    private SingletonJogador jogador = SingletonJogador.getJogador();//Variável utilizada para definir a pontuação do jogador.

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vogais);

        gerenteDeDesafios = new GerenteDeDesafios();
        componentesAuxiliares = new ComponentesAuxiliares();

        //Obtendo o tema escolhido
        Bundle extras = getIntent().getExtras();
        temaSelecionado = extras.getInt("tema");

        //Carregando os temas de acordo com a escolha
        temas.escolhaDeTema(temaSelecionado);
        listTema = gerenteDeDesafios.carregarTemas(listTema, NIVEL_SELECIONADO);

        //Instanciando a interface
        imagem = findViewById(R.id.imageVogal);
        txtQuiz = findViewById(R.id.txtQuiz);
        botoesVogais = findViewById(R.id.botoesVogais);
        componentesAuxiliares.instanciarBotoes(botoesVogais, this, botoes, this);

        //Definindo os primeiros elementos a serem iniciados
        imagem.setImageResource(listTema.get(indice).getImagem());
        txtQuiz.setText(gerenteDeDesafios.dandoEspacos(gerenteDeDesafios.definirPalavraVogal(listTema.get(indice).getNomeImagem())));
        desafio = gerenteDeDesafios.definirPalavraVogal(listTema.get(indice).getNomeImagem()).toCharArray();
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String alternativa = button.getText().toString();
        verificaResposta(alternativa.charAt(0));
    }

    /**
     * Reproduz o nome da imagem que representa o desafio.
     * @param v necessário para o mapeamento via XML
     */
    public void falarImagem(View v){
        gerenteDeDesafios.falarImagem(listTema, indice);
    }

    /**
     * Verifica se o caractere escolhido existe no desafio.
     * @param alternativa Caractere escolhido (botão clicado no teclado).
     */
    private void verificaResposta(char alternativa){
        String resposta = gerenteDeDesafios.verificarAlternativa(this, alternativa,listTema.get(indice).getNomeImagem(),desafio, jogador);
        txtQuiz.setText(gerenteDeDesafios.dandoEspacos(resposta));

        boolean acertou = gerenteDeDesafios.verificaResposta(listTema.get(indice).getNomeImagem(), resposta);
        if (acertou){
            gerenteDeDesafios.acertou(this, AppConfig.getInstance(this).getCurrentSound());
            indice++;
            if(indice == listTema.size()) {
                componentesAuxiliares.invocarIntent(this, FimDeJogoActivity.class, temaSelecionado);
            }else if(indice < listTema.size()){
                componentesAuxiliares.desligarBotoes(botoes, botoesVogais);
                Handler handle = new Handler();
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gerenteDeDesafios.setAtributosVogais(imagem, txtQuiz, listTema, indice);
                        desafio = gerenteDeDesafios.definirPalavraVogal(listTema.get(indice).getNomeImagem()).toCharArray();
                        //Mudando o desafio. Para isso é chamado o método que seta a quantidade de espaços que formam a palavra
                        txtQuiz.setText(gerenteDeDesafios.dandoEspacos(gerenteDeDesafios.definirPalavraVogal(listTema.get(indice).getNomeImagem())));
                        componentesAuxiliares.ligarBotoes(botoes, botoesVogais);
                    }
                }, 2000);
            }
        }
    }

    /**
     * Mapeia o botão de voltar nativo do Android, exibe um AlertDialog perguntando se o jogador
     * deseja voltar ao menu de seleção de temas.
     */
    @Override
    public void onBackPressed(){
        componentesAuxiliares.exibirConfirmacaoVoltar(this);
    }

    /**
     * Mapeia o botão de voltar presente.
     * @param v View mapeada
     */
    public void voltarVogais(View v){
        onBackPressed();
    }

    /**
     * Mapeia o botão de fechar atividade.
     * @param v View mapeada
     */
    public void fecharVogais(View v){
        componentesAuxiliares.exibirConfirmacaoFechar(this);
    }
}

