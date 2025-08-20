import java.util.*; 
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{0, 0, 1});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        while (!dq.isEmpty()) {
            int[] cur = dq.removeFirst();
            int x = cur[0], y = cur[1], dist = cur[2];
            
            if (x == n-1 && y == m-1) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m && visited[nx][ny] == false && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    dq.addLast(new int[]{nx, ny, dist+1});
                } 
            }
        }
        return -1;
    }
}