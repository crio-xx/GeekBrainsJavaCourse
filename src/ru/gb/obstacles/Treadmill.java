package ru.gb.obstacles;

public class Treadmill extends Obstacle {
    int length;

    public Treadmill(int length){
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
