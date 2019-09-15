package com.napoleao.alphabeto.controller;

public class JogadorSingleton {

    private float pontuacao = 3;

    private static JogadorSingleton jogador;

    private JogadorSingleton (){

    }

    public static JogadorSingleton getJogador(){
        if(jogador == null){
            jogador = new JogadorSingleton();
        }
        return jogador;
    }

    public float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(float pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void resetarPontuacao(){
        pontuacao = 3;
    }

}
