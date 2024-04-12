package game.domain;

import java.util.List;

public interface ShuffleStrategy {

    List<Integer> shuffle(List<Integer> numbers);
}