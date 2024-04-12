package game.domain;

import java.util.List;
import java.util.stream.IntStream;

public class OrderChecker {
    public static boolean isAscending(List<Integer> numbers) {
        return IntStream.range(0, numbers.size() - 1)
                .noneMatch(i -> numbers.get(i) > numbers.get(i + 1));
    }
}
