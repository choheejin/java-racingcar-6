package racingcar.view;

import racingcar.domain.Car;
import racingcar.view.consts.OutputMessage;

import java.util.List;

public class OutputView {
    public void displayRacingTittle() {
        System.out.println(OutputMessage.RACING.getMessage());
    }

    public void displayRacing(List<Car> cars) {
        cars.forEach(car -> {
            System.out.printf(OutputMessage.CAR_NAME.getMessage(), car.getName());
            System.out.println(OutputMessage.POSITION.getMessage().repeat(car.getPosition()));
        });
        System.out.println();
    }

    public void displayWinner(List<String> winners) {
        String output = String.join(",", winners);
        System.out.printf(OutputMessage.WINNER.getMessage(), output);
    }
}
