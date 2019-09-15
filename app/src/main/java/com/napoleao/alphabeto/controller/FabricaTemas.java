package com.napoleao.alphabeto.controller;

import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;

public class FabricaTemas extends InstanciarTemas {

    public FabricaTemas(ArrayList<Tema> tema) {
        super(tema);
    }

    public void escolhaDeTema(int select) {
        if (select == 0) {
            instanciarCores();
        } else if (select == 1) {
            instanciarObjetos();
        } else if (select == 2) {
            instanciarAnimais();
        }else if (select == 3){
            instanciarFrutas();
        }else{
            instanciarPaises();
        }
    }

}
