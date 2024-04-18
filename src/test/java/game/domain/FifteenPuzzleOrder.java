package game.domain;

import java.util.List;

/**
 * 15 Puzzle의 정렬 순서.
 * [1,2,3,4]
 * [5,6,7,8]
 * [9,10,11,12]
 * [13,14,15,0]
 */
public class FifteenPuzzleOrder implements OrderStrategy {
    @Override
    public List<Integer> orderNumbers(List<Integer> numbers) {
        numbers.sort((o1, o2) -> {
            if (o1 == 0) {
                o1 = Integer.MAX_VALUE;
            }
            if (o2 == 0) {
                o2 = Integer.MAX_VALUE;
            }
            return o1.compareTo(o2);
        });
        return numbers;
    }
}
