class Solution {
    public int solution(int[][] board) {

        int answer = 0;

        boolean[][] visited = new boolean[board.length][board[0].length];

        int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
        int[] dy = { 0, 0, -1, 1, 1, 1, -1, -1 };

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] == 1) {
                    visited[i][k] = true;

                    for (int q = 0; q < dx.length; q++) {
                        int nx = dx[q] + i;
                        int ny = dy[q] + k;

                        if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

        for (boolean[] row : visited) {
            for (boolean col : row) {
                if (!col) {
                    answer++;
                }
            }
        }

        return answer;
    }
}