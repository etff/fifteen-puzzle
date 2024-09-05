package game.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int BLANK = 0;

    private final int width;
    private final int height;
    private final List<Integer> values = new ArrayList<>();

    public Board(int width, int height, Numbers numbers) {
        this.width = width;
        this.height = height;

        for (int i = 0; i < width * height; i += 1) {
            this.values.add(numbers.getNumber(i));
        }
    }

    public void swap(Pointer pointer1, Pointer pointer2) {
        int value1 = get(pointer1);
        int value2 = get(pointer2);

        set(pointer1, value2);
        set(pointer2, value1);
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public boolean inRectangle(Pointer pointer) {
        int row = pointer.row();
        int col = pointer.col();
        return row >= 0 && row < height() && col >= 0 && col < width();
    }

    public boolean isSolved(OrderChecker orderChecker) {
        return orderChecker.isAscend(values);
    }

    public boolean isBlank(int row, int col) {
        return get(row, col) == BLANK;
    }

    public int get(Pointer pointer) {
        return get(pointer.row(), pointer.col());
    }

    public int get(int row, int col) {
        return values.get(row * width + col);
    }

    private void set(Pointer pointer, int value) {
        int row = pointer.row();
        int col = pointer.col();
        values.set(row * width + col, value);
    }

    public Pointer findBlankPointer() {
        int index = values.indexOf(BLANK);
        if (index < 0) {
            return Pointer.notFound();
        }
        int row = index / width;
        int col = index % width;
        return new Pointer(row, col);
    }
}
