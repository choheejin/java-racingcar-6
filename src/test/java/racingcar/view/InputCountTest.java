package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputCountTest extends NsTest {
    private InputView inputView;

    @DisplayName("입력이 숫자가 아닐 경우, 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"다섯", "five"})
    void name_입력숫자아님_예외(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력이 0인 경우, 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void name_입력이_0_예외(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력이 없을 경우, 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {" ", "\n"})
    void name_입력없을때_예외(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        inputView = new InputView();
        inputView.readCount();
    }
}
