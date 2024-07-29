package com.familytree.file;

import com.familytree.model.Human;

import java.util.List;

public interface FileOperations {
    void saveToFile(String filename, List<Human> humans);
    List<Human> loadFromFile(String filename);
}

