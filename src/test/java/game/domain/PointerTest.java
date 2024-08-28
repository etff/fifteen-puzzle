package game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointerTest {
    @Test
    void change_row() {
        Pointer pointer = new Pointer(1, 1);

        Pointer actual = pointer.changeRow(2);

        assertThat(actual.row()).isEqualTo(2);
    }

    @Test
    void change_col() {
        Pointer pointer = new Pointer(1, 1);

        Pointer actual = pointer.changeCol(2);

        assertThat(actual.col()).isEqualTo(2);
    }

    @Test
    void move() {
        Pointer pointer = new Pointer(1, 1);

        Pointer actual = pointer.move(2, 2);

        assertAll(
                () -> assertThat(actual.row()).isEqualTo(2),
                () -> assertThat(actual.col()).isEqualTo(2)
        );
    }
}
