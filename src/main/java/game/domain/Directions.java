package game.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Directions {
    LEFT("h", "a", 0, 1),
    RIGHT("l", "d", 0, -1),
    UP("k", "w", -1, 0),
    DOWN("j", "s", 1, 0);

    private static final String NOT_FOUND_DIRECTION = "해당하는 방향을 찾지 못했습니다.";
    private final String vimKey;
    private final String wasdKey;
    private final int row;
    private final int col;

    Directions(String vimKey, String wasdKey, int row, int col) {
        this.vimKey = vimKey;
        this.wasdKey = wasdKey;
        this.row = row;
        this.col = col;
    }

    public static Directions from(String input) {
        return Arrays.stream(Directions.values())
                .filter(it -> hasDirection(input, it))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_DIRECTION));
    }

    private static boolean hasDirection(String input, Directions directions) {
        return Objects.equals(directions.wasdKey, input) || Objects.equals(directions.vimKey, input);
    }

    public Pointer applyDirection(Pointer pointer) {
        return new Pointer(pointer.row() + this.row, pointer.col() + this.col);
    }
}
