package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNameTest extends NsTest {
    private InputView inputView;

    @DisplayName("입력 형식이 잘못된 경우, 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"java, pobi", "java,,pobi", "java,pobi,"})
    void name_입력형식_예외(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력이 중복된 경우, 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"java,java", "java,pobi,pobi"})
    void name_입력중복_예외(String input) {
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
        inputView.readName();
    }
}
