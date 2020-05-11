package com.Patrickerson.ArvoreBinaria;

import com.Patrickerson.ArvoreBinaria.Classes.ArvoreBinaria;

public class Main {

    public static void main(String[] args){

        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println("TESTE COM ARVORE COM FB de pai -2 e FB de filho 1");
        System.out.println("***************************************************");
        System.out.println("***************************************************");
        arvoreBinaria.inserir(65);
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(95);
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(80);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove_biggest();
        arvoreBinaria.pre_order();

        arvoreBinaria.remove_smaller();
        arvoreBinaria.pre_order();

        arvoreBinaria.remove_smaller();
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(80);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove_biggest();
        arvoreBinaria.pre_order();


        System.out.println("\n");
        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println("TESTE COM ARVORE COM FB de pai 2 e FB de filho -1");
        System.out.println("***************************************************");
        System.out.println("***************************************************");

        arvoreBinaria.inserir(95);
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(65);
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(80);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove_biggest();
        arvoreBinaria.pre_order();

        arvoreBinaria.remove_smaller();
        arvoreBinaria.pre_order();

        arvoreBinaria.remove_smaller();
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(80);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove_biggest();
        arvoreBinaria.pre_order();



        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println("TESTE DE INSERÇÃ E REMOÇÃO");
        System.out.println("***************************************************");
        System.out.println("***************************************************");

        arvoreBinaria.inserir(86);
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(47);
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(30);
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(20);
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(90);
        arvoreBinaria.pre_order();

        arvoreBinaria.inserir(110);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove(90);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove(20);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove(47);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove(86);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove(30);
        arvoreBinaria.pre_order();

        arvoreBinaria.remove(110);
        arvoreBinaria.pre_order();

    }

}
