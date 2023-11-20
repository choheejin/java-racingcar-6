package racingcar.view;

import racingcar.domain.Cars;
import racingcar.view.consts.OutputMessage;

import java.util.List;

public class OutputView {
    public void displayRacing(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.printf(OutputMessage.CAR_NAME.getMessage(), car.getName());
            System.out.printf(OutputMessage.POSITION.getMessage().repeat(car.getPosition()));
        });
    }
    public void displayWinner(List<String> winners) {
        String output = String.join(",", winners);
        System.out.println(output);
    }
}
