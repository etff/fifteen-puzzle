package game.domain.commands;

import game.domain.Game;

public class QuitCommand implements Command {
    @Override
    public void run(Game game) {
        game.quit();
    }
}
