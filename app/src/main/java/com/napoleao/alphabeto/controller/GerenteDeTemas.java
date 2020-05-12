package com.napoleao.alphabeto.controller;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;

public class GerenteDeTemas {

    private ArrayList<Tema> temas;

    public GerenteDeTemas(ArrayList<Tema> temas) {
        this.temas = temas;
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

    void instanciarAnimais(){
        temas.clear();

        Tema a1 = new Tema(R.drawable.bode, "bode");
        Tema a2 = new Tema(R.drawable.boi, "boi");
        Tema a3 = new Tema(R.drawable.cachorro, "cachorro");
        Tema a4 = new Tema(R.drawable.cavalo, "cavalo");
        Tema a5 = new Tema(R.drawable.elefante, "elefante");
        Tema a6 = new Tema(R.drawable.gato, "gato");
        Tema a7 = new Tema(R.drawable.girafa, "girafa");
        Tema a8 = new Tema(R.drawable.leao, "leão");
        Tema a9 = new Tema(R.drawable.pavao, "pavão");
        Tema a10 = new Tema(R.drawable.peixe, "peixe");
        Tema a11 = new Tema(R.drawable.preguica, "preguiça");
        Tema a12 = new Tema(R.drawable.rato, "rato");
        Tema a13 = new Tema(R.drawable.rinoceronte, "rinoceronte");
        Tema a14 = new Tema(R.drawable.zebra, "zebra");
        Tema a15 = new Tema(R.drawable.leopardo, "leopardo");

        temas.add(a1); temas.add(a2);temas.add(a3);temas.add(a4);temas.add(a5);
        temas.add(a6);
        temas.add(a7);temas.add(a8);temas.add(a9);temas.add(a10);temas.add(a11);
        temas.add(a12);temas.add(a13);temas.add(a14);temas.add(a15);
    }

    void instanciarPaises(){
        temas.clear();

        Tema p1 = new Tema(R.drawable.australia, "austrália");
        Tema p2 = new Tema(R.drawable.brasil, "brasil");
        Tema p3 = new Tema(R.drawable.canada, "canadá");
        Tema p4 = new Tema(R.drawable.china, "china");
        Tema p5 = new Tema(R.drawable.colombia, "colômbia");
        Tema p6 = new Tema(R.drawable.cuba, "cuba");
        Tema p7 = new Tema(R.drawable.franca,  "frança");
        Tema p8 = new Tema(R.drawable.alemanha, "alemanha");
        Tema p9 = new Tema(R.drawable.holanda, "holanda");
        Tema p10 = new Tema(R.drawable.italia, "itália");
        Tema p11 = new Tema(R.drawable.japao, "japão");
        Tema p12 = new Tema(R.drawable.coreia, "coréia\ndo\nsul");
        Tema p13 = new Tema(R.drawable.russia, "rússia");
        Tema p14 = new Tema(R.drawable.reino, "reino\nunido");
        Tema p15 = new Tema(R.drawable.usa, "estados\nunidos");

        temas.add(p1); temas.add(p2);temas.add(p3);temas.add(p4);temas.add(p5);temas.add(p6);
        temas.add(p7);temas.add(p8);temas.add(p9);temas.add(p10);temas.add(p11);temas.add(p12);
        temas.add(p13);temas.add(p14);temas.add(p15);
    }

    void instanciarCores(){
        temas.clear();

        Tema c1 = new Tema(R.drawable.amarelo, "amarelo");
        Tema c2 = new Tema(R.drawable.azul, "azul");
        Tema c3 = new Tema(R.drawable.cinza, "cinza");
        Tema c4 = new Tema(R.drawable.cor_laranja, "laranja");
        Tema c5 = new Tema(R.drawable.marrom, "marrom");
        Tema c6 = new Tema(R.drawable.preto, "preto");
        Tema c7 = new Tema(R.drawable.rosa, "rosa");
        Tema c8 = new Tema(R.drawable.roxo, "roxo");
        Tema c9 = new Tema(R.drawable.verde, "verde");
        Tema c10 = new Tema(R.drawable.vermelho, "vermelho");
        Tema c11 = new Tema(R.drawable.dourado, "dourado");
        Tema c12 = new Tema(R.drawable.azul_escuro, "azul\nmarinho");
        Tema c13 = new Tema(R.drawable.purpura, "roxo\npúrpura");
        Tema c14 = new Tema(R.drawable.marrom_caramelo, "marrom\ncaramelo");
        Tema c15 = new Tema(R.drawable.azul_turquesa, "azul\nturquesa");

        temas.add(c1); temas.add(c2);temas.add(c3);temas.add(c4);temas.add(c5);temas.add(c6);
        temas.add(c7);temas.add(c8);temas.add(c9);temas.add(c10);temas.add(c11);temas.add(c12);
        temas.add(c13);temas.add(c14);temas.add(c15);
    }

    void instanciarObjetos(){
        temas.clear();

        Tema o1 = new Tema(R.drawable.bateria, "pilha");
        Tema o2 = new Tema(R.drawable.carro, "carro");
        Tema o3 = new Tema(R.drawable.chaves, "chaves");
        Tema o4 = new Tema(R.drawable.cubo, "cubo");
        Tema o5 = new Tema(R.drawable.livro, "livro");
        Tema o6 = new Tema(R.drawable.lupa, "lupa");
        Tema o7 = new Tema(R.drawable.martelo, "martelo");
        Tema o8 = new Tema(R.drawable.mesa, "mesa");
        Tema o9 = new Tema(R.drawable.oculos, "óculos");
        Tema o10 = new Tema(R.drawable.relogio, "relógio");
        Tema o11 = new Tema(R.drawable.sorvete, "sorvete");
        Tema o12= new Tema(R.drawable.tambor, "tambor");
        Tema o13 = new Tema(R.drawable.vaso, "vaso");
        Tema o14 = new Tema(R.drawable.xicara, "xícara");
        Tema o15 = new Tema(R.drawable.telefone, "telefone");

        temas.add(o1); temas.add(o2);temas.add(o3);temas.add(o4);temas.add(o5);temas.add(o6);
        temas.add(o7);temas.add(o8);temas.add(o9);temas.add(o10);temas.add(o11);temas.add(o12);
        temas.add(o13);temas.add(o14);temas.add(o15);
    }

    void instanciarFrutas(){
        temas.clear();

        Tema f1 = new Tema(R.drawable.abacaxi, "abacaxi");
        Tema f2 = new Tema(R.drawable.maca, "maçã");
        Tema f3 = new Tema(R.drawable.morango, "morango");
        Tema f4 = new Tema(R.drawable.pera, "pêra");
        Tema f5 = new Tema(R.drawable.banana, "banana");
        Tema f6 = new Tema(R.drawable.laranja, "laranja");
        Tema f7 = new Tema(R.drawable.uvas, "uva");
        Tema f8 = new Tema(R.drawable.manga, "manga");
        Tema f9 = new Tema(R.drawable.goiaba, "goiaba");
        Tema f10 = new Tema(R.drawable.caju, "caju");
        Tema f11 = new Tema(R.drawable.acerola, "acerola");
        Tema f12 = new Tema(R.drawable.maracuja, "maracujá");
        Tema f13 = new Tema(R.drawable.melancia, "melancia");
        Tema f14 = new Tema(R.drawable.melao, "melão");
        Tema f15 = new Tema(R.drawable.limao, "limão");

        temas.add(f1); temas.add(f2);temas.add(f3);temas.add(f4);temas.add(f5);temas.add(f6);
        temas.add(f7);temas.add(f8);temas.add(f9);temas.add(f10);temas.add(f11);temas.add(f12);
        temas.add(f13);temas.add(f14);temas.add(f15);
    }
}
