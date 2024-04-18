package game.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private static final int MAX_NUMBER = 15;
    private static final String EXCEED_INDEX_RANGE = "입력 범위를 초과했습니다.";
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

    public int getNumber(int index) {
        if (index > MAX_NUMBER) {
            throw new IllegalArgumentException(EXCEED_INDEX_RANGE);
        }
        return values.get(index);
    }
}
