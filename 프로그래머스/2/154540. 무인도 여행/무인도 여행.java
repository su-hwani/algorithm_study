import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            for (int k = 0; k < maps[i].length(); k++) {
                if (visited[i][k]) continue;
                
                char c = maps[i].charAt(k);
                if (Character.isDigit(c)) {
                    int count = bfs(visited, i, k, maps);
                    answer.add(count);
                }
                
            }
        }
        
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        return answer.stream()
                    .sorted(Integer::compare)  // 또는 .sorted()만 사용해도 됨
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
    
    private int bfs(boolean[][] visited, int x, int y, String[] maps) {
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            char c = maps[curX].charAt(curY);
            int nowCount = Integer.parseInt(String.valueOf(c));
            
            count += nowCount;
            
            
            int[] dx = {1, -1, 0, 0}; 
            int[] dy = {0, 0, -1, 1};
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && visited.length > nextX && nextY >= 0 && visited[0].length > nextY) {
                    char nextC = maps[nextX].charAt(nextY);
                    
                        
                    if (!visited[nextX][nextY] && Character.isDigit(nextC)) {
                        q.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                    
                }
            }
        }
        return count;
        
    }
}