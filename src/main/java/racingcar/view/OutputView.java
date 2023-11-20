package racingcar.view;

import java.util.List;

public class OutputView {
    public void displayWinner(List<String> winners) {
        String output = String.join(",", winners);
        System.out.println(output);
    }
}
