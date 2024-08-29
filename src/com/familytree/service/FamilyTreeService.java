package com.familytree.service;

import com.familytree.model.FamilyTree;
import com.familytree.model.Human;
import com.familytree.file.FileHandler;

import java.io.IOException;
import java.util.Optional;

public class FamilyTreeService {
    private FamilyTree<Human> familyTree;
    private FileHandler<FamilyTree<Human>> fileHandler;

    public FamilyTreeService(FamilyTree<Human> familyTree, FileHandler<FamilyTree<Human>> fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    public void addHuman(Human human) {
        familyTree.addElement(human);
    }

    public void createRelationship(Human parent, Human child) {
        if (parent != null && child != null) {
            parent.getChildren().add(child);
            if (parent.getGender() == Gender.Famele) {
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

    public void saveToFile(String fileName) {
        try {
            fileHandler.save(familyTree, fileName);
            System.out.println("Данные успешно сохранены в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) {
        try {
            Optional<FamilyTree<Human>> loadedTree = fileHandler.load(fileName);
            loadedTree.ifPresent(tree -> familyTree = tree);
            System.out.println("Данные успешно загружены из файла " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке файла: " + e.getMessage());
        }
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }
}

