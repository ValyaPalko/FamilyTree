package com.familytree.service;

import com.familytree.model.FamilyTree;
import com.familytree.model.Gender;
import com.familytree.model.Human;
import com.familytree.file.FileHandlerInterface;

import java.io.IOException;
import java.util.Optional;

public class FamilyTreeService {
    private FamilyTree<Human> familyTree;
    private FileHandlerInterface<FamilyTree<Human>> fileHandler;

    public FamilyTreeService(FamilyTree<Human> familyTree, FileHandlerInterface<FamilyTree<Human>> fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    public void addHuman(Human human) {
        familyTree.addElement(human);
    }

    public void createRelationship(Human parent, Human child) {
        if (parent != null && child != null) {
            parent.getChildren().add(child);
            if (parent.getGender() == Gender.Female) {
                child.setMother(parent);
            } else {
                child.setFather(parent);
            }
        }
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public boolean saveToFile(String fileName) {
        try {
            fileHandler.save(familyTree, fileName);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean loadFromFile(String fileName) {
        try {
            Optional<FamilyTree<Human>> loadedTree = fileHandler.load(fileName);
            loadedTree.ifPresent(tree -> familyTree = tree);
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }
}

