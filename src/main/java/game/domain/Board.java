package game.domain;

import java.util.Arrays;

public class Board {
    private static final String INVALID_INPUT = "입력이 잘못되었습니다, 명령(h, j, k, l, q)";
    private final Positions positions;
    private final OrderChecker orderChecker;
    private Pointer pointer;
    private int moves = 0;

    public Board(Numbers numbers) {
        positions = new Positions(numbers);
        orderChecker = new OrderChecker();
        pointer = Pointer.from(positions);
    }

    public void move(String input) {
        Directions directions = Directions.from(input);
        if (directions == null) {
            System.out.println(INVALID_INPUT);
            return;
        }

        int newRow = directions.moveRow(pointer.row());
        int newCol = directions.moveCol(pointer.col());

        if (positions.isInBounds(newRow, newCol)) {
            positions.swapPositions(pointer.row(), pointer.col(), newRow, newCol);
            pointer = pointer.move(newRow, newCol);
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
