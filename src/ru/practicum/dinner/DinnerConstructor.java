package ru.practicum.dinner;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

class DinnerConstructor {

    // Хеш-таблица для хранения блюд
    private HashMap<String, ArrayList<String>> dishes;

    // Конструктор, инициализируем хеш-таблицу
    public DinnerConstructor() {
        dishes = new HashMap<>();
    }

    // Метод для добавления нового блюда
    public void addDish(String type, String name) {
        dishes.putIfAbsent(type, new ArrayList<>());
        dishes.get(type).add(name);
        System.out.println("Блюдо '" + name + "' добавлено в тип '" + type + "'.");
    }

    // Метод для проверки существования типа блюда
    public boolean checkType(String type) {
        return dishes.containsKey(type);
    }

    // Метод для генерации комбинаций
    public void generateCombinations(int count, ArrayList<String> types) {
        Random random = new Random();

        // Для хранения всех возможных комбинаций
        for (int i = 0; i < count; i++) {
            ArrayList<String> combination = new ArrayList<>();

            for (String type : types) {
                if (checkType(type)) {
                    // Генерация случайного блюда для каждого типа
                    ArrayList<String> dishList = dishes.get(type);
                    String randomDish = dishList.get(random.nextInt(dishList.size()));
                    combination.add(randomDish);
                } else {
                    System.out.println("Тип блюда '" + type + "' не найден.");
                    return;
                }
            }

            // Выводим комбинацию
            System.out.println("Комбинация " + (i + 1) + ": " + String.join(", ", combination));
        }
    }
}
