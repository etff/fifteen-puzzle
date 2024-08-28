package game.domain;

public record Pointer(int row, int col) {
    public static Pointer notFound() {
        return new Pointer(-1, -1);
    }

    public Pointer changeRow(int row) {
        return new Pointer(row, this.col);
    }

    public Pointer changeCol(int col) {
        return new Pointer(this.row, col);
    }

    public Pointer move(int newRow, int newCol) {
        return new Pointer(newRow, newCol);
    }

    public Pointer plus(int deltaRow, int deltaCol) {
        return new Pointer(row + deltaRow, col + deltaCol);
    }
}
