package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String FORMAT = ",";
    private static final String R_NUMBER = "^[\\d]*$";

    public List<String> readName() throws IllegalArgumentException {
        String input = Console.readLine().trim();
        validateNone(input);
        validateFormat(input);
        return Arrays.stream(input.split(FORMAT, -1)).toList();
    }

    public int readCount() throws IllegalArgumentException {
        String input = Console.readLine().trim();
        validateNone(input);
        validateCount(input);
        return Integer.parseInt(input);
    }

    private void validateNone(String input) throws IllegalArgumentException {
        if(input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCount(String input) throws IllegalArgumentException {
        if(!input.matches(R_NUMBER)) {
            throw new IllegalArgumentException();
        }

        if(Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
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
