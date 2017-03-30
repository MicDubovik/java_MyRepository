package ru.job4j.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class BinaryTree.
 * @param <E>
 */
public class MyBinary<E extends Comparable<E>> implements ITree<E> {
    /**
     * Root .
     */
    private Node<E> root;

    /**
     * Add root ,and add child.
     * @param value
     */
    @Override
    public void addChild(E value) {
        if (this.root != null) {
            this.root = new Node<E>(value);
        } else {
            this.root.addChild(value);
        }

    }

    /**
     * Get List elements.
     * @return
     */
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

    /**
     * Find element.
     * @param element
     * @return
     */
    public E find(E element) {

        E result = null;
        if (root != null) {
            result = root.find(element);
        }
        return result;
    }

    /**
     * Class Node.
     * @param <E>
     */
    private class Node<E extends Comparable<E>> implements ITree<E> {

        private E value;
        /**
         * Reference at left element.
         */
        private Node<E> left;
        /**
         * Reference at right element.
         */
        private Node<E> right;

        /**
         * Constructor .
         * @param value
         */
        public Node(E value) {
            this.value = value;

        }

        /**
         * Get value.
         * @return
         */
        public E getValue() {
            return value;
        }

        /**
         * Getleft .
         * @return
         */
        public Node<E> getLeft() {
            return left;
        }

        /**
         * SetLeft.
         * @param left
         */
        public void setLeft(Node<E> left) {
            this.left = left;
        }

        /**
         * GetRight.
         * @return
         */
        public Node<E> getRight() {
            return right;
        }

        /**
         * SetRight.
         * @param right
         */
        public void setRight(Node<E> right) {
            this.right = right;
        }

        /**
         * Add element on tree.
         * @param value
         */
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

        /**
         * Get List elements .
         * @return
         */
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

        /**
         * Find element in tree.
         * @param value
         * @return
         */
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
