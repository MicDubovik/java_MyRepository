package ru.job4j.Tree;

import java.util.ArrayList;
import java.util.List;

public class MySimpleTree<E> implements ITree<E> {

    Node<E> root;


    public MySimpleTree() {

    }

    public void addChild(E value) {
        if (root == null) {
            root = new Node<E>(value);
        } else {
            root.addChild(value);
        }
    }

    @Override
    public List<E> getChildren() {

        List<E> eList = new ArrayList<E>();

        if (root == null) {
            return null;
        } else {
            eList = root.getChildren();
        }

        return eList;
    }


    public E find(E element) {

        E result = null;
        if (root != null) {
            result = root.find(element);
        }
        return result;
    }

    public boolean isBalancedTree() {
        boolean result = false;
        if (this.root != null) {
            result = this.root.isBalancedTree();
        }
        return result;
    }

    private class Node<E> implements ITree<E> {

        private E value;

        private Node<E> left;

        private Node<E> right;

        boolean nextLeft = true;


        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }


        @Override
        public void addChild(E value) {

            Node newNode = new Node(value);

            if (left == null) {
                left = newNode;
            } else if (right == null) {
                right = newNode;
            } else {
                if (nextLeft) {
                    left.addChild(value);
                    nextLeft = !nextLeft;
                } else {
                    right.addChild(value);
                    nextLeft = !nextLeft;
                }

            }
        }

        @Override
        public List<E> getChildren() {

            List<E> list = new ArrayList<E>();

            list.add(this.value);

            if (left != null) {

                list.addAll(this.left.getChildren());


            }
            if (right != null) {

                list.addAll(this.right.getChildren());

            }

            return list;
        }


        public E find(E element) {

            E result = null;

            if (!element.equals(this.value)) {

                result = left.find(element);

                if (result == null) {
                    result = right.find(element);
                }
            } else {
                result = this.value;
            }
            return result;
        }

        public boolean isBalancedTree() {
            boolean result = false;
            if (recursiveBalance() != -1) {
                result = true;
            }
            return result;
        }

        private int recursiveBalance() {
            int result = 0;

            int leftDepth = this.left.recursiveBalance();
            int rightDepth = this.right.recursiveBalance();
            if (leftDepth * rightDepth > 0 && leftDepth == rightDepth && leftDepth != -1) {
                result = leftDepth + 1;
            } else {
                result = -1;
            }
            return result;

        }
    }

}
