package game.domain;

import java.util.List;

public class OrderChecker {
    public boolean isAscend(List<Integer> values) {
        for (int i = 0; i < values.size() - 1; i += 1) {
            if (values.get(i) != i + 1) {
                return false;
            }
        }
        return true;
    }
}
