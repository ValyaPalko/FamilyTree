
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

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


        familyTree.addHuman(mother);
        familyTree.addHuman(father);
        familyTree.addHuman(child);

        familyTree.printAllHumans();

        // Сохранение данных в файл
        familyTree.saveToFile("family_tree.ser");

        FamilyTree loadedFamilyTree = new FamilyTree(fileHandler);
        loadedFamilyTree.loadFromFile("family_tree.ser");


        loadedFamilyTree.printAllHumans();
    }
}

