package game.domain;

public class OrderChecker {
    private static final int MAX_SIZE = 4;
    public static boolean isAscend(int[][] positions) {
        int count = 1;
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (positions[i][j] != count && !isLastPosition(i, j)) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    private static boolean isLastPosition(int i, int j) {
        return i == MAX_SIZE - 1 && j == MAX_SIZE - 1;
    }
}
