package game.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private final List<Integer> blocks;

    public Board(ShuffleStrategy shuffleStrategy) {
        this.blocks = shuffleStrategy.shuffle(generateNumbers());
    }

    private List<Integer> generateNumbers() {
        return IntStream.rangeClosed(1, 15).boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }
}
