package game.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    public static final int MAX_NUMBER = 15;
    private final List<Integer> values;

    public Numbers(OrderStrategy orderStrategy) {
        this.values = orderStrategy.orderNumbers(generateNumbers());
    }

    private List<Integer> generateNumbers() {
        return IntStream.rangeClosed(0, MAX_NUMBER).boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getValues() {
        return Collections.unmodifiableList(values);
    }

    public int getBlock(int index) {
        return values.get(index);
    }
}
