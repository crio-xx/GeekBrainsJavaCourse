package ru.gb.obstacles;

public class Wall extends Obstacle {
    int height;

    public Wall(int height){
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
