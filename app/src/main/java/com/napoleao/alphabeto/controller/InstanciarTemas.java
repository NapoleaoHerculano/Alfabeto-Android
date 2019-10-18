package com.napoleao.alphabeto.controller;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.model.Animal;
import com.napoleao.alphabeto.model.Cor;
import com.napoleao.alphabeto.model.Fruta;
import com.napoleao.alphabeto.model.Objeto;
import com.napoleao.alphabeto.model.Pais;
import com.napoleao.alphabeto.model.Tema;

import java.util.ArrayList;

public abstract class InstanciarTemas {

    protected ArrayList<Tema> tema;

    public InstanciarTemas(ArrayList<Tema> tema) {
        this.tema = tema;
    }


    public ArrayList<Tema> instanciarAnimais(){
        tema.clear();

        Animal a1 = new Animal(R.drawable.bode, "BODE");
        Animal a2 = new Animal(R.drawable.boi, "BOI");
        Animal a3 = new Animal(R.drawable.cachorro, "CACHORRO");
        Animal a4 = new Animal(R.drawable.cavalo, "CAVALO");
        Animal a5 = new Animal(R.drawable.elefante, "ELEFANTE");
        Animal a6 = new Animal(R.drawable.gato, "GATO");
        Animal a7 = new Animal(R.drawable.girafa, "GIRAFA");
        Animal a8 = new Animal(R.drawable.leao, "LEÃO");
        Animal a9 = new Animal(R.drawable.pavao, "PAVÃO");
        Animal a10 = new Animal(R.drawable.peixe, "PEIXE");
        Animal a11 = new Animal(R.drawable.preguica, "PREGUIÇA");
        Animal a12 = new Animal(R.drawable.rato, "RATO");
        Animal a13 = new Animal(R.drawable.rinoceronte, "RINOCERONTE");
        Animal a14 = new Animal(R.drawable.zebra, "ZEBRA");
        Animal a15 = new Animal(R.drawable.leopardo, "LEOPARDO");


        tema.add(a1); tema.add(a2);tema.add(a3);tema.add(a4);tema.add(a5);
        tema.add(a6);tema.add(a7);tema.add(a8);tema.add(a9);tema.add(a10);
        tema.add(a11);tema.add(a12);tema.add(a13);tema.add(a14);tema.add(a15);

        return tema;
    }
    public ArrayList<Tema> instanciarPaises(){
        tema.clear();

        Pais p1 = new Pais(R.drawable.australia, "AUSTRÁLIA");
        Pais p2 = new Pais(R.drawable.brasil, "BRASIL");
        Pais p3 = new Pais(R.drawable.canada, "CANADÁ");
        Pais p4 = new Pais(R.drawable.china, "CHINA");
        Pais p5 = new Pais(R.drawable.colombia, "COLÔMBIA");
        Pais p6 = new Pais(R.drawable.cuba, "CUBA");
        Pais p7 = new Pais(R.drawable.franca,  "FRANÇA");
        Pais p8 = new Pais(R.drawable.alemanha, "ALEMANHA");
        Pais p9 = new Pais(R.drawable.holanda, "HOLANDA");
        Pais p10 = new Pais(R.drawable.italia, "ITÁLIA");
        Pais p11 = new Pais(R.drawable.japao, "JAPÃO");
        Pais p12 = new Pais(R.drawable.coreia, "CORÉIA\nDO\nSUL");
        Pais p13 = new Pais(R.drawable.russia, "RÚSSIA");
        Pais p14 = new Pais(R.drawable.reino, "REINO\nUNIDO");
        Pais p15 = new Pais(R.drawable.usa, "ESTADOS\nUNIDOS");

        tema.add(p1); tema.add(p2);tema.add(p3);tema.add(p4);tema.add(p5);
        tema.add(p6);tema.add(p7);tema.add(p8);tema.add(p9);tema.add(p10);
        tema.add(p11);tema.add(p12);tema.add(p13);tema.add(p14);tema.add(p15);

        return tema;
    }

