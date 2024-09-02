package com.familytree.main;

import com.familytree.controller.ApplicationController;
import com.familytree.file.FileHandler;
import com.familytree.model.FamilyTree;
import com.familytree.model.Human;
import com.familytree.presenter.FamilyTreePresenter;
import com.familytree.service.FamilyTreeService;
import com.familytree.view.ConsoleFamilyTreeView;
import com.familytree.view.FamilyTreeView;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        FileHandler<FamilyTree<Human>> fileHandler = new FileHandler<>();
        FamilyTreeService service = new FamilyTreeService(familyTree, fileHandler);
        FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);

        ApplicationController controller = new ApplicationController(presenter);
        controller.start();
    }
}
