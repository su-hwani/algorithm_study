import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> countMap = new HashMap<>();
        String answer = "";
        
        for (String s: participant) {
            Integer count = countMap.get(s);
            if (count != null) {
                countMap.put(s, count+1);
            } else {
                countMap.put(s, 1);
            }
        }
        
        for (String s: completion) {
            Integer count = countMap.get(s);
            if (count > 1) {
                countMap.put(s, count-1);
            } else {
                countMap.remove(s);
            }
        }
        
        for (Map.Entry<String, Integer> entry: countMap.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        
        return answer;
    }
}