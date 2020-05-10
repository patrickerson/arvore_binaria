package com.Patrickerson.ArvoreBinaria.Classes;

public class ArvoreBinaria {

    private Node root;


    boolean not_void(){

        return root != null;
    }

    public void inserir(int info){
        if (root == null) {
            Node node = new Node();
            node.insertValue(info);
            root = node;
        }else {
            recursive_insert(info, root);
        }
    }
    private void recursive_insert(int info, Node actualNode) {

        if (info < actualNode.getInfo()) {
            Node node = actualNode.getLeft();
            if (node == null) {
                Node newNode = new Node();
                newNode.insertValue(info);
                actualNode.insertLeft(newNode);
            } else {
                recursive_insert(info, actualNode.getLeft());
            }
        } else {
            Node node = actualNode.getRight();
            if (node == null) {
                Node new_node = new Node();
                new_node.insertValue(info);
                actualNode.insertRight(new_node);
            } else {
                recursive_insert(info, actualNode.getRight());
            }
        }

    }

    public void pre_order(){
        before_order_recursive(root);
    }

    private void before_order_recursive(Node node){
        if(node !=null) {
            System.out.println(node.getInfo());
            before_order_recursive(node.getLeft());
            before_order_recursive(node.getRight());
        }


    }

    public  void in_order(){
        in_order_recursive(root);
    }
    private void in_order_recursive(Node node){
    if(node !=null) {
        in_order_recursive(node.getLeft());
        System.out.println(node.getInfo());
        in_order_recursive(node.getRight());
    }
    }

    public void pos_order(){
        after_order_recursive(root);
    }

    private void after_order_recursive(Node node){
        if(node !=null) {
            after_order_recursive(node.getLeft());
            after_order_recursive(node.getRight());
            System.out.println(node.getInfo());

        }
    }


    public int remove_biggest(){
        if(not_void()) {

            if(root.getRight() == null){
                root = root.getLeft();
            }
            else {
                return remove_maior_recursivo(root);
            }}System.out.println("Arvore vazia");
        return 0;
    }

    private int remove_maior_recursivo(Node node){
        if(node.getRight() != null) {
            if (node.getRight().getRight() == null) {
                int removed_node = node.getRight().getInfo();
                node.insertRight(null);
                return removed_node;


            } else {
                return remove_maior_recursivo(node.getRight());
            }
        }else{
            return 0;
        }
    }


    public int remove_smaller(){
        if(not_void()) {
            if (root.getLeft() != null) {
                return remove_smaller_recursive(root);
            }else {
                int info_removed = root.getInfo();
                root = root.getRight();
                return  info_removed;
            }
        }else{

        return 0;}
    }

    private int remove_smaller_recursive(Node node){
        if (node.getLeft() != null){
            if(node.getLeft().getLeft() == null) {
                int removed_node = node.getLeft().getInfo();
                node.insertLeft(null);
                return removed_node;
            }else {
                return remove_smaller_recursive(node.getLeft());

        }

        }

        return node.getInfo();
    }

    

    public void remove(int valor){
        if(not_void() && root.getInfo() != valor){
            remove_recursive(valor, root, null);
        }else{
            if (root.getRight() != null) {
                System.out.println("Right not null");
                Node new_node = new Node();
                new_node.insertValue(remove_smaller_recursive(root.getRight()));

                Node after_left = root.getLeft();
                Node after_right = root.getRight();

                new_node.insertRight(after_right);
                new_node.insertLeft(after_left);
                root = new_node;


            } else if (root.getLeft() != null) {
                System.out.println("Left not null");
                Node new_node = new Node();
                new_node.insertValue(remove_maior_recursivo(root.getLeft()));

                Node after_left = root.getLeft();
                Node after_right = root.getRight();

                new_node.insertLeft(after_left);
                new_node.insertRight(after_right);

                root = new_node;

            } else {
                System.out.println("left and right null");
                root = null;

            }
        }
    }


    private  void remove_recursive(int valor, Node node, Node node_before) {
        if (node != null) {
            System.out.println("Node not null");
            System.out.println(node.getInfo());
            if (node.getInfo() != valor) {
                if (node.getInfo() > valor) {
                    if(node.getLeft() !=null) {
                        remove_recursive(valor, node.getLeft(), node);
                    }
                }else {
                    if(node.getRight() != null) {
                        remove_recursive(valor, node.getRight(), node);
                    }
                }
            } else {
                System.out.println("Found the node");
                if (node.getRight() != null) {
                    System.out.println("Right not null");
                    Node new_node = new Node();
                    new_node.insertValue(remove_maior_recursivo(node.getRight()));

                    Node after_left = node.getLeft();
                    Node after_right = node.getRight();

                    new_node.insertRight(after_right);
                    new_node.insertLeft(after_left);
                    node_before.insertLeft(new_node);


                } else if (node.getLeft() != null) {
                    System.out.println("Left not null");
                    Node new_node = new Node();
                    new_node.insertValue(remove_maior_recursivo(node.getLeft()));

                    Node after_left = node.getLeft();
                    Node after_right = node.getRight();

                    new_node.insertLeft(after_left);
                    new_node.insertRight(after_right);
                    node_before.insertRight(new_node);

                } else {
                    System.out.println("left and right null");
                    if(node_before.getInfo() <= valor){
                        node_before.insertRight(null);
                    }else{
                        node_before.insertLeft(null);
                    }


                }
            }
        }
    }

}
