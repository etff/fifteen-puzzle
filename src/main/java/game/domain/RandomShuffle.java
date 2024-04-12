package game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomShuffle implements ShuffleStrategy {

    @Override
    public List<Integer> shuffle(List<Integer> numbers) {
        List<Integer> shuffledNumbers = new ArrayList<>(numbers);
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers;
    }
}
