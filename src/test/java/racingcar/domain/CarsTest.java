package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @DisplayName("자동차 경주 우승자를 찾는다 - 단독우승자")
    @Test
    void cars_단독_우승자() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("java");
        car1.move(4);
        car2.move(3);
        Cars cars = new Cars(List.of(car1, car2));
        List<String> expectWinner = List.of("pobi");
        assertThat(cars.getWinner()).isEqualTo(expectWinner);
    }

    @DisplayName("자동차 경주 우승자를 찾는다 - 공동우승자")
    @Test
    void cars_공동_우승자() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("java");
        car1.move(4);
        car2.move(4);
        Cars cars = new Cars(List.of(car1, car2));
        List<String> expectWinner = List.of("pobi", "java");
        assertThat(cars.getWinner()).isEqualTo(expectWinner);
    }
}
