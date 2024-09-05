package game.domain.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    public Map<String, Command> createCommandMap() {
        MoveLeftCommand moveLeftCommand = new MoveLeftCommand();
        MoveRightCommand moveRightCommand = new MoveRightCommand();
        MoveUpCommand moveUpCommand = new MoveUpCommand();
        MoveDownCommand moveDownCommand = new MoveDownCommand();

        Map<String, Command> commands = new HashMap<>();

        commands.put("h", moveLeftCommand);
        commands.put("l", moveRightCommand);
        commands.put("k", moveUpCommand);
        commands.put("j", moveDownCommand);

        commands.put("a", moveLeftCommand);
        commands.put("d", moveRightCommand);
        commands.put("w", moveUpCommand);
        commands.put("s", moveDownCommand);

        commands.put("q", new QuitCommand());

        return commands;
    }
}
