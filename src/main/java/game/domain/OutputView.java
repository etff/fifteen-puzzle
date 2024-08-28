package game.domain;

public interface OutputView {
    void printBoard(Board board);
    void printWelcome();
    void printResult(Game game);
    void printGameEnd();
}
