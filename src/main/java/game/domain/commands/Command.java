package game.domain.commands;

import game.domain.Game;

public interface Command {
    void run(Game game);
}
