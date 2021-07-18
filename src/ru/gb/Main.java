package ru.gb;

import ru.gb.collections.PhoneBook;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        firstExercise();
        secondExercise();
    }

    static void secondExercise() {
        var phoneBook = new PhoneBook();
        phoneBook.add("Alex", "+79999999999");
        phoneBook.add("Bob", "+79999999998");
        phoneBook.add("Clare", "+79999999997");
        phoneBook.add("Clare", "+79999999996");
        phoneBook.add("Clare", "+79999999995");
        phoneBook.add("George", "+79999999994");

        var resultAlex = phoneBook.get("Alex");
        System.out.println(resultAlex);
        var resultClare = phoneBook.get("Clare");
        System.out.println(resultClare);
        phoneBook.getAndPrint("Clare");
    }

    static void firstExercise() {
        ArrayList<String> someElements = new ArrayList<>(Arrays.asList(
                "some1", "some4", "some2", "some3",
                "some4", "some3", "some1", "some2",
                "some2", "some1", "some3", "some4",
                "some3", "some2", "some4", "some1"));
        findUniqueAndCountOccurrences(someElements);
    }

    public static void findUniqueAndCountOccurrences(Collection<String> collection) {
        Set<String> unique = new HashSet<>(collection);
        for(var elem: unique) {
            System.out.println(elem + ": " + Collections.frequency(collection, elem));
        }
    }
}
