package com.familytree.view;

import com.familytree.model.Human;
import java.util.List;

public interface FamilyTreeView {
    void displayFamilyTree(List<Human> members);
    void showMessage(String message);
}
