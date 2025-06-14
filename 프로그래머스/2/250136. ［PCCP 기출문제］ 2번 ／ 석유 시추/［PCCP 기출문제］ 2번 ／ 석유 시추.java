import java.util.*;

class Solution {
    private static final int[] DR = {-1,1,0,0};
    private static final int[] DC = {0,0,-1,1};
    
    public int solution(int[][] land) {
        
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] colSum = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    explore(i, j, land, visited, colSum);
                }
            }
        }
        
        int answer = 0;
        for (int x : colSum) {
            answer = Math.max(answer, x);
            
        }
        
        return answer;
    }
    
    private void explore(int sr, int sc, int[][] land, boolean[][] visited, int[] colSum) {
        int n = land.length;
        int m = land[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        List<Integer> columns = new ArrayList<>();
        int size = 0;
        
        visited[sr][sc] = true;
        q.offer(new int[]{sr, sc});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            
            if (land[r][c] == 1) {
                size++;
                columns.add(c);
            } else {
                return;
            }
            
            for (int d=0; d<4; d++) {
                int nr = r + DR[d], nc = c + DC[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (land[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        
        Set<Integer> uniqueCols = new HashSet<>(columns);
        for (int c : uniqueCols) {
            colSum[c] += size;
        }
    }
}