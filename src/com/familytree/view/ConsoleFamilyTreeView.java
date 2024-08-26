package com.familytree.view;

import com.familytree.model.Human;

import java.util.List;

public class ConsoleFamilyTreeView implements FamilyTreeView {

    @Override
    public void displayFamilyTree(List<Human> members) {
        for (Human member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
