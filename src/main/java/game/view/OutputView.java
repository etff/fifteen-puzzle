package game.view;

import game.domain.Board;

public class OutputView {
    private static final int SIZE = 4;
    private static final String WELCOME_MESSAGE = "15 퍼즐입니다.";
    private static final String GAME_END = "게임이 종료되었습니다.";
    private static final String RESULT_WITH_END = "번만에 완성하셨습니다!\n Thank You for Playing!";
    private static final String SPACES = "    ";
    private static final String NUMBER = "%2d  ";
    private static final int POINTER = 0;

    public void printBoard(Board board) {
        int[][] positions = board.getPositions();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (positions[row][col] == POINTER) {
                    System.out.print(SPACES);
                } else {
                    System.out.printf(NUMBER, positions[row][col]);
                }
            }
            System.out.println();
        }
    }

    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printResult(Board board) {
        System.out.println(board.getMoves() + RESULT_WITH_END);
    }

    public void printGameEnd() {
        System.out.println(GAME_END);
    }
}
