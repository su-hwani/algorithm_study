import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String s: phone_book) {
            map.put(s, 1);
        }
        
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String prefix = number.substring(0, i);
                if (map.containsKey(prefix)) { 
                    return false;
                }
            }
        }
        return true;
    }
}