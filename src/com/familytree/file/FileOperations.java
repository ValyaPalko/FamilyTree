package com.familytree.file;

import com.familytree.model.Human;

import java.util.List;

public interface FileOperations<T> {
    void saveToFile(String filename, List<T> elements);
    List<T> loadFromFile(String filename);
}

