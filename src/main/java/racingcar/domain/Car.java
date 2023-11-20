package racingcar.domain;

public class Car {
    private static final int CONDITION = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if(number >= 4) {
            this.position += 1;
        }
    }
}

