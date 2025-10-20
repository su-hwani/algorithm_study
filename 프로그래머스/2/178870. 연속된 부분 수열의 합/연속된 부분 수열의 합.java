import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int sequenceLength = sequence.length;
        int start = sequenceLength - 1, end = sequenceLength - 1;
        int cur = sequence[start];
        int[] answer = {0, 0};
        
        while (start >= 0) {
            if (cur == k){
                break;
            } else if (cur > k) {
                cur -= sequence[end];
                end -= 1;
            } else {
                // cur < k
                start -= 1;
                cur += sequence[start];
            }
        }
        
        if (sequence[start] == sequence[end]) {
            int differ = end - start;
            for (int i = start; i >= 0; i--) {
                if (sequence[start] != sequence[i]) {
                    start = i + 1;
                    break;
                }
                start = i;
            }
            end = start + differ;
        }
        
        
        answer[0] = start;
        answer[1] = end;
        return answer;
    }
}