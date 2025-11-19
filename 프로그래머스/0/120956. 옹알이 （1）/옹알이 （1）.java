import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        
        int answer = 0;
        List<String> words = List.of("aya", "ye", "woo", "ma");

        for (String s : babbling) {
            
            for (int i = 0; i < words.size(); i++) {
                
                s = s.replace(words.get(i), " ");
            }
            
            

            if (s.isBlank()) {
                answer++;
            }
        }

        return answer;
    }
}