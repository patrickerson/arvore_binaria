package com.Patrickerson.ArvoreBinaria;

import com.Patrickerson.ArvoreBinaria.Classes.ArvoreBinaria;

public class Main {

    public static void main(String[] args){

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
        arvoreBinaria.pre_order();

        System.out.println("------------");
        System.out.println("In ordem");
        System.out.println("------------");
        arvoreBinaria.in_order();



        System.out.println("------------");
        System.out.println("Pos ordem");
        System.out.println("------------");
        arvoreBinaria.pos_order();
        System.out.print("Remove maior: ");
        System.out.println(arvoreBinaria.remove_biggest());

        System.out.println("------------------------");
        System.out.println("REMOVE MAIOR - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_order();

        System.out.print("Remove menor: ");
        System.out.println(arvoreBinaria.remove_smaller());

        System.out.println("------------------------");
        System.out.println("REMOVE MENOR - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_order();






        arvoreBinaria.remove(10);
        System.out.print("ROOT: ");
        System.out.println(arvoreBinaria.get_root());
        System.out.println("------------------------");
        System.out.println("REMOVE - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_order();

        arvoreBinaria.remove(12);
        System.out.print("ROOT: ");
        System.out.println(arvoreBinaria.get_root());

        System.out.println("------------------------");
        System.out.println("REMOVE - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_order();




        arvoreBinaria.remove(13  );
        System.out.print("ROOT: ");
        System.out.println(arvoreBinaria.get_root());

        System.out.println("------------------------");
        System.out.println("REMOVE - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_order();

        arvoreBinaria.remove(8  );
        System.out.print("ROOT: ");
        System.out.println(arvoreBinaria.get_root());

        System.out.println("------------------------");
        System.out.println("REMOVE - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_order();

        arvoreBinaria.remove(9 );
        System.out.print("ROOT: ");
        System.out.println(arvoreBinaria.get_root());

        System.out.println("------------------------");
        System.out.println("REMOVE - In ordem");
        System.out.println("------------------------");
        arvoreBinaria.in_order();



        arvoreBinaria.in_order();


    }

}
