package com.Patrickerson.ArvoreBinaria.Classes;

public class ArvoreBinaria {

    private Node raiz;


    boolean not_vazio(){

        return raiz != null;
    }

    public void inserir(int info){
        if (raiz == null) {
            Node no = new Node();
            no.insereValor(info);
            raiz = no;
        }else {
            inserir_recursivo(info, raiz);
        }
    }
    private void inserir_recursivo(int info, Node no_atual) {

        if (info < no_atual.getInfo()) {
            Node no = no_atual.getEsquerda();
            if (no == null) {
                Node novo_no = new Node();
                novo_no.insereValor(info);
                no_atual.insereEsquerda(novo_no);
            } else {
                inserir_recursivo(info, no_atual.getEsquerda());
            }
        } else {
            Node no = no_atual.getDireita();
            if (no == null) {
                Node novo_no = new Node();
                novo_no.insereValor(info);
                no_atual.insereDireita(novo_no);
            } else {
                inserir_recursivo(info, no_atual.getDireita());
            }
        }

    }

    public void pre_ordem(){
        pos_ordem_recursivo(raiz);
    }

    private void pre_ordem_recursivo(Node node){
        if(node !=null) {
            System.out.println(node.getInfo());
            pre_ordem_recursivo(node.getEsquerda());
            pre_ordem_recursivo(node.getDireita());
        }


    }

    public  void in_ordem(){
        in_ordem_recursivo(raiz);
    }
    private void in_ordem_recursivo(Node node){
    if(node !=null) {
        in_ordem_recursivo(node.getEsquerda());
        System.out.println(node.getInfo());
        in_ordem_recursivo(node.getDireita());
    }
    }

    public void pos_ordem(){
        pos_ordem_recursivo(raiz);
    }

    private void pos_ordem_recursivo(Node node){
        if(node !=null) {
            pos_ordem_recursivo(node.getEsquerda());
            pos_ordem_recursivo(node.getDireita());
            System.out.println(node.getInfo());

        }
    }


    public int remove_maior(){
        if(not_vazio()) {

            if(raiz.getDireita() == null){
                raiz = raiz.getEsquerda();
            }
            else {
                return remove_maior_recursivo(raiz);
            }}System.out.println("Arvore vazia");
        return 0;
    }

    private int remove_maior_recursivo(Node node){
        if(node.getDireita() != null) {
            if (node.getDireita().getDireita() == null) {
                int removed_node = node.getDireita().getInfo();
                node.insereDireita(null);
                return removed_node;


            } else {
                return remove_maior_recursivo(node.getDireita());
            }
        }else{
            return 0;
        }
    }


    public int remove_menor(){
        if(not_vazio()) {
            if (raiz.getEsquerda() != null) {
                return remove_menor_recursivo(raiz);
            }else {
                int info_removed = raiz.getInfo();
                raiz = raiz.getDireita();
                return  info_removed;
            }
        }else{

        return 0;}
    }

    private int remove_menor_recursivo(Node node){
        if (node.getEsquerda() != null){
            if(node.getEsquerda().getEsquerda() == null) {
                int removed_node = node.getEsquerda().getInfo();
                node.insereEsquerda(null);
                return removed_node;
            }else {
                return remove_menor_recursivo(node.getEsquerda());

        }

        }

        return node.getInfo();
    }


    private void substitui_direita(){

    }

    public void remove(int valor){
        if(not_vazio() && raiz.getInfo() != valor){
            remove_recursivo(valor, raiz, null);
        }else{
            if (raiz.getDireita() != null) {
                System.out.println("Right not null");
                Node new_node = new Node();
                new_node.insereValor(remove_menor_recursivo(raiz.getDireita()));

                Node after_left = raiz.getEsquerda();
                Node after_right = raiz.getDireita();

                new_node.insereDireita(after_right);
                new_node.insereEsquerda(after_left);
                raiz = new_node;


            } else if (raiz.getEsquerda() != null) {
                System.out.println("Left not null");
                Node new_node = new Node();
                Node after_left = raiz.getEsquerda();
                Node after_right = raiz.getDireita();
                new_node.insereValor(remove_maior_recursivo(raiz.getEsquerda()));
                new_node.insereEsquerda(after_left);
                new_node.insereDireita(after_right);
                after_left.insereDireita(new_node);

            } else {
                System.out.println("left and right null");
                raiz = null;

            }
        }

    }


    private  void remove_recursivo(int valor, Node node, Node node_before) {
        if (node != null) {
            System.out.println("Node not null");
            System.out.println(node.getInfo());
            if (node.getInfo() != valor) {
                if (node.getInfo() > valor) {
                    if(node.getEsquerda() !=null) {
                        remove_recursivo(valor, node.getEsquerda(), node);
                    }
                }else {
                    if(node.getDireita() != null) {
                        remove_recursivo(valor, node.getDireita(), node);
                    }
                }
            } else {
                System.out.println("Found the node");
                if (node.getDireita() != null) {
                    System.out.println("Right not null");
                    Node new_node = new Node();
                    Node after_left = node.getEsquerda();
                    Node after_right = node.getDireita();
                    new_node.insereValor(remove_maior_recursivo(node.getDireita()));
                    new_node.insereDireita(after_right);
                    new_node.insereEsquerda(after_left);
                    node_before.insereEsquerda(new_node);


                } else if (node.getEsquerda() != null) {
                    System.out.println("Left not null");
                    Node new_node = new Node();
                    Node after_left = node.getEsquerda();
                    Node after_right = node.getDireita();
                    new_node.insereValor(remove_maior_recursivo(node.getEsquerda()));
                    new_node.insereEsquerda(after_left);
                    new_node.insereDireita(after_right);
                    node_before.insereDireita(new_node);

                } else {
                    System.out.println("left and right null");
                    remove_maior_recursivo(node);

                }
            }
        }
    }

}
