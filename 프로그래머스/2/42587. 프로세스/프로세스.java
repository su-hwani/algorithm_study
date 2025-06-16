import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<List<Integer>> queue = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int index = 0; index < priorities.length; index++) {
            List<Integer> l = new ArrayList<>();
            l.add(index);
            l.add(priorities[index]);
            
            queue.add(l);
            maxHeap.add(priorities[index]);
        }
        
        while (!queue.isEmpty()) {
            Integer max = maxHeap.peek();
            List<Integer> cur = queue.poll();
            Integer curIndex = cur.get(0);
            Integer curValue = cur.get(1);
            
            if (max == curValue) {
                maxHeap.poll();
                if (curIndex == location) {
                    return answer+1;
                } else {
                    
                    answer++;
                }
            } else {
                queue.add(cur);
            }
        }
        
        return answer;
    }
}