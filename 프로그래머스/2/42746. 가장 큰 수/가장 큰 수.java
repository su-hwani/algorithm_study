import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] s = Arrays.stream(numbers)
                            .mapToObj(i -> Integer.toString(i))
                            .toArray(si -> new String[si]);
    
        Arrays.sort(s, (a, b) -> (b+a).compareTo(a+b));
        
        if (s[0].equals("0")) {
            return "0";
        }

        
        String answer = "";
        for (String st: s) {
            answer = answer + st;
        }
        
        return answer;
    }
}