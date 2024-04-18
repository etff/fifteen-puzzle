package game.domain;

public class OrderChecker {
    private static final int MAX_SIZE = 4;

    public boolean isAscend(int[][] positions) {
        int count = 1;
        for (int row = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++) {
                if (isMatchWithCount(positions[row][col], count) && !isLastPosition(row, col)) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    private boolean isLastPosition(int row, int col) {
        return row == MAX_SIZE - 1 && col == MAX_SIZE - 1;
    }

    private boolean isMatchWithCount(int value, int count) {
        return value != count;
    }
}
