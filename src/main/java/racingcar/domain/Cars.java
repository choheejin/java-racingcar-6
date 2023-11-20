package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private Car findMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow();
    }

    private List<Car> findWinner(Car maxPosition) {
        return cars.stream()
                .filter(maxPosition::isSamePosition)
                .toList();
    }

    public List<String> getWinner(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
