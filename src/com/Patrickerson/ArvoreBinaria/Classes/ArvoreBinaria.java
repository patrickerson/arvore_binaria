package com.Patrickerson.ArvoreBinaria.Classes;

public class ArvoreBinaria {
    private Node root;

    void print_tree(Node node) {
        int space_number = height_recursive(node) * 4;
        while (space_number != -1) {
            System.out.print(" ");
            space_number--;
        }
    }

    boolean not_void(){

        return root != null;
    }

    public Node get_root(){
            return root;

    }

    public void search(int info){
        if(recursive_search(info, root)){ System.out.println("Existe");}
        else {System.out.print("não existe");}
    }
    private boolean recursive_search(int info, Node node){
        if(node !=null) {
            if(node.getInfo() != info) {
                if (node.getInfo() > info) return recursive_search(info, node.getLeft());
                return recursive_search(info, node.getRight());
            }
            return true;
        }
        return false;
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
                rotation_control(root);
            } else {
                recursive_insert(info, actualNode.getLeft());
            }
        } else {
            Node node = actualNode.getRight();
            if (node == null) {
                Node new_node = new Node();
                new_node.insertValue(info);
                actualNode.insertRight(new_node);
                rotation_control(root);
            } else {
                recursive_insert(info, actualNode.getRight());

            }
        }
    }

    public void pre_order(){
        System.out.println("------------");
        System.out.println("| Pre order |");
        System.out.println("------------");
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
        System.out.println("------------");
        System.out.println("| In order  |");
        System.out.println("------------");
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


        System.out.println("------------");
        System.out.println("Pos ordem");
        System.out.println("------------");
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
        if(not_void()) return remove_biggest_recursive(root, null);
        return 0;
    }

    private int remove_biggest_recursive(Node node, Node node_before){
        if (node_before == null && root.getRight() == null){
            int removed_value = root.getInfo();
            root = root.getLeft();
            if(root != null)  rotation_control(root);
            return removed_value;
        }
        if(node.getRight() == null && node_before != null) {
            int removed_node = node.getInfo();
            node_before.insertRight(null);
            rotation_control(root);
            return removed_node;
        }else{
            return remove_biggest_recursive(node.getRight(), node);
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
            if(root != null) rotation_control(root);
            return temp_value;
        }
        if (node.getLeft() == null && node_before != null ) {
            int removed_node = node.getInfo();
            node_before.insertLeft(null);
            rotation_control(root);
            return removed_node;

        } else {
                return remove_smaller_recursive(node.getLeft(), node);
        }
    }

    public void remove(int valor){
        if(not_void() && root.getInfo() != valor){
            remove_recursive(valor, root, null);
        }else{
            if (root.getRight() != null) {

                Node new_node = new Node();
                Node after_left = root.getLeft();
                Node after_right = root.getRight().getRight();

                new_node.insertValue(remove_smaller_recursive(root.getRight(), root));

                new_node.insertRight(after_right);
                new_node.insertLeft(after_left);
                root = new_node;

                rotation_control(root);
            } else if (root.getLeft() != null ) {
                Node new_node = new Node();

                Node after_left = root.getLeft().getLeft();
                Node after_right = root.getRight();

                new_node.insertValue(remove_biggest_recursive(root.getLeft(), root));



                if(root.getInfo() != after_left.getInfo()) new_node.insertLeft(after_left);
                new_node.insertRight(after_right);

                root = new_node;
                rotation_control(root);
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
                System.out.print("LEFT: ");
                System.out.println(root.getLeft().getInfo());
                if (node.getRight() != null) {
                    Node new_node = new Node();

                    Node after_left = node.getLeft();
                    Node after_right = node.getRight().getRight();

                    new_node.insertValue(remove_biggest_recursive(node.getRight(), node_before));

                    new_node.insertRight(after_right);
                    new_node.insertLeft(after_left);
                    node_before.insertRight(new_node);

                } else if (node.getLeft() != null) {
                    Node new_node = new Node();
                    Node after_left = node.getLeft().getLeft();
                    Node after_right = node.getRight();

                    new_node.insertValue(remove_biggest_recursive(node.getLeft(), node_before));

                   new_node.insertLeft(after_left);
                    new_node.insertRight(after_right);
                    node_before.insertRight(new_node);



                } else {


                    if(node_before.getInfo() <= valor){
                        node_before.insertRight(null);

                    }else{
                        System.out.println("menor que node anterior");
                        node_before.insertLeft(null);

                    }
                }
            }

            rotation_control(root);

        }


    }


    public int height(){
        return height_recursive(root);
    }
    private int height_recursive(Node node){
        if(node == null){
            return -1;
        }
        int left = height_recursive(node.getLeft());
        int right = height_recursive(node.getRight());

        if(left > right) return  1 + left;
        return 1 + right;

    }

    public void right_rotation(Node node, Node father){
        Node newRoot = node.getLeft();
        Node temp = newRoot.getRight();
        newRoot.insertRight(node);
        node.insertLeft(temp);

        if(father == null) root = newRoot;
        else father.insertRight(newRoot);}

    public void left_rotation(Node node, Node father){
        Node newRoot = node.getRight();
        Node temp = newRoot.getLeft();
        newRoot.insertLeft(node);
        node.insertRight(temp);

        if(father == null) root = newRoot;
        else father.insertLeft(newRoot);
    }

    public int balance(Node node){
        return height_recursive(node.getLeft()) - height_recursive(node.getRight());
    }
    public void rotation_control(Node node){
        int fb = balance(node);
        if(fb == -2){

            int fbf = balance(node.getRight());
            if (fbf == 1) right_rotation(node.getRight(), node);

            left_rotation(node, null);



        }else if(fb == 2){
            int fbf = balance(node.getLeft());
            if(fbf == -1) left_rotation(node.getLeft(), node);
            right_rotation(node, null);
        }
    }

}
