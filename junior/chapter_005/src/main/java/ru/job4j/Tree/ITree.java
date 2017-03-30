package ru.job4j.Tree;

import java.util.List;

/**
 * Interface for Tree.
 * @param <E>
 */

public interface ITree<E> {

    /**
     * Add element.
     * @param value
     */
   void addChild( E value);

    /**
     * Get element from Tree.
     * @return
     */
    List<E> getChildren();


}
