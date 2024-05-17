package ru.practicum.dinner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>>  dishesMap = new HashMap<>();

    public void addNewDish(String dishType, String dishName) {
        if (dishesMap.containsKey(dishType)) {
            ArrayList<String> currentArray = dishesMap.get(dishType);
            currentArray.add(dishName);
        } else {
            ArrayList<String> currentArray = new ArrayList<>();
            currentArray.add(dishName);
            dishesMap.put(dishType, currentArray);
        }
    }

    public void generateCombo(int requiredCountOfCombos, ArrayList<String> arrayOfRequiredTypes) {
        HashMap<String, ArrayList<String>> generatedComboMap = new HashMap<>();

        for (int i = 0; i < requiredCountOfCombos; i++) {
            ArrayList<String> generatedComboList = new ArrayList<>();
            for (String currentRequiredType : arrayOfRequiredTypes) {
                ArrayList<String> currentList = dishesMap.get(currentRequiredType);
                int currentListSize = currentList.size();
                generatedComboList.add(currentList.get(random.nextInt(currentListSize)));
            }
            String comboName = "Комбо " + Integer.toString(i);
            generatedComboMap.put(comboName, generatedComboList);
        }

        for (String currentComboName : generatedComboMap.keySet()) {
            ArrayList<String> currentComboList =  generatedComboMap.get(currentComboName);
            System.out.println(currentComboName);
            System.out.println(currentComboList);
        }
    }

    public boolean checkType (String type) {
        if (dishesMap.containsKey(type)) {
            return true;
        }
        return false;
    }
}
