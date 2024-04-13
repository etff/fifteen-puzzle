package game.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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
    void invalid_input(String input) {
        Directions actual = Directions.from(input);

        assertThat(actual).isNull();
    }
}
