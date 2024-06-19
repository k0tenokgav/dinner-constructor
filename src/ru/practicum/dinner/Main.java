package ru.practicum.dinner;

import java.util.*;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        Map<String, List<String>> menu = new HashMap<>();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Введите тип блюда:");
                    String dishType = scanner.nextLine();
                    addNewDish(menu, dishType);
                    break;
                case "2":
                    generateDishCombo(menu);
                    break;
                case "3":
                    System.out.println("До свидания!");
                    return;
            }
        }

    }

    public static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    public static void addNewDish(Map<String, List<String>> menu, String dishType) {
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        List<String> listDishes = menu.get(dishType);
        if (listDishes == null) {
            listDishes = new ArrayList<>();
            menu.put(dishType, listDishes);
        }
        listDishes.add(dishName);
    }

    public static void generateDishCombo(Map<String, List<String>> menu) {
        System.out.println("Начинаем конструировать обед...");
        dc = new DinnerConstructor(menu);

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        List<String> typesFor = new ArrayList<>();


        //реализуйте ввод типов блюд
        String nextItem;
        do {
            nextItem = scanner.nextLine();
            if (!nextItem.isEmpty()) {
                if (menu.containsKey(nextItem)) {
                    typesFor.add(nextItem);
                }else{
                    System.out.println("Такого типа не существует, введите другой.");
                }
            }
        } while (!nextItem.isEmpty());


        // сгенерируйте комбинации блюд и выведите на экран

        List<List<String>> combos = dc.construct(typesFor, numberOfCombos);
        System.out.println(combos);

    }
}