package game.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_COMMAND = "명령(h, j, k, l, q)";
    private static final List<String> VALID_INPUT_COMMAND = List.of("h", "j", "k", "l", "q", "a","s","d","w");
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String askCommand() {
        System.out.println(INPUT_COMMAND);
        String inputCommand = scanner.nextLine();
        if (!VALID_INPUT_COMMAND.contains(inputCommand)) {
            return askCommand();
        }
        return inputCommand;
    }

}
