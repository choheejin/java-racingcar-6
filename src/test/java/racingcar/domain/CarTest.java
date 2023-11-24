package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @DisplayName("자동차 이름이 5자 초과일시, 예외처리")
    @Test
    void car_자동차이름_예외() {
        assertThatThrownBy(() -> new Car("여섯글자임다")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진조건을 만족한 자동차는 전진한다")
    @Test
    void car_전진조건_충족() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car).extracting("position").isEqualTo(1);
    }

    @DisplayName("자동차끼리 전진거리가 동일하다")
    @Test
    void car_전진거리_동일() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("java");
        car1.move(4);
        car2.move(4);
        assertThat(car1.isSamePosition(car2)).isTrue();
    }

    @DisplayName("자동차끼리 전진거리의 차이를 비교한다")
    @Test
    void car_전진거리_비교() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("java");
        car1.move(4);
        car2.move(3);
        assertThat(car1.compareTo(car2)).isEqualTo(1);
    }
}
