package ru.job4j.Test;

import java.util.LinkedList;
import java.util.List;

public class SimpleTree<E extends Comparable>   {
    /**
     * Root element of this tree.
     */
    private Leaf  root = null;
    /**
     * List of all this tree's children.
     */
    private List<Integer> allChilds = new LinkedList<>();


    public void addChild(int value) {
        if (value != 0){
            Leaf newLeaf = new Leaf(value);
            if (this.root == null) {
                this.root = newLeaf;
            } else {
                this.addLeaf(this.root, newLeaf);
            }
        }
    }


    public List getChildren() {
        this.allChilds.clear();
        this.getChilds(this.root.getChildren());
        return this.allChilds;
    }

    /**
     * Adds the new leaf to tree with specified root.
     * @param nodeLeaf specified root.
     * @param leaf the new leaf that adding to tree.
     */
    private void addLeaf(Leaf nodeLeaf, Leaf leaf) {
        if (nodeLeaf.canAdd()) {
            nodeLeaf.addChild(leaf);
        } else {
            List<Leaf > nodeChildren = nodeLeaf.getChildren();
            for (Leaf  current : nodeChildren) {
                if (current.canAdd()) {
                    this.addLeaf(current, leaf);
                }
            }
        }
    }

    /**
     * Returns all children of specified leaves list.
     * @param leaves specified leaves list.
     */
    private void getChilds(List<Leaf > leaves) {
        if (!leaves.isEmpty()) {
            for (Leaf leaf : leaves) {
                if (leaf != null && leaf.getValue() != 0) {
                    this.allChilds.add((Integer) leaf.getValue());
                    this.getChilds(leaf.getChildren());
                }
            }
        }
    }

    private class Leaf  {
        private int value;
        private List<Leaf > children = new LinkedList<>();
        private int index = 0;

        public Leaf(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void addChild(Leaf  child) {
            this.children.add(child);
            this.index++;
        }

        public List<Leaf> getChildren() {
            return this.children;
        }

        public boolean canAdd() {
            return this.index < 5;
        }
        public int getChildrenNumber() {
            return this.index;
        }
    }
}
