package game.domain;

public class Moves {
    private final int moves;

    public Moves() {
        this.moves = 0;
    }

    public Moves(int moves) {
        this.moves = moves;
    }

    public Moves increase() {
        return new Moves(this.moves + 1);
    }

    public int getMoves() {
        return moves;
    }
}
