package game.domain;

public class Counter {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public void increase() {
        value += 1;
    }

    public int value() {
        return value;
    }
}
