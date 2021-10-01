package ru.gb;

import ru.gb.warehouse.Apple;
import ru.gb.warehouse.Box;
import ru.gb.warehouse.Fruit;
import ru.gb.warehouse.Orange;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Apple fruit1 = new Apple();
        Orange fruit2 = new Orange();
        Orange fruit3 = new Orange();
        Apple fruit4 = new Apple();

        Fruit[] pack = {fruit1, fruit2, fruit3};
        // task 1
        System.out.println(Arrays.toString(pack));
        ArrayUtils.swap(pack,0, 1);
        System.out.println(Arrays.toString(pack));

        // task 2
        var newPack = ArrayUtils.convertArrayToArrayList(pack);
        newPack.add(fruit4);

        // task 3
        var appleBox = new Box<Apple>();
        appleBox.put(fruit1);
        appleBox.put(fruit4);

        var orangeBox = new Box<Orange>();
        orangeBox.put(fruit2);
        orangeBox.put(fruit3);

        System.out.println(appleBox.compare(orangeBox));

        var newAppleBox = new Box<Apple>();
        appleBox.pourOut(newAppleBox);
        System.out.println("Weight old apple box: " + appleBox.getWeight());
        newAppleBox.put(new Apple());
        newAppleBox.put(new Apple());
        System.out.println(newAppleBox.compare(orangeBox));
        System.out.println("Weight new apple box: " + newAppleBox.getWeight());
        System.out.println("Weight orange box: " + orangeBox.getWeight());

    }
}
