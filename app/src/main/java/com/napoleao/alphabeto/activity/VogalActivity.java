package com.napoleao.alphabeto.activity;

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
    private View botoesVogais;
    private int[] botoes = {R.id.btnA,R.id.btnE,R.id.btnI,R.id.btnO,R.id.btnU};
    //--------------------------------------------------------------------------------------------//
    private ArrayList<Tema> listTema = new ArrayList<>();//Lista com os temas carregados;
    private DesafioFacade desafioFacade = new DesafioFacade();//Classe responsável pela lógica do aplicativo;
    private FabricaTemas temas = new FabricaTemas(listTema);//Classe responsável por instanciar os desafios do tema escolhido;
    private static final int NIVEL_SELECIONADO = 0;//Variável que indica o nível para seleção dos desafios;
    private int temaSelecionado;//Variável que indica qual o tema a ser carregado;
    private char[] desafio;//Array responsável por guardar e atualizar o desafio de acordo com as respostas;
    private int indice = 0;//Variável que indica o índice atual na lista de temas;
    private JogadorSingleton jogador = JogadorSingleton.getJogador();//Variável utilizada para definir a pontuação do jogador.

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_model_vogais);

        //Obtendo o tema escolhido
        Bundle extras = getIntent().getExtras();
        temaSelecionado = extras.getInt("tema");

        //Carregando os temas de acordo com a escolha
        temas.escolhaDeTema(temaSelecionado);
        listTema = desafioFacade.carregarTemas(listTema, NIVEL_SELECIONADO);

        //Instanciando a interface
        imagem = findViewById(R.id.imageVogal);
        txtQuiz = findViewById(R.id.txtQuiz);
        botoesVogais = findViewById(R.id.botoesVogais);
        desafioFacade.getComponentesAuxiliares().instanciarBotoes(botoesVogais, this, botoes);

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

    /**
     * Reproduz o nome da imagem que representa o desafio.
     * @param v necessário para o mapeamento via XML
     */
    public void falarImagem(View v){
        desafioFacade.falarImagem(listTema, indice);
    }

    /**
     * Verifica se o caractere escolhido existe no desafio.
     * @param alternativa Caractere escolhido (botão clicado no teclado).
     */
    private void verificaResposta(char alternativa){
        String resposta = desafioFacade.verificarAlternativa(this, alternativa,listTema.get(indice).getNomeImagem(),desafio, jogador);
        txtQuiz.setText(desafioFacade.dandoEspacos(resposta));

        boolean acertou = desafioFacade.verificaResposta(listTema.get(indice).getNomeImagem(), resposta);
        if (acertou){
            desafioFacade.acertou(this, AppConfig.getInstance(this).getCurrentSound());
            indice++;
            if(indice == listTema.size()) {
                desafioFacade.getComponentesAuxiliares().invocarIntent(this, FimDeJogoActivity.class, temaSelecionado);
            }else if(indice < listTema.size()){
                desafioFacade.getComponentesAuxiliares().desligarBotoes(botoes, botoesVogais);
                Handler handle = new Handler();
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        desafioFacade.setAtributosVogais(imagem, txtQuiz, listTema, indice);
                        desafio = desafioFacade.definirPalavraVogal(listTema.get(indice).getNomeImagem()).toCharArray();
                        //Mudando o desafio. Para isso é chamado o método que seta a quantidade de espaços que formam a palavra
                        txtQuiz.setText(desafioFacade.dandoEspacos(desafioFacade.definirPalavraVogal(listTema.get(indice).getNomeImagem())));
                        desafioFacade.getComponentesAuxiliares().ligarBotoes(botoes, botoesVogais);
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
        desafioFacade.getComponentesAuxiliares().exibirConfirmacaoVoltar(this);
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
        desafioFacade.getComponentesAuxiliares().exibirConfirmacaoFechar(this);
    }
}

