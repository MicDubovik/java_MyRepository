package ru.job4j.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * MySimpleTree<E>.
 * @param <E>
 */
public class MySimpleTree<E> implements ITree<E> {

    /**
     * Root.
     */
    Node<E> root;

    /**
     * Add element.
     * @param value
     */
    public void addChild(E value) {
        if (root == null) {
            root = new Node<E>(value);
        } else {
            root.addChild(value);
        }
    }

    /**
     * Get element.
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
     * Check isBalanced Tree.
     * @return
     */
    public boolean isBalancedTree() {
        boolean result = false;
        if (this.root != null) {
            result = this.root.isBalancedTree();
        }
        return result;
    }

    /**
     * Class Node.
     * @param <E>
     */
    private class Node<E> implements ITree<E> {
        /**
         * Value .
         */
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
         * Boolean switch.
         */
        boolean nextLeft = true;

        /**
         * Constructor.
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
         * Add child element.
         * @param value
         */
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

        /**
         * Get List elements.
         * @return
         */
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

        /**
         * Find element on Tree.
         * @param element
         * @return
         */
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

        /**
         * Check isBalanced Tree.
         * @return
         */
        public boolean isBalancedTree() {
            boolean result = false;
            if (recursiveBalance() != -1) {
                result = true;
            }
            return result;
        }

        /**
         * subsidiary  method for isBalance.
         * @return
         */
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
