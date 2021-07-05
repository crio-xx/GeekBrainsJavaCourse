package ru.gb.participants;

import ru.gb.interfaces.participants.Sportive;
import ru.gb.obstacles.Obstacle;
import ru.gb.obstacles.Treadmill;
import ru.gb.obstacles.Wall;

public class Robot implements Sportive {
    String nickname;
    int jumpLimit;
    int runLimit;

    public Robot(String nickname, int jumpLimit, int runLimit){
        this.nickname = nickname;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    public boolean doAction(Obstacle obstacle) {
        if(obstacle instanceof Treadmill) {
            return run((Treadmill) obstacle);
        }else if (obstacle instanceof  Wall) {
            return jump((Wall) obstacle);
        }
        return false;
    }

    public boolean jump(Wall obstacle) {
        var result = jumpLimit >= obstacle.getHeight();
        if(result) {
            System.out.printf("%s успешно перепрыгнул через стену (высотой %s)\n", nickname, obstacle.getHeight());
        }else {
            System.out.printf("%s не смог перепрыгнуть через стену (высотой %s)\n", nickname, obstacle.getHeight());
        }
        return result;
    }

    public boolean run(Treadmill obstacle) {
        var result = runLimit >= obstacle.getLength();
        if(result) {
            System.out.printf("%s успешно пробежал дорожку (длиной %s)\n", nickname, obstacle.getLength());
        }else {
            System.out.printf("%s не смог пробежать дорожку (длиной %s)\n", nickname, obstacle.getLength());
        }
        return result;
    }
}
