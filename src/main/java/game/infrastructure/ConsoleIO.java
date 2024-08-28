package game.infrastructure;

import game.domain.Board;
import game.domain.Game;
import game.domain.InputView;
import game.domain.OutputView;

import java.util.Scanner;

public class ConsoleIO implements InputView, OutputView {
    private static final String INPUT_COMMAND = "명령(h, j, k, l, q)";

    private static final String WELCOME_MESSAGE = "15 퍼즐입니다.";
    private static final String GAME_END = "게임이 종료되었습니다.";
    private static final String RESULT_WITH_END = "번만에 완성하셨습니다!\n Thank You for Playing!";
    private static final String SPACES = "    ";
    private static final String NUMBER = "%2d  ";

    private final Scanner scanner;

    public ConsoleIO() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String askCommand() {
        System.out.println(INPUT_COMMAND);
        return scanner.nextLine();
    }

    @Override
    public void printBoard(Board board) {
        for (int row = 0; row < board.height(); row++) {
            for (int col = 0; col < board.width(); col++) {
                if (board.isBlank(row, col)) {
                    System.out.print(SPACES);
                    continue;
                }
                System.out.printf(NUMBER, board.get(row, col));
            }
            System.out.println();
        }
    }

    @Override
    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    @Override
    public void printResult(Game game) {
        System.out.println(game.getMoveCount() + RESULT_WITH_END);
    }

    @Override
    public void printGameEnd() {
        System.out.println(GAME_END);
    }
}
