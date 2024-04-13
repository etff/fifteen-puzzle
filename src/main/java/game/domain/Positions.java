package game.domain;

public class Positions {
    private static final int MAX_SIZE = 4;
    private static final int POINTER = 0;
    private final int[][] positions = new int[MAX_SIZE][MAX_SIZE];

    public Positions(Numbers numbers) {
        initPositions(numbers);
    }

    private void initPositions(Numbers numbers) {
        for (int row = 0, index = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++, index++) {
                positions[row][col] = numbers.getBlock(index);
            }
        }
    }

    public int get(int row, int col) {
        return positions[row][col];
    }

    public void movePosition(int row, int col, int value) {
        positions[row][col] = value;
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < MAX_SIZE && col >= 0 && col < MAX_SIZE;
    }

    public int[][] getPositions() {
        return positions;
    }

    public void swapPositions(int row, int col, int newRow, int newCol) {
        movePosition(row, col, this.get(newRow, newCol));
        movePosition(newRow, newCol, POINTER);
    }

    public int getLength() {
        return positions.length;
    }
}
