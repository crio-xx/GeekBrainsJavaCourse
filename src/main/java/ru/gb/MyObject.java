package ru.gb;

class MyObject {
    private final String name;

    MyObject(String name) {
        this.name = name;
    }

    public String getKey() {
        return this.name;
    }

    public String toString(){
        return String.format("MyObject[name = %s]", name);
    }
}