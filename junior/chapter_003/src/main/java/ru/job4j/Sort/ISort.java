package ru.job4j.Sort;

import java.io.File;
import java.io.IOException;

/**
 * Created by Katy on 10.03.2017.
 */
public interface ISort {

    void sort(File source, File distance) throws IOException;
}
