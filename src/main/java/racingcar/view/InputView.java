package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String FORMAT = ",";
    public List<String> readName() throws IllegalArgumentException {
        String input = Console.readLine().trim();
        validateFormat(input);
        return Arrays.stream(input.split(FORMAT, -1)).toList();
    }

    private void validateFormat(String input) throws IllegalArgumentException{
        List<String> inputs = Arrays.stream(input.split(FORMAT, -1)).toList();

        if(inputs.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException();
        }

        if(inputs.stream().anyMatch(i -> !i.equals(i.trim()))) {
            throw new IllegalArgumentException();
        }
    }
}
