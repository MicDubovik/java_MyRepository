package ru.job4j.Tree;

import java.util.ArrayList;
import java.util.List;

public class MyBinary<E extends Comparable<E>> implements ITree<E> {

    private Node<E> root;


    @Override
    public void addChild(E value) {
        if (this.root != null) {
            this.root = new Node<E>(value);
        } else {
            this.root.addChild(value);
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

    private class Node<E extends Comparable<E>> implements ITree<E> {

        private E value;

        private Node<E> left;

        private Node<E> right;

        public Node(E value) {
            this.value = value;

        }

        public E getValue() {
            return value;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public void addChild(E value) {

            Node<E> newNode = new Node<E>(value);
            Node<E> parent;
            Node<E> candidate = this;
            while (true) {
                parent = candidate;
                if (value.compareTo(parent.getValue()) < 0) {
                    candidate = parent.left;
                    if (candidate.getValue() == null) {
                        parent.left.setLeft(newNode);
                        break;
                    }
                } else {
                    candidate = parent.right;
                    if (candidate.getValue() == null) {
                        parent.right.setRight(newNode);
                        break;
                    }
                }
            }
        }

        @Override
        public List<E> getChildren() {
            List<E> list = new ArrayList<E>();

            list.add(this.value);

            if (this.left != null) {

                list.addAll(this.left.getChildren());

            }
            if (this.right != null) {

                list.addAll(this.right.getChildren());

            }

            return list;
        }

        public E find(E value) {
            E result = null;
            E checkingValue;
            Node<E> current = this;
            while (true) {
                checkingValue = current.getValue();
                if (checkingValue == null || result != null) {
                    break;
                }
                if (value.equals(checkingValue)) {
                    result = checkingValue;
                } else if (value.compareTo(checkingValue) < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return result;

        }

    }
}
