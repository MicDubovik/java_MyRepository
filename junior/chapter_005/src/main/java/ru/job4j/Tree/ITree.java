package ru.job4j.Tree;

import java.util.List;

public interface ITree<E> {

   void addChild( E value);

    List<E> getChildren();


}
