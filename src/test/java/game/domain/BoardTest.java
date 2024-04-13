package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {


    @DisplayName("보드가 현재 정답상태인지 체크하여 true 혹은 false를 리턴한다")
    @Test
    void is_solve() {
        Board board = new Board(new Numbers(new FifteenPuzzleOrder()));

        boolean actual = board.isSolved();

        assertThat(actual).isTrue();
    }

    @DisplayName("이동 메서드를 호출시 이동 횟수를 리턴한다")
    @Test
    void move() {
        Board board = new Board(new Numbers(new FifteenPuzzleOrder()));
        String leftCommand = "k";

        board.move(leftCommand);

        assertThat(board.getMoves()).isEqualTo(1);
    }
}

