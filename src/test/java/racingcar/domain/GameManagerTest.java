package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("실행결과를 올바르게 출력한다")
    @Test
    void game_실행결과() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("실행 결과" + LINE_SEPARATOR ,"pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("최종 우승자를 올바르게 출력한다 - 단독 우승")
    @Test
    void game_단독우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : woni");
                },
                STOP, MOVING_FORWARD
        );
    }

    @DisplayName("최종 우승자를 올바르게 출력한다 - 공동 우승")
    @Test
    void game_공동우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        new GameManager().start();
    }
}
