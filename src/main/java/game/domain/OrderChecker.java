package game.domain;

public class OrderChecker {
    private static final int MAX_SIZE = 4;
    public static boolean isAscend(int[][] positions) {
        int count = 1;
        for (int row = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++) {
                if (positions[row][col] != count && !isLastPosition(row, col)) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    private static boolean isLastPosition(int row, int col) {
        return row == MAX_SIZE - 1 && col == MAX_SIZE - 1;
    }
}
