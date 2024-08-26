package com.familytree.model;

import com.familytree.file.FileOperations;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

//public class FamilyTree implements Iterable<Human>, Serializable {
public class FamilyTree<T> implements Iterable<T>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private List<T> elements;
    private final FileOperations<T> fileHandler;

    public FamilyTree(FileOperations<T> fileHandler) {
        this.elements = new ArrayList<>();
        this.fileHandler = fileHandler;
    }

    public void addElement(T element) {
        elements.add(element);
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    public void printAllElements() {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public void saveToFile(String filename) {
        fileHandler.saveToFile(filename, elements);
    }

    public void loadFromFile(String filename) {
        elements = fileHandler.loadFromFile(filename);
    }

    public void sortByName(Comparator<T> comparator) {
        Collections.sort(elements, comparator);
    }

    public void sortByBirthDate(Comparator<T> comparator) {
        Collections.sort(elements, comparator);
    }
}
