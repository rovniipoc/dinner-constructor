package ru.practicum.dinner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>>  dishesMap = new HashMap<>();

    public void addNewDish(String inputDishType, String inputDishName) {
        if (dishesMap.containsKey(inputDishType)) {
            ArrayList<String> currentArray = dishesMap.get(inputDishType);
            currentArray.add(inputDishName);
        } else {
            ArrayList<String> currentArray = new ArrayList<>();
            currentArray.add(inputDishName);
            dishesMap.put(inputDishType, currentArray);
        }
    }

    public void generateCombo(int requiredCountOfCombos, ArrayList<String> arrayOfRequiredTypes) {
        for (int i = 0; i < requiredCountOfCombos; i++) {
            ArrayList<String> generatedComboList = new ArrayList<>();
            for (String currentRequiredType : arrayOfRequiredTypes) {
                ArrayList<String> currentList = dishesMap.get(currentRequiredType);
                int currentListSize = currentList.size();
                generatedComboList.add(currentList.get(random.nextInt(currentListSize)));
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(generatedComboList);
        }
    }

    public boolean checkType (String type) {
        if (dishesMap.containsKey(type)) {
            return true;
        }
        return false;
    }
}
