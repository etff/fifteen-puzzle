package game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class NumbersTest {

    @Test
    void generate_board() {
        Numbers numbers = new Numbers(new RandomOrder());

        assertThat(numbers.getValues()).hasSize(16);
    }
}