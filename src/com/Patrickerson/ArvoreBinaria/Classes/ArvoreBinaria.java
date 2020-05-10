package com.Patrickerson.ArvoreBinaria.Classes;

public class ArvoreBinaria {

    private Node root;


    boolean not_void(){

        return root != null;
    }

    public int get_root(){
        if(not_void()) {
            return root.getInfo();
        }
        System.out.println("raiz nula");
        return 0;
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
        if(not_void()) return remove_maior_recursivo(root, null);

        return 0;
    }

    private int remove_maior_recursivo(Node node, Node node_before){
        if (node_before == null && root.getRight() == null){
            int removed_value = root.getInfo();
            root = root.getLeft();
            return removed_value;
        }
        if(node.getRight() == null && node_before != null) {
            int removed_node = node.getInfo();
            node_before.insertRight(null);
            return removed_node;

        }else{
            return remove_maior_recursivo(node.getRight(), node);
        }
    }


    public int remove_smaller(){

        if(not_void()) return remove_smaller_recursive(root, null);
        return 0;
    }

    private int remove_smaller_recursive(Node node, Node node_before){

        if (node_before == null && root.getLeft() == null){
            int temp_value = root.getInfo();
            root = root.getRight();
            return temp_value;
        }
        if (node.getLeft() == null && node_before != null ) {

            int removed_node = node.getInfo();
            node_before.insertLeft(null);

            return removed_node;

        } else {
                return remove_smaller_recursive(node.getLeft(), node);}


    }

    

    public void remove(int valor){
        if(not_void() && root.getInfo() != valor){
            remove_recursive(valor, root, null);
        }else{
            if (root.getRight() != null) {

                Node new_node = new Node();
                Node after_left = root.getLeft();
                Node after_right = root.getRight();

                new_node.insertValue(remove_smaller_recursive(root.getRight(), root));
                root = new_node;


                if(root.getInfo() != after_right.getInfo())
                    new_node.insertRight(after_right);

                new_node.insertLeft(after_left);


            } else if (root.getLeft() != null ) {

                Node new_node = new Node();

                Node after_left = root.getLeft();
                Node after_right = root.getRight();

                new_node.insertValue(remove_maior_recursivo(root.getLeft(), root));
                root = new_node;

                if(root.getInfo() != after_left.getInfo())
                    new_node.insertLeft(after_left);
                new_node.insertRight(after_right);

                root = new_node;

            } else {
                root = null;
            }
        }
    }


    private  void remove_recursive(int valor, Node node, Node node_before) {
        if (node != null) {

            if (node.getInfo() != valor) {
                if (node.getInfo() > valor) {
                    if(node.getLeft() != null) {
                        remove_recursive(valor, node.getLeft(), node);
                    }
                }else {
                    if(node.getRight() != null) {
                        remove_recursive(valor, node.getRight(), node);
                    }
                }
            } else {


                if (node.getRight() != null) {

                    Node new_node = new Node();

                    Node after_left = node.getLeft();
                    Node after_right = node.getRight();

                    new_node.insertValue(remove_maior_recursivo(node.getRight(), node_before));


                    if(node.getRight().getInfo() != after_right.getInfo()) new_node.insertRight(after_right);
                    new_node.insertLeft(after_left);
                    node_before.insertLeft(new_node);


                } else if (node.getLeft() != null) {

                    Node new_node = new Node();

                    Node after_left = node.getLeft();
                    Node after_right = node.getRight();

                    new_node.insertValue(remove_maior_recursivo(node.getLeft(), node_before));



                    if(node.getLeft().getInfo() != after_left.getInfo()) new_node.insertLeft(after_left);
                    new_node.insertRight(after_right);
                    node_before.insertRight(new_node);

                } else {

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
