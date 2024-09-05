package game.domain;

public class Game {
    private final OrderChecker orderChecker;

    private final Board board;
    // TODO: `moveCounter`란 표현이 동사처럼 읽힐 수 있음. 적절한 명사형이 필요함.
    private final Counter moveCounter;

    private Pointer blankPointer;

    private boolean quit = false;

    public Game(int width, int height, Numbers numbers, OrderChecker orderChecker) {
        this.orderChecker = orderChecker;

        this.board = new Board(width, height, numbers);

        this.moveCounter = new Counter();

        this.blankPointer = board.findBlankPointer();
    }

    public void moveLeft() {
        moveBlank(0, 1);
    }

    public void moveRight() {
        moveBlank(0, -1);
    }

    public void moveUp() {
        moveBlank(1, 0);
    }

    public void moveDown() {
        moveBlank(-1, 0);
    }

    private void moveBlank(int deltaRow, int deltaCol) {
        Pointer newBlankPointer = blankPointer.plus(deltaRow, deltaCol);

        if (!board.inRectangle(newBlankPointer)) {
            // TODO: 뭔가를 해줄까?
            return;
        }

        board.swap(blankPointer, newBlankPointer);

        blankPointer = newBlankPointer;

        moveCounter.increase();
    }

    public void quit() {
        this.quit = true;
    }

    public boolean isPlaying() {
        return !quit && !board.isSolved(orderChecker);
    }

    public boolean isQuit() {
        return quit;
    }

    public Board board() {
        return board;
    }

    public int getMoveCount() {
        return moveCounter.value();
    }
}
