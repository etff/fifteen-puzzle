package game.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class DirectionsTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "h"})
    void create_left(String input) {
        Directions actual = Directions.from(input);

        assertThat(actual).isEqualTo(Directions.LEFT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"d", "l"})
    void create_right(String input) {
        Directions actual = Directions.from(input);

        assertThat(actual).isEqualTo(Directions.RIGHT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"w", "k"})
    void create_up(String input) {
        Directions actual = Directions.from(input);

        assertThat(actual).isEqualTo(Directions.UP);
    }

    @ParameterizedTest
    @ValueSource(strings = {"s", "j"})
    void create_down(String input) {
        Directions actual = Directions.from(input);

        assertThat(actual).isEqualTo(Directions.DOWN);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void create_with_empty_input(String input) {
        assertThatCode(() -> Directions.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_with_not_valid_input() {
        String input = "b";

        assertThatCode(() -> Directions.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
