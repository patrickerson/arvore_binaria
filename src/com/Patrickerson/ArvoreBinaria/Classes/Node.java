package com.Patrickerson.ArvoreBinaria.Classes;

public class Node {
    private int info;
    private Node esquerda;
    private Node direita;


    public int getInfo(){
        return info;
    }

    public Node getEsquerda(){
        return esquerda;
    }

    public  Node getDireita(){
        return direita;
    }


    public void insereDireita(Node inserir){

        this.direita = inserir;
    }

    public void insereEsquerda(Node inserir){

        this.esquerda = inserir;
    }

    public  void insereValor(int valor){
        this.info = valor;
    }

    public  void remove(){


    }
}
