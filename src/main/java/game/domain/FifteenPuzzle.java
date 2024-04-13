package game.domain;

import game.view.InputView;
import game.view.OutputView;

public class FifteenPuzzle {

    private static final String QUIT_COMMAND = "q";

    public static void main(String[] args) {
        Numbers numbers = new Numbers(new RandomOrder());
        Board board = new Board(numbers);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.printWelcome();
        outputView.printBoard(board);
        if (board.isSolved()) {
            outputView.printResult(board);
            return;
        }

        while (true) {
            String input = inputView.askDirection();
            if (input.equals(QUIT_COMMAND)) {
                outputView.printGameEnd();
                break;
            }
            board.move(input);
            outputView.printBoard(board);
            if (board.isSolved()) {
                outputView.printResult(board);
                break;
            }
        }
    }


}
