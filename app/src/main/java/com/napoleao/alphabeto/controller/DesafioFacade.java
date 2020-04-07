package com.napoleao.alphabeto.controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;
import java.util.List;

public class DesafioFacade {

    private Context context;
    private ComponentesAuxiliares componentesAuxiliares;
    private SingletonAudio tts;


    public DesafioFacade() {
        this.componentesAuxiliares = new ComponentesAuxiliares();
        this.tts = SingletonAudio.getSingleton(context);
    }

    public ComponentesAuxiliares getComponentesAuxiliares() {
        return componentesAuxiliares;
    }

    //Recebe o nome do desafio, deixa as consoantes e transforma as vogais em espaços.
    public static String definirPalavraVogal(String vogal) {
        char[] caracteres = {'A','E','I','O','U'};
        char[] palavra = vogal.toCharArray();

        for(int i = 0; i < palavra.length; i++){
            for (int k = 0; k < caracteres.length; k++) {
                if (palavra[i] == caracteres[k]) {
                    palavra[i] = '_';
                }
            }
        }

        String desafioFormatado = formatarDesafio(palavra);

        return desafioFormatado;
    }
    //Recebe o nome do desafio, deixa as vogais e transforma as consoantes em espaços.
    public static String definirPalavraConsoante(String consoante){
        char[] caracteres = {'B','C','D','F','G','H','J','K','L','M','N','P','Q',
                'R','S','T','V','W','X','Y','Z'};
        char[] palavra = consoante.toCharArray();

        for(int i = 0; i < palavra.length; i++){
            for(int k = 0; k < caracteres.length; k++){
                if (palavra[i] == caracteres[k]){
                    palavra[i] = '_';
                }
            }
        }

        String desafioFormatado = formatarDesafio(palavra);

        return desafioFormatado;
    }
    //Recebe o nome do desafio e tranforma todas as letras em espaços.
    public static String definirPalavraAlfabeto(String alfabeto){
        char[] caracteres = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
                'R','S','T','U','V','W','X','Y','Z'};
        char[] palavra = alfabeto.toCharArray();

        for(int i = 0; i < palavra.length; i++){
            for (int k = 0; k < caracteres.length; k++){
                if (palavra[i] == caracteres[k]){
                    palavra[i] = '_';
                }
            }
        }

        String desafioFormatado = formatarDesafio(palavra);

        return desafioFormatado;
    }

    public static String formatarDesafio(char[] palavra){
        StringBuilder nome = new StringBuilder();
        for(int i = 0; i < palavra.length; i++){
            nome.append(palavra[i]);
        }

        String desafioFormatado = nome.toString();

        return desafioFormatado;
    }

    //Recebe uma letra, o desafio em string, e por ultimo o desafio em array. Verifica se a alternativa existe na palavra e retorna a palavra modificada.
    public String verificarAlternativa(Context context, char alternativa, String palavra, char[] palavraFormatada, JogadorSingleton jogador){
        char[] palavraPura = palavra.toCharArray();
        boolean certo = false;

        for(int i = 0; i < palavraPura.length; i++){
            if(palavraPura[i] == alternativa){
                palavraFormatada[i] = alternativa;
                certo = true;
            }
        }

        //Aqui é diminuido da pontuação 0.20 caso o jogador erre
        if (!certo){
            componentesAuxiliares.vibrar(context);
            jogador.setPontuacao(jogador.getPontuacao() - 0.20f);

        }else{
            componentesAuxiliares.vibrar(context);
        }

        String desafioFormatado = formatarDesafio(palavraFormatada);

        return desafioFormatado;
    }

    //Recebe uma lista com temas e escolhe 5 deles
    public static ArrayList<Tema> carregarTemas(ArrayList<Tema> listTemas, int nivel){
        ArrayList<Tema> temas = new ArrayList<>();

        int i;
        if(nivel == 0){
            for(i = 0; i < 5; i++){
                temas.add(listTemas.get(i));
            }
        }else if(nivel == 1){
            for(i = 5; i < 10; i++){
                temas.add(listTemas.get(i));
            }
        }else{
            for(i = 10; i <= 14; i++){
                temas.add(listTemas.get(i));
            }
        }

        return temas;
    }
    //Verifica se a resposta é igual ao desafio
    public static boolean verificaResposta(String palavra, String resposta){
        return resposta.equals(palavra);
    }

    public static void setAtributosVogais(ImageView imagem, TextView textoImagem, ArrayList<Tema> temas, int indice){
        imagem.setImageResource(temas.get(indice).getImagem());
        textoImagem.setText(definirPalavraVogal(temas.get(indice).getNomeImagem()));
    }

    public static void setAtributosConsoantes(ImageView imagem, TextView textoImagem, ArrayList<Tema> temas, int indice){
        imagem.setImageResource(temas.get(indice).getImagem());
        textoImagem.setText(definirPalavraConsoante(temas.get(indice).getNomeImagem()));
    }

    public static void setAtributosAlfabeto(ImageView imagem, TextView textoImagem, ArrayList<Tema> temas, int indice){
        imagem.setImageResource(temas.get(indice).getImagem());
        textoImagem.setText(definirPalavraAlfabeto(temas.get(indice).getNomeImagem()));
    }

    public static void acertou(Context context, String opcao){
        MediaPlayer acertou;

        if(opcao.equals("Opção 01")){
            acertou = MediaPlayer.create(context, R.raw.acertou);
        }else if(opcao.equals("Opção 02")){
            acertou = MediaPlayer.create(context, R.raw.acertou2);
        }else {
            acertou = MediaPlayer.create(context, R.raw.acertou3);

        }
        acertou.start();
    }

    public static String dandoEspacos(String underscore) {
        StringBuilder novaString = new StringBuilder();
        novaString.append(" ");
        for(int i = 0; i < underscore.length(); i++) {
            novaString.append(underscore.charAt(i)) ;
            novaString.append(" ");
        }

        return novaString.toString();
    }

    public void falarImagem(List<Tema> listTema, int indice){
        tts.ditarFoto(listTema.get(indice).getNomeImagem());
    }
}
