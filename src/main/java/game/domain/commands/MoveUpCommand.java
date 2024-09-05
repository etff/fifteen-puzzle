package game.domain.commands;

import game.domain.Game;

public class MoveUpCommand implements Command {
    @Override
    public void run(Game game) {
        game.moveUp();
    }
}
