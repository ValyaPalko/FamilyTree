package com.familytree.presenter;

import com.familytree.model.Human;
import com.familytree.service.FamilyTreeService;
import com.familytree.view.FamilyTreeView;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    public void addHuman(Human human) {
        service.addHuman(human);
        view.showMessage(human.getName() + " добавлен(а) в семейное древо.");
    }

    public void createRelationship(Human parent, Human child) {
        service.createRelationship(parent, child);
        view.showMessage("Родственная связь установлена между " + parent.getName() + " и " + child.getName());
    }

    public void sortByName() {
        service.sortByName();
        view.showMessage("Семейное древо отсортировано по имени.");
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.showMessage("Семейное древо отсортировано по дате рождения.");
    }

    public void saveToFile(String fileName) {
        service.saveToFile(fileName);
    }

    public void loadFromFile(String fileName) {
        service.loadFromFile(fileName);
    }

    public void displayFamilyTree() {
        view.displayFamilyTree(service.getFamilyTree().getMembers());
    }
}
