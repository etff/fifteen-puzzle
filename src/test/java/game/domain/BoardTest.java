package game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class BoardTest {

    @Test
    void generate_board() {
        Board board = new Board(new RandomShuffle());

        assertThat(board.getBlocks()).hasSize(15);
    }
}