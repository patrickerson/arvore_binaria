package com.Patrickerson.ArvoreBinaria;

import com.Patrickerson.ArvoreBinaria.Classes.ArvoreBinaria;

public class Main {

    public static void main(String args[]){

        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(8);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(1);
        arvoreBinaria.inserir(13);
        arvoreBinaria.inserir(12);
        arvoreBinaria.inserir(16);






        System.out.println("------------");
        System.out.println("Pre ordem");
        System.out.println("------------");
        arvoreBinaria.pre_ordem();

        System.out.println("------------");
        System.out.println("In ordem");
        System.out.println("------------");
        arvoreBinaria.in_ordem();



        System.out.println("------------");
        System.out.println("Pos ordem");
        System.out.println("------------");
        arvoreBinaria.pos_ordem();
        System.out.print("Remove maior: ");
        System.out.println(arvoreBinaria.remove_maior());

        System.out.println("------------------------");
        System.out.println("REMOVE MAIOR - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_ordem();

        System.out.print("Remove menor: ");
        System.out.println(arvoreBinaria.remove_menor());

        System.out.println("------------------------");
        System.out.println("REMOVE MENOR - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_ordem();


        arvoreBinaria.remove(8);
        System.out.println("------------------------");
        System.out.println("REMOVE - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_ordem();
    }




}
