package ru.gb.collections;

import java.util.*;

public class PhoneBook {
    private final Map<String, ArrayList<String>> book = new HashMap<>();

    public void add(String name, String phone) {
        if(book.containsKey(name)) {
            book.get(name).add(phone);
        } else {
            book.put(name, new ArrayList<>(Collections.singletonList(phone)));
        }
    }

    public ArrayList<String> get(String name) {
        return book.get(name);
    }

    public void getAndPrint(String name) {
        for(var phone: book.get(name)) {
            System.out.println(phone);
        }
    }

}