    public ArrayList<Tema> instanciarCores(){
        tema.clear();

        Cor c1 = new Cor(R.drawable.amarelo, "AMARELO");
        Cor c2 = new Cor(R.drawable.azul, "AZUL");
        Cor c3 = new Cor(R.drawable.cinza, "CINZA");
        Cor c4 = new Cor(R.drawable.cor_laranja, "LARANJA");
        Cor c5 = new Cor(R.drawable.marrom, "MARROM");
        Cor c6 = new Cor(R.drawable.preto, "PRETO");
        Cor c7 = new Cor(R.drawable.rosa, "ROSA");
        Cor c8 = new Cor(R.drawable.roxo, "ROXO");
        Cor c9 = new Cor(R.drawable.verde, "VERDE");
        Cor c10 = new Cor(R.drawable.vermelho, "VERMELHO");
        Cor c11 = new Cor(R.drawable.dourado, "DOURADO");
        Cor c12 = new Cor(R.drawable.azul_escuro, "AZUL\nMARINHO");
        Cor c13 = new Cor(R.drawable.purpura, "ROXO\nPÚRPURA");
        Cor c14 = new Cor(R.drawable.marrom_caramelo, "MARROM\nCARAMELO");
        Cor c15 = new Cor(R.drawable.azul_turquesa, "AZUL\nTURQUESA");

        tema.add(c1); tema.add(c2);tema.add(c3);tema.add(c4);tema.add(c5);
        tema.add(c6);tema.add(c7);tema.add(c8);tema.add(c9);tema.add(c10);
        tema.add(c11);tema.add(c12);tema.add(c13);tema.add(c14);tema.add(c15);

        return tema;
    }

    public ArrayList<Tema> instanciarObjetos(){
        tema.clear();

        Objeto o1 = new Objeto(R.drawable.bateria, "BATERIA");
        Objeto o2 = new Objeto(R.drawable.carro, "CARRO");
        Objeto o3 = new Objeto(R.drawable.chaves, "CHAVES");
        Objeto o4 = new Objeto(R.drawable.cubo, "CUBO");
        Objeto o5 = new Objeto(R.drawable.livro, "LIVRO");
        Objeto o6 = new Objeto(R.drawable.lupa, "LUPA");
        Objeto o7 = new Objeto(R.drawable.martelo, "MARTELO");
        Objeto o8 = new Objeto(R.drawable.mesa, "MESA");
        Objeto o9 = new Objeto(R.drawable.oculos, "ÓCULOS");
        Objeto o10 = new Objeto(R.drawable.relogio, "RELÓGIO");
        Objeto o11 = new Objeto(R.drawable.sorvete, "SORVETE");
        Objeto o12= new Objeto(R.drawable.tambor, "TAMBOR");
        Objeto o13 = new Objeto(R.drawable.vaso, "VASO");
        Objeto o14 = new Objeto(R.drawable.xicara, "XÍCARA");
        Objeto o15 = new Objeto(R.drawable.telefone, "TELEFONE");

        tema.add(o1); tema.add(o2);tema.add(o3);tema.add(o4);tema.add(o5);
        tema.add(o6);tema.add(o7);tema.add(o8);tema.add(o9);tema.add(o10);
        tema.add(o11);tema.add(o12);tema.add(o13);tema.add(o14);tema.add(o15);

        return tema;
    }

    public ArrayList<Tema> instanciarFrutas(){
        tema.clear();

        Fruta f1 = new Fruta(R.drawable.abacaxi, "ABACAXI");
        Fruta f2 = new Fruta(R.drawable.maca, "MAÇÃ");
        Fruta f3 = new Fruta(R.drawable.morango, "MORANGO");
        Fruta f4 = new Fruta(R.drawable.pera, "PÊRA");
        Fruta f5 = new Fruta(R.drawable.banana, "BANANA");
        Fruta f6 = new Fruta(R.drawable.laranja, "LARANJA");
        Fruta f7 = new Fruta(R.drawable.uvas, "UVA");
        Fruta f8 = new Fruta(R.drawable.manga, "MANGA");
        Fruta f9 = new Fruta(R.drawable.goiaba, "GOIABA");
        Fruta f10 = new Fruta(R.drawable.caju, "CAJU");
        Fruta f11 = new Fruta(R.drawable.acerola, "ACEROLA");
        Fruta f12 = new Fruta(R.drawable.maracuja, "MARACUJÁ");
        Fruta f13 = new Fruta(R.drawable.melancia, "MELANCIA");
        Fruta f14 = new Fruta(R.drawable.melao, "MELÃO");
        Fruta f15 = new Fruta(R.drawable.limao, "LIMÃO");

        tema.add(f1); tema.add(f2);tema.add(f3);tema.add(f4);tema.add(f5);
        tema.add(f6);tema.add(f7);tema.add(f8);tema.add(f9);tema.add(f10);
        tema.add(f11);tema.add(f12);tema.add(f13);tema.add(f14);tema.add(f15);

        return tema;
    }
}
