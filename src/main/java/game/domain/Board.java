package game.domain;

import java.util.Arrays;

public class Board {
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
        Pointer swapPointer = directions.applyDirection(pointer);
        if (swapPointer.isValidPosition()) {
            positions.swapPositions(pointer, swapPointer);
            pointer = swapPointer;
            moves = moves.increase();
        }
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
