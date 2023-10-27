package racingcar.constants;

public enum ErrorMessage {
    ERROR_NAME_MUST_BE_5_CHARACTERS_LESS("자동차 이름은 5자 이하만 가능합니다."),
    ERROR_NAME_MUST_BE_NUMBER("숫자를 입력해주세요.");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
