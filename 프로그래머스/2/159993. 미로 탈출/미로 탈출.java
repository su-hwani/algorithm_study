import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        int doorX = 0, doorY = 0;
        int answer = 0;
        
        for (int i = 0; i < maps.length; i++) {
            for (int k = 0; k < maps[i].length(); k++) {
                char c = maps[i].charAt(k);
                if (c == 'S') {
                    startX = i;
                    startY = k;
                } else if (c == 'E') {
                    endX = i;
                    endY = k;
                } else if (c == 'L') {
                    doorX = i;
                    doorY = k;
                } else {}
            }
        }
        
        int goDoorCount = goDoor(maps, startX, startY, doorX, doorY);
        // System.out.println(goDoorCount);
        if (goDoorCount == 0) {
            return -1;
        }
        
        answer += goDoorCount;
        
        int goEndCount = goDoor(maps, doorX, doorY, endX, endY);
        // System.out.println(goEndCount);
        
        if (goEndCount == 0) {
            return -1;
        }
        answer += goEndCount;     
        
        
        
        return answer;
    }
    
    public int goDoor(String[] maps, int startX, int startY, int doorX, int doorY) {
        int maxX = maps.length;
        int maxY = maps[0].length();
        boolean[][] visited = new boolean[maxX][maxY];
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCount = cur[2];
            
            if (curX == doorX && curY == doorY) {
                return curCount;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY) {
                    char c = maps[nextX].charAt(nextY);
                    if (c != 'X' && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        
                        q.offer(new int[]{nextX, nextY, curCount+1});
                    }
                }
            }
        }
        
        
        return 0;
    }
    
    
}