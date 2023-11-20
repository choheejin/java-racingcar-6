package racingcar.view.consts;

public enum OutputMessage {
    RACING("실행 결과"),
    WINNER("최종 우승자 : %s"),
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
