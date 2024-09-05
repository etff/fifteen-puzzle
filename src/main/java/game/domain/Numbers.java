package game.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private static final String EXCEED_INDEX_RANGE = "입력 범위를 초과했습니다.";

    private final List<Integer> values;

    public Numbers(int size, OrderStrategy orderStrategy) {
        List<Integer> numbers = generateNumbers(size);
        this.values = orderStrategy.orderNumbers(numbers);
    }

    private List<Integer> generateNumbers(int size) {
        return IntStream
                .rangeClosed(0, size)
                .boxed()
                .collect(Collectors.toList());
    }

    // TODO: 실제로 쓰이지 않음.
    public List<Integer> getValues() {
        return Collections.unmodifiableList(values);
    }

    public int getNumber(int index) {
        if (index >= values.size()) {
            throw new IllegalArgumentException(EXCEED_INDEX_RANGE);
        }
        return values.get(index);
    }
}
