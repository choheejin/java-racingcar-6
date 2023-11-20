package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int CONDITION = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= CONDITION) {
            this.position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }
}