package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int CONDITION = 4;
    private static final int MAX_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if(name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
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