class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];
        
        for (int i = 0; i < results.length; i++) {
            int[] cur = results[i];
            int winNum = cur[0], loseNum = cur[1];
            graph[winNum][loseNum] = 1;
            graph[loseNum][winNum] = -1;
        }
        
        
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n; k++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
            
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int k = 1; k <= n; k++) {
                if (i == k) {
                    continue;
                }
                if (graph[i][k] != 0) {
                    count++;
                }
            }
            if (count == n-1) {
                answer++;
            }
        }
        return answer;
    }
}