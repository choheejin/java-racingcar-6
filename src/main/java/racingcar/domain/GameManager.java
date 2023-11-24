package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    public GameManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        List<Car> cars = initCar();
        int count = inputView.readCount();
        Cars winner = move(cars, count);
        outputView.displayWinner(winner.getWinner());
    }

    private List<Car> initCar() {
        List<String> names = inputView.readName();
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private Cars move(List<Car> cars, int number) {
        outputView.displayRacingTittle();
        for (int i = 0; i < number; i++) {
            for (Car car : cars) {
                int random = Randoms.pickNumberInRange(0, 9);
                car.move(random);
            }
            outputView.displayRacing(cars);
        }
        return new Cars(cars);
    }
}
