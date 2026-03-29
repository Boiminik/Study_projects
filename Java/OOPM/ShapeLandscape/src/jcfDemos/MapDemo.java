package jcfDemos;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Apfel", "apple");
        dictionary.put("Maus", "mouse");
        dictionary.put("Haus", "house");
        dictionary.put("Seite", "page");
        dictionary.put("Seite", "site");
        dictionary.put("der", "the");
        dictionary.put("die", "the");
        dictionary.put("das", "the");

        System.out.println(dictionary);

        Set<String> keySet = dictionary.keySet();
        for (String key : keySet)
            System.out.println(dictionary.get(key));

        Set<Map.Entry<String, String>> entrySet = dictionary.entrySet();

        System.out.println(entrySet);

        Map<String, Set<String>> betterDictionary = new HashMap<>();
        betterDictionary.put("Apfel", new HashSet<String>());
        betterDictionary.get("Apfel").add("apple");
        Set mouseSet = new HashSet<String>();
        mouseSet.add("mouse");
        betterDictionary.put("Maus", mouseSet);

        betterDictionary.put("Seite", new HashSet<>());
        betterDictionary.get("Seite").add("page");
        betterDictionary.get("Seite").add("site");

        betterDictionary.put("der", new HashSet<>());
        betterDictionary.put("die", new HashSet<>());
        betterDictionary.put("das", new HashSet<>());
        betterDictionary.get("der").add("the");
        betterDictionary.get("die").add("the");
        betterDictionary.get("das").add("the");

        System.out.println(betterDictionary);

        addEntry(betterDictionary, "Panzer", "tank");
        addEntry(betterDictionary, "Tank", "tank");
        addEntry(betterDictionary, "sterben", "to die");

        System.out.println(betterDictionary);
        Set<String> ks = betterDictionary.keySet();              //Set<String>
        Set<Map.Entry<String, Set<String>>> es = betterDictionary.entrySet();        //Set<Map.Entry<String, Set.String>>

    }

    private static void addEntry(Map<String, Set<String>> betterDictionary, String key, String value) {
        if (!betterDictionary.containsKey(key))
            betterDictionary.put(key, new HashSet<>());
        betterDictionary.get(key).add(value);
    }
}
