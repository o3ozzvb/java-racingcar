package racingCar;


import java.util.Random;

public class Car {
    public static final int MOVE_NUM = 4;
    public static final int RANDOM_BOUND = 10;
    public static final String ERR_MSG_NAME_LENGTH = "이름은 5글자를 초과할 수 없습니다.";
    private int pos;
    private String name;

    public Car() {
        this.pos = 0;
    }

    public Car(String name) {
        this.pos = 0;
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    private void move(int num) {
        if (num >= MOVE_NUM) {
            this.pos++;
        }
    }

    public void play(Random random) {
        move(random.nextInt(RANDOM_BOUND));
    }

    public Car createCar(String name) {
        if (name.length() > 5) {
            throw new RuntimeException(ERR_MSG_NAME_LENGTH);
        }
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }
}
