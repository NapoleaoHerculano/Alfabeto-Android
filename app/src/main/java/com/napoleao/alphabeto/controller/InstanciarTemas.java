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

    InstanciarTemas(ArrayList<Tema> tema) {
        this.tema = tema;
    }

    void instanciarAnimais(){
        tema.clear();

        Animal a1 = new Animal(R.drawable.bode, "bode");
        Animal a2 = new Animal(R.drawable.boi, "boi");
        Animal a3 = new Animal(R.drawable.cachorro, "cachorro");
        Animal a4 = new Animal(R.drawable.cavalo, "cavalo");
        Animal a5 = new Animal(R.drawable.elefante, "elefante");
        Animal a6 = new Animal(R.drawable.gato, "gato");
        Animal a7 = new Animal(R.drawable.girafa, "girafa");
        Animal a8 = new Animal(R.drawable.leao, "leão");
        Animal a9 = new Animal(R.drawable.pavao, "pavão");
        Animal a10 = new Animal(R.drawable.peixe, "peixe");
        Animal a11 = new Animal(R.drawable.preguica, "preguiça");
        Animal a12 = new Animal(R.drawable.rato, "rato");
        Animal a13 = new Animal(R.drawable.rinoceronte, "rinoceronte");
        Animal a14 = new Animal(R.drawable.zebra, "zebra");
        Animal a15 = new Animal(R.drawable.leopardo, "leopardo");

        tema.add(a1); tema.add(a2);tema.add(a3);tema.add(a4);tema.add(a5);
        tema.add(a6);tema.add(a7);tema.add(a8);tema.add(a9);tema.add(a10);
        tema.add(a11);tema.add(a12);tema.add(a13);tema.add(a14);tema.add(a15);
    }

    void instanciarPaises(){
        tema.clear();

        Pais p1 = new Pais(R.drawable.australia, "austrália");
        Pais p2 = new Pais(R.drawable.brasil, "brasil");
        Pais p3 = new Pais(R.drawable.canada, "canadá");
        Pais p4 = new Pais(R.drawable.china, "china");
        Pais p5 = new Pais(R.drawable.colombia, "colômbia");
        Pais p6 = new Pais(R.drawable.cuba, "cuba");
        Pais p7 = new Pais(R.drawable.franca,  "frança");
        Pais p8 = new Pais(R.drawable.alemanha, "alemanha");
        Pais p9 = new Pais(R.drawable.holanda, "holanda");
        Pais p10 = new Pais(R.drawable.italia, "itália");
        Pais p11 = new Pais(R.drawable.japao, "japão");
        Pais p12 = new Pais(R.drawable.coreia, "coréia\ndo\nsul");
        Pais p13 = new Pais(R.drawable.russia, "rússia");
        Pais p14 = new Pais(R.drawable.reino, "reino\nunido");
        Pais p15 = new Pais(R.drawable.usa, "estados\nunidos");

        tema.add(p1); tema.add(p2);tema.add(p3);tema.add(p4);tema.add(p5);
        tema.add(p6);tema.add(p7);tema.add(p8);tema.add(p9);tema.add(p10);
        tema.add(p11);tema.add(p12);tema.add(p13);tema.add(p14);tema.add(p15);
    }

    void instanciarCores(){
        tema.clear();

        Cor c1 = new Cor(R.drawable.amarelo, "amarelo");
        Cor c2 = new Cor(R.drawable.azul, "azul");
        Cor c3 = new Cor(R.drawable.cinza, "cinza");
        Cor c4 = new Cor(R.drawable.cor_laranja, "laranja");
        Cor c5 = new Cor(R.drawable.marrom, "marrom");
        Cor c6 = new Cor(R.drawable.preto, "preto");
        Cor c7 = new Cor(R.drawable.rosa, "rosa");
        Cor c8 = new Cor(R.drawable.roxo, "roxo");
        Cor c9 = new Cor(R.drawable.verde, "verde");
        Cor c10 = new Cor(R.drawable.vermelho, "vermelho");
        Cor c11 = new Cor(R.drawable.dourado, "dourado");
        Cor c12 = new Cor(R.drawable.azul_escuro, "azul\nmarinho");
        Cor c13 = new Cor(R.drawable.purpura, "roxo\npúrpura");
        Cor c14 = new Cor(R.drawable.marrom_caramelo, "marrom\ncaramelo");
        Cor c15 = new Cor(R.drawable.azul_turquesa, "azul\nturquesa");

        tema.add(c1); tema.add(c2);tema.add(c3);tema.add(c4);tema.add(c5);
        tema.add(c6);tema.add(c7);tema.add(c8);tema.add(c9);tema.add(c10);
        tema.add(c11);tema.add(c12);tema.add(c13);tema.add(c14);tema.add(c15);
    }

    void instanciarObjetos(){
        tema.clear();

        Objeto o1 = new Objeto(R.drawable.bateria, "pilha");
        Objeto o2 = new Objeto(R.drawable.carro, "carro");
        Objeto o3 = new Objeto(R.drawable.chaves, "chaves");
        Objeto o4 = new Objeto(R.drawable.cubo, "cubo");
        Objeto o5 = new Objeto(R.drawable.livro, "livro");
        Objeto o6 = new Objeto(R.drawable.lupa, "lupa");
        Objeto o7 = new Objeto(R.drawable.martelo, "martelo");
        Objeto o8 = new Objeto(R.drawable.mesa, "mesa");
        Objeto o9 = new Objeto(R.drawable.oculos, "óculos");
        Objeto o10 = new Objeto(R.drawable.relogio, "relógio");
        Objeto o11 = new Objeto(R.drawable.sorvete, "sorvete");
        Objeto o12= new Objeto(R.drawable.tambor, "tambor");
        Objeto o13 = new Objeto(R.drawable.vaso, "vaso");
        Objeto o14 = new Objeto(R.drawable.xicara, "xícara");
        Objeto o15 = new Objeto(R.drawable.telefone, "telefone");

        tema.add(o1); tema.add(o2);tema.add(o3);tema.add(o4);tema.add(o5);
        tema.add(o6);tema.add(o7);tema.add(o8);tema.add(o9);tema.add(o10);
        tema.add(o11);tema.add(o12);tema.add(o13);tema.add(o14);tema.add(o15);
    }

    void instanciarFrutas(){
        tema.clear();

        Fruta f1 = new Fruta(R.drawable.abacaxi, "abacaxi");
        Fruta f2 = new Fruta(R.drawable.maca, "maçã");
        Fruta f3 = new Fruta(R.drawable.morango, "morango");
        Fruta f4 = new Fruta(R.drawable.pera, "pêra");
        Fruta f5 = new Fruta(R.drawable.banana, "banana");
        Fruta f6 = new Fruta(R.drawable.laranja, "laranja");
        Fruta f7 = new Fruta(R.drawable.uvas, "uva");
        Fruta f8 = new Fruta(R.drawable.manga, "manga");
        Fruta f9 = new Fruta(R.drawable.goiaba, "goiaba");
        Fruta f10 = new Fruta(R.drawable.caju, "caju");
        Fruta f11 = new Fruta(R.drawable.acerola, "acerola");
        Fruta f12 = new Fruta(R.drawable.maracuja, "maracujá");
        Fruta f13 = new Fruta(R.drawable.melancia, "melancia");
        Fruta f14 = new Fruta(R.drawable.melao, "melão");
        Fruta f15 = new Fruta(R.drawable.limao, "limão");

        tema.add(f1); tema.add(f2);tema.add(f3);tema.add(f4);tema.add(f5);
        tema.add(f6);tema.add(f7);tema.add(f8);tema.add(f9);tema.add(f10);
        tema.add(f11);tema.add(f12);tema.add(f13);tema.add(f14);tema.add(f15);
    }
}
