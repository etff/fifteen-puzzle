package game.domain.commands;

import game.domain.Game;

public class MoveDownCommand implements Command {
    @Override
    public void run(Game game) {
        game.moveDown();
    }
}
