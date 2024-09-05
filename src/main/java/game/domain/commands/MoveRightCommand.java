package game.domain.commands;

import game.domain.Game;

public class MoveRightCommand implements Command {
    @Override
    public void run(Game game) {
        game.moveRight();
    }
}
