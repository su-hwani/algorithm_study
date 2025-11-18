import java.util.*;

class Solution {
    public int solution(int[] topping) {


        int answer = 0;

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            right.compute(topping[i], (key, value) -> {
                return value == null ? 1 : value + 1;
            });
        }

        for (int i = 0; i < topping.length; i++) {
            int rightValue = right.get(topping[i]);
            left.compute(topping[i], (key, value) -> value == null ? 1 : value + 1);

            if (rightValue == 1) {
                right.remove(topping[i]);
            } else {
                right.compute(topping[i], (key, value) -> value - 1);
            }

            if (right.size() == left.size()) {
                answer++;
            }
        }

        return answer;
    }
}