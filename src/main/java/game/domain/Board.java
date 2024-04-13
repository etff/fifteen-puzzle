package game.domain;

public class Board {
    private static final int MAX_SIZE = 4;
    private static final int POINTER = 0;
    private static final String INVALID_INPUT = "입력이 잘못되었습니다, 명령(h, j, k, l, q)";
    private int[][] positions = new int[MAX_SIZE][MAX_SIZE];
    private int row = -1;
    private int col = -1;
    private int moves = 0;

    public Board(Numbers numbers) {
        initPositions(numbers);
    }

    private void initPositions(Numbers numbers) {
        for (int row = 0, index = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++, index++) {
                positions[row][col] = numbers.getBlock(index);
                if (isPointer(row, col)) {
                    this.row = row;
                    this.col = col;
                }
            }
        }
    }

    public void move(String input) {
        Directions directions = Directions.from(input);
        if (directions == null) {
            System.out.println(INVALID_INPUT);
        }

        int newRow = directions.moveRow(row);
        int newCol = directions.moveCol(col);

        if (underMaxPositions(newRow, newCol)) {
            positions[row][col] = positions[newRow][newCol];
            positions[newRow][newCol] = 0;
            row = newRow;
            col = newCol;
            this.moves++;
        }
    }

    private boolean underMaxPositions(int newRow, int newCol) {
        return newRow >= 0 && newRow < MAX_SIZE && newCol >= 0 && newCol < MAX_SIZE;
    }

    private boolean isPointer(int row, int col) {
        return positions[row][col] == POINTER;
    }

    public int[][] getPositions() {
        return positions;
    }

    public int getMoves() {
        return moves;
    }

    public boolean isSolved() {
        int count = 1;
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (positions[i][j] != count && !isLastPosition(i, j)) {
                    return false;
                }
                count = (count % (MAX_SIZE * MAX_SIZE - 1)) + 1;
            }
        }
        return true;
    }

    private boolean isLastPosition(int i, int j) {
        return i == MAX_SIZE - 1 && j == MAX_SIZE - 1;
    }
}
