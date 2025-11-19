import java.util.*;
class Solution {
    public int solution(int[] array) {
        int key1 = 0;
        int value1 = 0;
        boolean isDouble = false;

        Map<Integer, Integer> graph = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            graph.compute(array[i], (key, value) -> value == null ? 1 : value + 1);
        }

        for (Integer i : graph.keySet()) {
            Integer v = graph.get(i);
            if (v > value1) {
                key1 = i;
                value1 = v;
                isDouble = false;
            } else if (v == value1) {
                isDouble = true;
            }
        }

        if (isDouble) {
            return -1;
        }

        return key1;
    }
}