package ru.gb;

import ru.gb.interfaces.participants.Sportive;
import ru.gb.obstacles.Obstacle;
import ru.gb.obstacles.Treadmill;
import ru.gb.obstacles.Wall;
import ru.gb.participants.Cat;
import ru.gb.participants.Human;
import ru.gb.participants.Robot;

public class Main {
    public static void main(String[] args) {
        Sportive[] participants = {
                new Cat("Васька", 5, 120),
                new Human("Юрий", 45, 302),
                new Robot("T9000", 9999, 8888),
                new Human("Игорь", 32, 250),
                new Cat("Мурка", 35, 270),
                new Robot("SomeBroken", 0, 0)
        };
        Obstacle[] obstacles = {
                new Wall(30), new Treadmill(300),
                new Wall(40), new Treadmill(101)
        };

        for (var participant : participants) {
            for (var obstacle : obstacles) {
                if (!participant.doAction(obstacle)) {
                    System.out.println("Участник выбыл из испытаний");
                    break;
                }
            }
            System.out.println("Участник прошел все испытания");
        }
    }
}