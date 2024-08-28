package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    @DisplayName("보드가 현재 정답상태인지 체크하여 true 혹은 false를 리턴한다")
    @Test
    void is_solve() {
        Numbers numbers = new Numbers(15, new FifteenPuzzleOrder());
        Board board = new Board(4, 4, numbers);

        OrderChecker orderChecker = new OrderChecker();

        assertThat(board.isSolved(orderChecker)).isTrue();
    }
}
