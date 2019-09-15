package com.napoleao.alphabeto.model;

import android.widget.ImageView;

public class Tema {

    private int idImagem;
    private String nomeImagem;


    public Tema(int idImagem, String nomeImagem) {
        this.idImagem = idImagem;
        this.nomeImagem = nomeImagem;
    }

    public int getImagem() {
        return idImagem;
    }

    public void setImagem(ImageView imagem) {
        this.idImagem = idImagem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }


}
