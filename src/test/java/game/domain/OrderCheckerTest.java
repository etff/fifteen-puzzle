package game.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderCheckerTest {
    @Test
    void check_numbers_ascend() {
        OrderChecker orderChecker = new OrderChecker();

        assertThat(
                orderChecker.isAscend(
                        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0)
                )
        ).isTrue();

        // TODO: 별도의 테스트 메서드로 분리할 것!
        assertThat(
                orderChecker.isAscend(
                        List.of(2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0)
                )
        ).isFalse();
    }
}
