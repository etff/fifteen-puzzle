package game.domain.commands;

import game.domain.Game;

public class MoveLeftCommand implements Command {
    @Override
    public void run(Game game) {
        game.moveLeft();
    }
}
