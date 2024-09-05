package game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatCode;

class NumbersTest {
    @Test
    void generate_numbers() {
        Numbers numbers = new Numbers(15, new RandomOrder());

        assertThat(numbers.getValues()).hasSize(16);
    }

    @Test
    void get_number_with_exceed_max_range() {
        Numbers numbers = new Numbers(15, new RandomOrder());
        int givenIndex = 16;

        assertThatCode(() -> numbers.getNumber(givenIndex))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
