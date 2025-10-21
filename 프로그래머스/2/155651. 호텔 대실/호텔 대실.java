import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> {
            return isCompare(a[0], b[0]);
        });
        
        Queue<String> q = new PriorityQueue<>((a, b) -> isCompare(a, b));
        
        for (String[] time: book_time) {
            String mostFastEndTime = q.poll();
            
            String curStartTime = time[0]; // H:M
            String curEndTime = time[1]; // H:M
            String curEndTimeUpTen = getEndedTimeUpTen(curEndTime);
            if (mostFastEndTime == null) {
                q.offer(curEndTimeUpTen);
                answer += 1;
            } else {
                if (isCompare(curStartTime, mostFastEndTime) >= 0) {
                    q.offer(curEndTimeUpTen);
                    // 기존 방 이어서 쓰니까 방을 추가하지 않음  
                } else {
                    // 빼냈던 걸 넣어주고, 새로운 방을 추가해줌
                    q.offer(curEndTimeUpTen);
                    q.offer(mostFastEndTime);
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
    
    public int isCompare(String a, String b) {
        // a 가 크면 1 이면 오름차순
        String[] a1 = a.split(":");
        String[] b1 = b.split(":");
        
        int a1Hour = Integer.parseInt(a1[0]) * 60, a1Min = Integer.parseInt(a1[1]);
        int a2Hour = Integer.parseInt(b1[0]) * 60, a2Min = Integer.parseInt(b1[1]);
        
        return (a1Hour + a1Min) - (a2Hour + a2Min);
    }
    
    public String getEndedTimeUpTen(String time) {
        // Hour:Min
        String hour = time.split(":")[0];
        String min = time.split(":")[1];
        
        Integer h = Integer.parseInt(hour);
        Integer m = Integer.parseInt(min) + 10;
        
        if (m >= 60) {
            h += 1;
            m -= 60;
        }
        
        return h.toString() + ":" + m.toString();
    }
}