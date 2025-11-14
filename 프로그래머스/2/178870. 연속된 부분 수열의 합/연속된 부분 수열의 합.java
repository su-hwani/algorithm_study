class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int startIdx = sequence.length - 1;
        int endIdx = sequence.length - 1;
        int sum = sequence[endIdx];
        
        System.out.println(sum);
        
        while (sum != k) {
            if (sum > k) {
                if (endIdx == startIdx) {
                    startIdx--;
                    sum += sequence[startIdx];
                }
                sum -= sequence[endIdx];
                endIdx--;
                
            } else {
                // sum < k
                startIdx--;
                sum += sequence[startIdx];
            }
            
        }
        
        while (sequence[startIdx] == sequence[endIdx] && startIdx != 0 && sequence[startIdx-1] == sequence[endIdx]) {
            startIdx--;
            endIdx--;
            
        }
        
        
        int[] answer = {startIdx, endIdx};
        return answer;
    }
}