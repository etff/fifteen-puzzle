package game.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderCheckerTest {

    @Test
    void check_numbers_ascend() {
        final List<Integer> givenNumbers = List.of(1, 2, 3);

        boolean actual = OrderChecker.isAscending(givenNumbers);

        assertThat(actual).isTrue();
    }

    @Test
    void check_numbers_not_ascend() {
        final List<Integer> givenNumbers = List.of(1, 3, 2);

        boolean actual = OrderChecker.isAscending(givenNumbers);

        assertThat(actual).isFalse();
    }
}