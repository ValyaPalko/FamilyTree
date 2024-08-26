package com.familytree.presenter;

import com.familytree.model.FamilyTree;
import com.familytree.model.Human;
import com.familytree.view.FamilyTreeView;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree<Human> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Human> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void addHuman(Human human) {
        familyTree.addElement(human);
        view.showMessage(human.getName() + " добавлен(а) в семейное древо.");
    }

    public void sortByName() {
        familyTree.sortByName();
        view.showMessage("Семейное древо отсортировано по имени.");
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        view.showMessage("Семейное древо отсортировано по дате рождения.");
    }

    public void displayFamilyTree() {
        List<Human> members = familyTree.getMembers();
        view.displayFamilyTree(members);
    }
}
