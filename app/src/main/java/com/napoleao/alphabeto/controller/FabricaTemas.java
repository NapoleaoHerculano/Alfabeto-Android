package com.napoleao.alphabeto.controller;

import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;

public class FabricaTemas {

    private GerenteDeTemas gerenteDeTemas;

    public FabricaTemas(ArrayList<Tema> temas) {
        this.gerenteDeTemas = new GerenteDeTemas(temas);
    }

    public void escolhaDeTema(int temaSelecionado) {
        this.gerenteDeTemas.escolhaDeTema(temaSelecionado);
    }

}
