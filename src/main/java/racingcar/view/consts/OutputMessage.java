package racingcar.view.consts;

public enum OutputMessage {
    CAR_NAME("%s : "),
    POSITION("-");
    private final String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
