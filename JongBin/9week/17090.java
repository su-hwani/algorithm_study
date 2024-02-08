import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    //u,r,d,l
    static int direction[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean success[][];
    static int map[][];
    static int visited[][];
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                //input map을 저장
                char c = line.charAt(j);
                if (c == 'U') {
                    map[i][j] = 0;
                } else if (c == 'R') {
                    map[i][j] = 1;
                } else if (c == 'D') {
                    map[i][j] = 2;
                } else {
                    map[i][j] = 3;
                }
                //visited 초기화
                visited[i][j] = 0;
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean dfs(int x, int y) {
        boolean result = false;
        if (escapeCheck(x, y)) {
            return true;
        }
        //4 = 이미 탈출 한 경로, -1 = 탈출 못함;
        if (map[x][y] == 4) {
            return true;
        } else if (map[x][y] == -1) {
            return false;
        }

        if (visited[x][y] == 1) return false;
        visited[x][y] =1;

        if (map[x][y] == 0) {
            result = dfs(x+direction[0][0], y+direction[0][1]);
        } else if (map[x][y] == 1) {
            result = dfs(x+ direction[1][0], y+direction[1][1]);
        } else if (map[x][y] == 2) {
            result = dfs(x+direction[2][0], y+direction[2][1]);
        } else if (map[x][y] == 3) {
            result = dfs(x+direction[3][0], y+direction[3][1]);
        }
        map[x][y] = result ? 4 : -1;
        return result;
    }

    public static boolean escapeCheck(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}