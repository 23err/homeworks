package ru.geekbrains_middle.lesson3;

import java.util.*;

public class Main {
    private static final String TEXT = "Die   Tranen greiser Kinderschar\n" +
            "ich zieh sie auf ein weisses Haar\n" +
            "werf in die Luft die nasse Kette\n" +
            "und wunsch mir,,,,, dass ich eine Mutter hatte\n" +
            "\n" +
            "Keine Sonne die mir scheint\n" +
            "keine Brust hat Milch geweint\n" +
            "in meiner Kehle steckt ein Schlauch\n" +
            "Hab keinen Nabel auf dem Bauch";
    private static final String[] ARR = TEXT.split("[^\\w]+");




    public static void main(String[] args) {

        Set<String> uniqueWords = getUniqueWords();
        Map<String, Integer> countOfWord = getCountWord();
        Iterator<Map.Entry<String, Integer>> iterator = countOfWord.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> item = iterator.next();
            System.out.printf("%s : %d %n", item.getKey(), item.getValue());
        }

        PhoneBook phoneBook = new PhoneBook();
        ArrayList<String> phoneList = phoneBook.getPhones("Petrov");
        phoneList.forEach(System.out::println);
        ArrayList<String> emailsList = phoneBook.getEmails("Petrov");
        emailsList.forEach(System.out::println);
    }

    private static HashSet<String> getUniqueWords() {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(ARR));
        return hashSet;
    }

    private static HashMap<String, Integer> getCountWord() {
        HashMap<String, Integer> map = new HashMap<>();
        for (String item : ARR) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return map;
    }
}
