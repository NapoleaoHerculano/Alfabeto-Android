package com.napoleao.alphabeto.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.activity.MainActivity;
import com.napoleao.alphabeto.activity.TelaInicialActivity;
import com.napoleao.alphabeto.activity.VogalActivity;
import com.napoleao.alphabeto.config.AppConfig;
import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;
import android.os.Vibrator;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import static androidx.core.content.ContextCompat.startActivity;


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
            && palavra[i] != 'Ç' && palavra[i] != 'Ê' && palavra[i] != 'Ú' && palavra[i] != 'Í' && palavra[i] != '-' && palavra[i] != '\n'){
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
                    && palavra[i] != 'Ç' && palavra[i] != 'Ê' && palavra[i] != 'Ú' && palavra[i] != 'Ô' && palavra[i] != ' ' && palavra[i] != 'Í' && palavra[i] != '-' && palavra[i] != '\n'){

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
        if (!certo){
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

    public static void vibrar(Context context){
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        long milliseconds = 100;
        vibrator.vibrate(milliseconds);
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

    public void exibirConfirmacaoVoltar(final Activity activity) {

        AlertDialog.Builder mensagem = new AlertDialog.Builder(activity);
        mensagem.setTitle("Confirmação");
        mensagem.setIcon(null);
        mensagem.setMessage("Você voltará para a seleção de temas. Deseja sair da partida?");

        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Seleção de temas", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(activity, MainActivity.class);
                activity.startActivity(it);
                activity.finish();
            }
        });

        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Continuando...", Toast.LENGTH_SHORT).show();
            }
        });
        mensagem.show();
    }

    public void exibirConfirmacaoFechar(final Activity activity) {

        AlertDialog.Builder mensagem = new AlertDialog.Builder(activity);
        mensagem.setTitle("Confirmação");
        mensagem.setIcon(null);
        mensagem.setMessage("Você voltará para a tela inicial. Deseja sair da partida?");

        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Início", Toast.LENGTH_SHORT).show();
                activity.finish();
            }
        });

        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Continuando...", Toast.LENGTH_SHORT).show();
            }
        });
        mensagem.show();
    }

}
