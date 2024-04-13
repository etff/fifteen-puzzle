package game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderCheckerTest {

    @Test
    void check_numbers_ascend() {
        final int[][] positions = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

        boolean actual = OrderChecker.isAscend(positions);

        assertThat(actual).isTrue();
    }

}