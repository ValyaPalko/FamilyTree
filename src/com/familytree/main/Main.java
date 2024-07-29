package com.familytree.main;

import com.familytree.file.FileHandler;
import com.familytree.file.FileOperations;
import com.familytree.model.Gender;
import com.familytree.model.Human;
import com.familytree.tree.FamilyTree;

import java.io.File;
import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
        Human mother = new Human("Aня", "Якин", Gender.Female, LocalDate.of(1965, 1, 15), null, "USSR", "Москва", "Учитель", null, null);
        Human father = new Human("Олег", "Якин", Gender.Male, LocalDate.of(1960, 3, 22), null, "USSR", "Владивосток", "Инженер", null, null);
        Human child = new Human("Mиша", "Якин", Gender.Male, LocalDate.of(1990, 5, 15), null, "Russia", "Казань", "Врач", mother, father);

        mother.setId(1L);
        father.setId(2L);
        child.setId(3L);

        mother.getChildren().add(child);
        father.getChildren().add(child);

        FileOperations fileHandler = new FileHandler();
        FamilyTree familyTree = new FamilyTree(fileHandler);

        familyTree.addElement(mother);
        familyTree.addElement(father);
        familyTree.addElement(child);

        familyTree.printAllElements();

        System.out.println("\nСортировка по имени:");
        familyTree.sortByName(Comparator.comparing(Human::getName));
        familyTree.printAllElements();

        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthDate(Comparator.comparing(Human::getBirthDate));
        familyTree.printAllElements();

        String filename = "data/family_tree.ser";

        familyTree.saveToFile(filename);

        FamilyTree<Human> loadedFamilyTree = new FamilyTree<>(fileHandler);
        //loadedFamilyTree.loadFromFile(filename);


       loadedFamilyTree.printAllElements();
    }
}
