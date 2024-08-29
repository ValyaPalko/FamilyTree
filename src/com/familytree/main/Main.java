package com.familytree.main;

import com.familytree.model.Gender;
import com.familytree.model.Human;
import com.familytree.model.FamilyTree;
import com.familytree.file.FileHandler;
import com.familytree.presenter.FamilyTreePresenter;
import com.familytree.service.FamilyTreeService;
import com.familytree.view.ConsoleFamilyTreeView;
import com.familytree.view.FamilyTreeView;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем семейное древо, файловый обработчик и сервис
        FamilyTree<Human> familyTree = new FamilyTree<>();
        FileHandler<FamilyTree<Human>> fileHandler = new FileHandler<>();
        FamilyTreeService service = new FamilyTreeService(familyTree, fileHandler);

        // Создаем вид (консоль) и презентер
        FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);

        // Пример добавления данных
        Human mother = new Human("Anna", "Smith", Gender.Female, LocalDate.of(1965, 1, 15), null, "USSR", "Москва", "Teacher", null, null);
        Human father = new Human("Oleg", "Yakin", Gender.Male, LocalDate.of(1960, 3, 22), null, "USSR", "Владивосток", "Engineer", null, null);
        Human child = new Human("Misha", "Yakin", Gender.Male, LocalDate.of(1990, 5, 15), null, "Russia", "Казань", "Doctor", mother, father);

        mother.setId(1L);
        father.setId(2L);
        child.setId(3L);

        presenter.addHuman(mother);
        presenter.addHuman(father);
        presenter.addHuman(child);
        presenter.createRelationship(mother, child);
        presenter.createRelationship(father, child);

        // Интерактивное меню
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Показать семейное древо");
            System.out.println("2. Добавить человека");
            System.out.println("3. Установить родственную связь");
            System.out.println("4. Сортировать по имени");
            System.out.println("5. Сортировать по дате рождения");
            System.out.println("6. Сохранить в файл");
            System.out.println("7. Загрузить из файла");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    presenter.displayFamilyTree();
                    break;
                case 2:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите фамилию: ");
                    String surname = scanner.nextLine();
                    System.out.print("Введите пол (MALE/FEMALE): ");
                    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Введите дату рождения (YYYY-MM-DD): ");
                    LocalDate birthDate = LocalDate.parse(scanner.nextLine());
                    Human newHuman = new Human(name, surname, gender, birthDate, null, "", "", "", null, null);
                    presenter.addHuman(newHuman);
                    break;
                case 3:
                    System.out.print("Введите ID родителя: ");
                    long parentId = scanner.nextLong();
                    System.out.print("Введите ID ребенка: ");
                    long childId = scanner.nextLong();
                    Human parent = familyTree.findById(parentId);
                    Human childToLink = familyTree.findById(childId);
                    presenter.createRelationship(parent, childToLink);
                    break;
                case 4:
                    presenter.sortByName();
                    break;
                case 5:
                    presenter.sortByBirthDate();
                    break;
                case 6:
                    System.out.print("Введите имя файла для сохранения: ");
                    String saveFileName = scanner.nextLine();
                    presenter.saveToFile(saveFileName);
                    break;
                case 7:
                    System.out.print("Введите имя файла для загрузки: ");
                    String loadFileName = scanner.nextLine();
                    presenter.loadFromFile(loadFileName);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }

        scanner.close();
    }
}
