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

public class ConsoanteActivity extends AppCompatActivity implements View.OnClickListener {
    //Componentes da interface
    private ImageView imagem;
    private TextView txtQuiz;
    private View botoesConsoantes;
    private int[] botoes = {R.id.btnB,R.id.btnC,R.id.btnD,R.id.btnF,R.id.btnG,R.id.btnH,R.id.btnJ,R.id.btnK,R.id.btnL,
            R.id.btnM,R.id.btnN,R.id.btnP,R.id.btnQ,R.id.btnR,R.id.btnS,R.id.btnT,R.id.btnV,R.id.btnW,R.id.btnX,
            R.id.btnY,R.id.btnZ};
    //--------------------------------------------------------------------------------------------//
    private ArrayList<Tema> listTema = new ArrayList<>();
    private DesafioFacade desafioFacade;
    private FabricaTemas temas = new FabricaTemas(listTema);
    private static final int NIVEL_SELECIONADO = 1;
    private int temaSelecionado;
    private char[] desafio;//Array responsável por guardar e atualizar o desafio de acordo com as respostas
    private int indice = 0;
    private JogadorSingleton jogador = JogadorSingleton.getJogador();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_model_consoantes);

        desafioFacade = new DesafioFacade();

        //Obtendo o tema escolhido
        Bundle extras = getIntent().getExtras();
        temaSelecionado = extras.getInt("tema");

        //Carregando os temas de acordo com a escolha
        temas.escolhaDeTema(temaSelecionado);
        listTema = desafioFacade.carregarTemas(listTema, NIVEL_SELECIONADO);

        //Instanciando a interface
        imagem = findViewById(R.id.imageConsoante);
        txtQuiz = findViewById(R.id.textConsoante);
        botoesConsoantes = findViewById(R.id.botoesConsoantes);
        desafioFacade.getComponentesAuxiliares().instanciarBotoes(botoesConsoantes, this, botoes, this);

        //Definindo os primeiros elementos a serem iniciados
        imagem.setImageResource(listTema.get(indice).getImagem());
        txtQuiz.setText(desafioFacade.definirPalavraConsoante(desafioFacade.dandoEspacos(listTema.get(indice).getNomeImagem())));
        desafio = desafioFacade.definirPalavraConsoante(listTema.get(indice).getNomeImagem()).toCharArray();
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
                desafioFacade.getComponentesAuxiliares().desligarBotoes(botoes, botoesConsoantes);
                Handler handle = new Handler();
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        desafioFacade.setAtributosConsoantes(imagem, txtQuiz, listTema, indice);
                        desafio = desafioFacade.definirPalavraConsoante(listTema.get(indice).getNomeImagem()).toCharArray();
                        //Mudando o desafio. Para isso é chamado o método que seta a quantidade de espaços que formam a palavra
                        txtQuiz.setText(desafioFacade.definirPalavraConsoante(desafioFacade.dandoEspacos(listTema.get(indice).getNomeImagem())));
                        desafioFacade.getComponentesAuxiliares().ligarBotoes(botoes, botoesConsoantes);
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
    public void voltarConsoantes(View v){
        onBackPressed();
    }

    /**
     * Mapeia o botão de fechar atividade.
     * @param v View mapeada
     */
    public void fecharConsoantes(View v){
        desafioFacade.getComponentesAuxiliares().exibirConfirmacaoFechar(this);
    }

}