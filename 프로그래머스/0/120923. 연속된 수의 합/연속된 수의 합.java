import java.util.*;
class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        int curTotal = 0;
        int curNum = 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        
        if (num == 1) {
            return new int[]{total};
        }

        while (curTotal != total || curNum != num) {
            
            System.out.println(q.toString());

            if (curNum != num) {

                curNum++;
                curTotal += q.peekLast() + 1;
                q.addLast(q.peekLast() + 1);
                continue;
            }

            if (curTotal > total) {
                curTotal -= q.pollLast();
                curTotal += q.peekFirst() - 1;
                q.addFirst(q.peekFirst() - 1);
            } else {
                curTotal -= q.pollFirst();
                curTotal += q.peekLast() + 1;
                q.addLast(q.peekLast() + 1);
            }
        }
            
        int qSize = q.size();
        
        if (qSize == 0) {
            return new int[]{0};
        }
        
        for (int i = 0; i < qSize; i++) {
            answer[i] = q.pollFirst();
        }
        
        
        return answer;
    }
}