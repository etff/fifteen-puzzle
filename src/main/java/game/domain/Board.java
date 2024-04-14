package game.domain;

import java.util.Arrays;

public class Board {
    private static final String INVALID_INPUT = "입력이 잘못되었습니다, 명령(h, j, k, l, q)";
    private final Positions positions;
    private final OrderChecker orderChecker;
    private Pointer pointer;
    private Moves moves;

    public Board(Numbers numbers) {
        this.positions = new Positions(numbers);
        this.orderChecker = new OrderChecker();
        this.pointer = Pointer.from(positions);
        this.moves = new Moves();
    }

    /**
     * 입력한 방향으로 포인터를 이동한다.
     * @param directions 입력방향
     */
    public void movePointer(Directions directions) {
        if (directions == null) {
            System.out.println(INVALID_INPUT);
            return;
        }
        int newRow = directions.moveRow(pointer);
        int newCol = directions.moveCol(pointer);

        positions.swapPositions(pointer, newRow, newCol);
        pointer = pointer.move(newRow, newCol);
        moves = moves.increase();
    }

    public int[][] getPositions() {
        return Arrays.copyOf(positions.getPositions(), positions.getLength());
    }

    public int getMoves() {
        return moves.getMoves();
    }

    public boolean isSolved() {
        return orderChecker.isAscend(positions.getPositions());
    }
}
