package com.familytree.tree;

import com.familytree.file.FileOperations;
import com.familytree.model.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human>, Serializable {
    private static final long serialVersionUID = 1L;
    private List<Human> humans;
    private FileOperations fileHandler;

    public FamilyTree(FileOperations fileHandler) {
        this.humans = new ArrayList<>();
        this.fileHandler = fileHandler;
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    @Override
    public Iterator<Human> iterator() {
        return humans.iterator();
    }

    public void printAllHumans() {
        for (Human human : humans) {
            System.out.println(human.getInfo());
        }
    }

    public void saveToFile(String filename) {
        fileHandler.saveToFile(filename, humans);
    }

    public void loadFromFile(String filename) {
        humans = fileHandler.loadFromFile(filename);
    }

    public void sortByName() {
        Collections.sort(humans, Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(humans, Comparator.comparing(Human::getBirthDate));
    }
}
