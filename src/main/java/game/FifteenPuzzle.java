package game;

import game.domain.Game;
import game.domain.InputView;
import game.domain.Numbers;
import game.domain.OrderChecker;
import game.domain.OutputView;
import game.domain.RandomOrder;
import game.domain.commands.Command;
import game.domain.commands.CommandFactory;
import game.infrastructure.ConsoleIO;

import java.util.Map;

public class FifteenPuzzle {
    private final Game game;

    private final InputView inputView;
    private final OutputView outputView;

    private final Map<String, Command> commands;

    public FifteenPuzzle(
            ConsoleIO consoleIO,
            CommandFactory commandFactory
    ) {
        int width = 4;
        int height = 4;
        Numbers numbers = new Numbers(width * height - 1, new RandomOrder());
        OrderChecker orderChecker = new OrderChecker();

        this.game = new Game(width, height, numbers, orderChecker);

        this.inputView = consoleIO;
        this.outputView = consoleIO;

        this.commands = commandFactory.createCommandMap();
    }

    public void run() {
        printWelcome();
        printBoard();
        playGame();
    }

    private void playGame() {
        while (isPlaying()) {
            runCommand();
            printBoard();
        }

        printResult();
    }

    private boolean isPlaying() {
        return game.isPlaying();
    }

    private void runCommand() {
        Command command = askCommand();
        command.run(game);
    }

    private Command askCommand() {
        while (true) {
            String input = inputView.askCommand();

            if (commands.containsKey(input)) {
                return commands.get(input);
            }
        }
    }

    private void printWelcome() {
        outputView.printWelcome();
    }

    private void printBoard() {
        if (game.isQuit()) {
            return;
        }

        outputView.printBoard(game.board());
    }

    private void printResult() {
        if (game.isQuit()) {
            printGameEnd();
            return;
        }

        outputView.printResult(game);
    }

    private void printGameEnd() {
        outputView.printGameEnd();
    }

    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO();
        CommandFactory commandFactory = new CommandFactory();
        new FifteenPuzzle(consoleIO, commandFactory).run();
    }
}
