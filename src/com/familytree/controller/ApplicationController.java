package com.familytree.controller;

import com.familytree.model.Gender;
import com.familytree.model.Human;
import com.familytree.presenter.FamilyTreePresenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ApplicationController {
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public ApplicationController(FamilyTreePresenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    presenter.displayFamilyTree();
                    break;
                case 2:
                    addHuman();
                    break;
                case 3:
                    createRelationship();
                    break;
                case 4:
                    presenter.sortByName();
                    break;
                case 5:
                    presenter.sortByBirthDate();
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    loadFromFile();
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

    private void displayMenu() {
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
    }

    private void addHuman() {
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
    }

    private void createRelationship() {
        System.out.print("Введите ID родителя: ");
        long parentId = scanner.nextLong();
        System.out.print("Введите ID ребенка: ");
        long childId = scanner.nextLong();
        presenter.createRelationship(presenter.findById(parentId), presenter.findById(childId));
    }

    private void saveToFile() {
        System.out.print("Введите имя файла для сохранения: ");
        String fileName = scanner.nextLine();
        if (presenter.saveToFile(fileName)) {
            System.out.println("Данные успешно сохранены.");
        } else {
            System.out.println("Ошибка при сохранении файла.");
        }
    }

    private void loadFromFile() {
        System.out.print("Введите имя файла для загрузки: ");
        String fileName = scanner.nextLine();
        if (presenter.loadFromFile(fileName)) {
            System.out.println("Данные успешно загружены.");
        } else {
            System.out.println("Ошибка при загрузке файла.");
        }
    }
}
