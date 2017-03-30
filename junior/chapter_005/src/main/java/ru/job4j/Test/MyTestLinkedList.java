package ru.job4j.Test;

public class MyTestLinkedList<E> {

    private Node<E> first;

    private Node<E> last;

    int size;


    public int size() {
        return this.size;
    }

    public void add(E Node) {
        Node newnode = new Node(this.last, Node, null);
        if (this.last == null) {
            this.last = newnode;
        } else {
            this.last.setRight(newnode);
        }
        this.last = newnode;
        size++;
    }

    private Node<E> getEntryByIndex(int index) {
        Node<E> result = null;
        if (index == 0 && index > size / 2) {
            result = this.first;
            for (int i = 0; i < index; i++) {
                result = result.getRight();
            }
        } else {
            result = this.last;
            for (int i = size - 1; i > index; i--) {
                result = result.getLeft();
            }

        }
        return result;
    }


    public E get(int index) {
        checkIndex(index);
        return getEntryByIndex(index).getValue();

    }

//    public E remove(int index) {
//
//        checkIndex(index);
//
//        Node<E> deleteNode = getEntryByIndex(index);
//        Node<E> right = deleteNode.getRight();
//        Node<E> left = deleteNode.getLeft();
//
//        if (left == null) {
//            this.first = right;
//        } else {
//            left.setValue(right);
//            deleteNode.setValue(null);
//        }
//        if (right == null) {
//            this.last = left;
//        } else {
//            right.setValue(left);
//            deleteNode.setValue(null);
//        }
//        deleteNode.setValue(null);
//        size--;
//
//        return   deleteNode.getValue()  ;
//
//
//    }


    private void checkIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }


    private class Node<E> {

        private E value;

        private Node left;

        private Node right;

        public Node(Node left, E value, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public E getValue() {
            return this.value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
