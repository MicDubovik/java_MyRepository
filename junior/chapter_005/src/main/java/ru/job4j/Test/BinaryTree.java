package ru.job4j.Test;

public class BinaryTree {

    Node root;

    public void addNode(Node node){

        Node newNode = node;
        if (root==null){
            root=newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true){
                parent = focusNode;
                if (node.key<focusNode.key){
                    focusNode = focusNode.leftchild;
                    if (focusNode==null){
                        parent.leftchild=newNode;
                        return;
                    }
                } else {
                    focusNode =focusNode.rightchild;
                    if (focusNode==null){
                        parent.rightchild=newNode;
                        return;
                    }
                }
            }
        }

    }
    public void inOrderTraversTree(Node focusNode){
        if (focusNode !=null){
            inOrderTraversTree(focusNode.leftchild);

            System.out.println(focusNode);

            inOrderTraversTree(focusNode.rightchild);
        }
    }
    public void preOrderTraversTree(Node focusNode){
        if (focusNode !=null){

            System.out.println(focusNode);

            preOrderTraversTree(focusNode.leftchild);

            preOrderTraversTree(focusNode.rightchild);
        }
    }
    public void postOrderTraversTree(Node focusNode){
        if (focusNode !=null){

            postOrderTraversTree(focusNode.leftchild);

            postOrderTraversTree(focusNode.rightchild);

            System.out.println(focusNode);
        }
    }



    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();



        binaryTree.addNode(new Node(50,"Mik"));
        binaryTree.addNode(new Node(25,"Vova"));
        binaryTree.addNode(new Node(15,"Hanna"));
        binaryTree.addNode(new Node(30,"Katy"));
        binaryTree.addNode(new Node(75,"Pavel"));
        binaryTree.addNode(new Node(80,"Ruslan"));

        binaryTree.inOrderTraversTree(binaryTree.root);
        System.out.println("--------------");
        binaryTree.preOrderTraversTree(binaryTree.root);
        System.out.println("--------------");
        binaryTree.postOrderTraversTree(binaryTree.root);
    }



//   class Node{
//
//        int key;
//        String name;
//        Node leftchild;
//        Node rightchild;
//
//        public Node(int key, String name) {
//            this.key = key;
//            this.name = name;
//        }
//
//        @Override
//        public String toString() {
//            return   name +"has a key"  + key;
//
//        }
//    }
}
