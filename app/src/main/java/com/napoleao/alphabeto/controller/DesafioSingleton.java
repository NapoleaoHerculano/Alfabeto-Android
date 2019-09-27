package com.napoleao.alphabeto.controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;
import android.os.Vibrator;


public class DesafioSingleton {

    private static DesafioSingleton singleton;

    private DesafioSingleton() {

    }

    public static DesafioSingleton getSingleton() {
        if(singleton == null){
            singleton = new DesafioSingleton();
        }
        return singleton;
    }

    //Recebe o nome do desafio, deixa as consoantes e transforma as vogais em espaços.
    public static String definirPalavraVogal(String vogal) {
        char[] palavra = vogal.toCharArray();
        int i;

        for(i = 0; i < palavra.length; i++){
            if(palavra[i] == 'A' || palavra[i] == 'E' || palavra[i] == 'I' || palavra[i] == 'O' || palavra[i] == 'U' || palavra[i] == ' ' || palavra[i] == 'Í'){
                palavra[i] = '_';
            }
        }

        StringBuilder nome = new StringBuilder();
        for(i = 0; i < palavra.length; i++){
            nome.append(palavra[i]);
        }

        String nomeFormatado = nome.toString();

        return nomeFormatado;
    }
    //Recebe o nome do desafio, deixa as vogais e transforma as consoantes em espaços.
    public static String definirPalavraConsoante(String consoante){
        char[] palavra = consoante.toCharArray();

        int i;
        for(i = 0; i < palavra.length; i++){
            if(palavra[i] != 'A' && palavra[i] != 'E' && palavra[i] != 'I' && palavra[i] != 'O' && palavra[i] != 'U' && palavra[i] != 'Ã' &&
            palavra[i] != 'É' && palavra[i] != 'Á' && palavra[i] != 'Õ' && palavra[i] != 'Ô' && palavra[i] != 'Ó' && palavra[i] != ' '
            && palavra[i] != 'Ç' && palavra[i] != 'Ê' && palavra[i] != 'Ú' && palavra[i] != 'Í'){
                palavra[i] = '_';
            }
        }

        StringBuilder nome = new StringBuilder();
        for(i = 0; i < palavra.length; i++){
            nome.append(palavra[i]);
        }

        String nomeFormatado = nome.toString();

        return nomeFormatado;
    }
    //Recebe o nome do desafio e tranforma todas as letras em espaços.
    public static String definirPalavraAlfabeto(String alfabeto){
        char[] palavra = alfabeto.toCharArray();

        int i;
        for(i = 0; i < palavra.length; i++){
            if(palavra[i] != 'Ã' && palavra[i] != 'É' && palavra[i] != 'Á'  && palavra[i] != 'Í' && palavra[i] != 'Õ' && palavra[i] != 'Ó'
                    && palavra[i] != 'Ç' && palavra[i] != 'Ê' && palavra[i] != 'Ú' && palavra[i] != 'Ô' && palavra[i] != ' ' && palavra[i] != 'Í'){

               palavra[i] = '_';
            }
        }

        StringBuilder nome = new StringBuilder();
        for(i = 0; i < palavra.length; i++){
            nome.append(palavra[i]);
        }

        String nomeFormatado = nome.toString();

        return nomeFormatado;

    }
    //Recebe uma letra, o desafio em string, e por ultimo o desafio em array. Verifica se a alternativa existe na palavra e retorna a palavra modificada.
    public static String verificarAlternativa(Context context, char alternativa, String palavra, char[] palavraFormatada, JogadorSingleton jogador){
        char[] palavraPura = palavra.toCharArray();
        boolean certo = false;

        int i;
        for(i = 0; i < palavraPura.length; i++){
            if(palavraPura[i] == alternativa){
                palavraFormatada[i] = alternativa;
                certo = true;
            }
        }

        //Aqui é diminuido da pontuação 0.20 caso o jogador erre
        if (certo == false){
            vibrar(context);
            jogador.setPontuacao(jogador.getPontuacao() - 0.20f);

        }else{
            vibrar(context);
        }

        StringBuilder nome = new StringBuilder();
        for(i = 0; i < palavraPura.length; i++){
            nome.append(palavraFormatada[i]);
        }

        String nomeFormatado = nome.toString();

        return nomeFormatado;
    }
    //Recebe uma lista com temas e escolhe 5 deles
    public static ArrayList<Tema> carregarTemas(ArrayList<Tema> listTemas){
        ArrayList<Tema> temas = new ArrayList<>();

        int i;
        for(i = 0; i < 5; i++){
            temas.add(listTemas.get(i));
        }

        return temas;
    }
    //Verifica se a resposta é igual ao desafio
    public static boolean verificaResposta(String palavra, String resposta){
        if(resposta.equals(palavra)){
            return true;
        }
        return false;
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

    public static void vibrar(Context context){
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        long milliseconds = 100;
        vibrator.vibrate(milliseconds);
    }

    public static void acertou(Context context){
        final MediaPlayer acertou = MediaPlayer.create(context, R.raw.acertou);
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

}
