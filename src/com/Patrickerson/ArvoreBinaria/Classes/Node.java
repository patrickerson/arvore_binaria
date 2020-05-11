package com.Patrickerson.ArvoreBinaria.Classes;

public class Node {
    private int info;
    private Node left;
    private Node right;


    public int getInfo(){

        return info;
    }

    public Node getLeft(){

        return left;
    }

    public  Node getRight(){

        return right;
    }


    public void insertRight(Node node){

        this.right = node;
    }

    public void insertLeft(Node node){

        this.left = node;
    }

    public  void insertValue(int value){
        this.info = value;
    }

}
