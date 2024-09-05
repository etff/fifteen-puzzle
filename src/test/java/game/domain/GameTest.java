package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @DisplayName("이동 메서드를 호출시 이동 횟수를 리턴한다")
    @Test
    void move() {
        int width = 4;
        int height = 4;
        Numbers numbers = new Numbers(width * height - 1, new RandomOrder());
        OrderChecker orderChecker = new OrderChecker();

        Game game = new Game(width, height, numbers, orderChecker);

        game.moveLeft();

        assertThat(game.getMoveCount()).isEqualTo(1);

        game.moveRight();

        assertThat(game.getMoveCount()).isEqualTo(2);
    }
}
