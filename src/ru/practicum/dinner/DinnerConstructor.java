package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DinnerConstructor {
    private Map<String, List<String>> menu;

    public DinnerConstructor(Map<String, List<String>> menu) {
        this.menu = menu;
    }

    public List<List<String>> construct(List<String> dishTypes, int numberOfCombos) {
        List<List<String>> result = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < numberOfCombos; i++) {
            List<String> combo = new ArrayList<>();
            for(String dishType : dishTypes) {
                List<String> dishes = menu.get(dishType);
                int randomIndex = random.nextInt(dishes.size());
                String dish = dishes.get(randomIndex);
                combo.add(dish);
            }
            result.add(combo);
        }
        return result;
    }
}