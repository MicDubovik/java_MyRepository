package ru.job4j.Test;

import java.util.ArrayList;
import java.util.List;

public class MySimpleTree    {

    /**
     * Root element of tree container.
     */
    private Element  root;
    /**
     * Max count of children.
     */
    private int maxChildrenCount;
    /**
     * Default maximum count of child elements in every nodes.
     */
    private static final int DEFAULT_CHILDREN_COUNT = 2;

    /**
     * Default constructor.
     */
    public MySimpleTree() {
        this(DEFAULT_CHILDREN_COUNT);
    }

    /**
     * Constructor.
     * @param maxChildrenCount - max count of child element.
     */
    public MySimpleTree(int maxChildrenCount) {
        this.root = null;
        this.maxChildrenCount = maxChildrenCount;
    }

    /**
     * Add new lement to container.
     * @param element - new element.
     */

//    public void addChild(String element) {
//        if (element != null) {
//            if (this.root == null) {
//                this.root = new Element (element, this.maxChildrenCount);
//            } else {
//                this.root.addChild(element);
//            }
//        }
//    }
//
//    /**
//     * Get all children from container.
//     * @return all existing children.
//     */
//
//    public List<String> getChildren() {
//        return this.root == null ? null : this.root.getChildren();
//    }
//
//    /**
//     * Find some element in container.
//     * @param element - element for find.
//     * @return element if it's contained in container else return null.
//     */
//
//    public String find(String element) {
//        String result = null;
//        if (element != null) {
//            result = this.root == null ? null : this.root.find(element);
//        }
//        return result;
//    }
//
//    /**
//     * Check balance in this tree container.
//     * @return true if tree is sbalanced else false.
//     */
//
//    public boolean isBalancedTree() {
//        return this.root == null ? false : this.root.isBalancedTree();
//    }

    /**
     * Class represent one element in tree structure.
     * @param   - type of element content
     */
    private class Element   {

        /**
         * Content of element.
         */
        private final String data;
        /**
         * List of child elements.
         */
        private List<String> children;
        /**
         * Max count of children.
         */
        private int maxChildrenCount;
        /**
         * Current index for adding element.
         */
        private int index;

        /**
         * Constructor.
         * @param data - content for this element.
         */
        Element(String data) {
            this( data, 2);
        }

        /**
         * Constructor.
         * @param data - content for this element.
         * @param maxChildrenCount - max posible count of child elements.
         */
        Element(String data, int maxChildrenCount) {
            this.data = data;
            this.maxChildrenCount = maxChildrenCount;
            this.index = 0;
            this.children = new ArrayList<>();
        }

        /**
         * Add new lement to container.
         * @param element - new element.
         */

//        public void addChild(String element) {
//            if (children.size() == maxChildrenCount) {
//                children.get(index++).addChild(element);
//                index %= maxChildrenCount;
//            } else {
//                children.add(new Element(element));
//            }
//        }
//
//        /**
//         * Get all children from container.
//         * @return all existing children.
//         */
//
//        public List<String> getChildren() {
//            List<String> result = new ArrayList<>();
//            result.add(data);
//            for (Element  element : this.children) {
//                result.addAll(element.getChildren());
//            }
//            return result;
//        }
//
//        /**
//         * Find some element in container (recursive).
//         * @param element - element for find.
//         * @return element if it's contained in container else return null.
//         */
//
//        public String find(String element) {
//            String result = null;
//            if (!element.equals(this.data)) {
//                for (Element  child : this.children) {
//                    result = child.find(element);
//                    if (result != null) {
//                        break;
//                    }
//                }
//            } else {
//                result = this.data;
//            }
//            return result;
//        }
//
//        /**
//         * Check balance in this tree container.
//         * @return true if tree i sbalanced else false.
//         */
//
//        public boolean isBalancedTree() {
//            boolean result = false;
//            if (recursiveBalance() != -1) {
//                result = true;
//            }
//            return result;
//        }
//
//        /**
//         * Recursively check balanced tree structure.
//         * @return "-1" if tree is not balanced.
//         */
//        private int recursiveBalance() {
//            int result;
//            if (this.children.size() == 2) {
//                int firstDepth = this.children.get(0).recursiveBalance();
//                int secondDepth = this.children.get(1).recursiveBalance();
//                if (firstDepth * secondDepth > 0 && firstDepth == secondDepth && firstDepth != -1) {
//                    result = firstDepth + 1;
//                } else {
//                    result = -1;
//                }
//            } else if (this.children.isEmpty()) {
//                result = 1;
//            } else {
//                result = -1;
//            }
//            return result;
//        }
    }
}
