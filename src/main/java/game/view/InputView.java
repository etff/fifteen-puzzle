package game.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_COMMAND = "명령(h, j, k, l, q)";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String askCommand() {
        System.out.println(INPUT_COMMAND);
        return scanner.nextLine();
    }

}
