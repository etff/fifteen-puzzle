package game.domain;

import java.util.Arrays;

public class Board {
    private static final int POINTER = 0;
    private static final int MAX_SIZE = 4;
    private static final String INVALID_INPUT = "입력이 잘못되었습니다, 명령(h, j, k, l, q)";
    private final Positions positions;
    private final OrderChecker orderChecker;
    private int pointerRow = -1;
    private int pointerCol = -1;
    private int moves = 0;

    public Board(Numbers numbers) {
        positions = new Positions(numbers);
        orderChecker = new OrderChecker();
        initPointer();
    }

    private void initPointer() {
        for (int row = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++) {
                if (positions.get(row, col) == POINTER) {
                    this.pointerRow = row;
                    this.pointerCol = col;
                }
            }
        }
    }

    public void move(String input) {
        Directions directions = Directions.from(input);
        if (directions == null) {
            System.out.println(INVALID_INPUT);
            return;
        }

        int newRow = directions.moveRow(pointerRow);
        int newCol = directions.moveCol(pointerCol);

        if (positions.isInBounds(newRow, newCol)) {
            positions.swapPositions(pointerRow, pointerCol, newRow, newCol);
            pointerRow = newRow;
            pointerCol = newCol;
            moves++;
        }
    }

    public int[][] getPositions() {
        return Arrays.copyOf(positions.getPositions(), positions.getLength());
    }

    public int getMoves() {
        return moves;
    }

    public boolean isSolved() {
        return orderChecker.isAscend(positions.getPositions());
    }

}
