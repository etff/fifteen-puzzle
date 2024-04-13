package game.domain;

public record Pointer(int row, int col) {
    private static final int POINTER = 0;
    private static final int MAX_SIZE = 4;
    private static final int NOT_FOUND = -1;

    public static Pointer from(Positions positions) {
        for (int row = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++) {
                if (positions.get(row, col) == POINTER) {
                    return new Pointer(row, col);
                }
            }
        }
        return new Pointer(NOT_FOUND, NOT_FOUND);
    }

    public Pointer changeRow(int row) {
        return new Pointer(row, this.col);
    }

    public Pointer changeCol(int col) {
        return new Pointer(this.row, col);
    }

    public Pointer move(int newRow, int newCol) {
        return new Pointer(newRow, newCol);
    }
}
