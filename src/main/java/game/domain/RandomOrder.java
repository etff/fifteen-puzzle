package game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomOrder implements OrderStrategy {

    @Override
    public List<Integer> orderNumbers(List<Integer> numbers) {
        List<Integer> shuffledNumbers = new ArrayList<>(numbers);
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers;
    }
}
