import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] map;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Point cur = new Point(i, j, 1, map[i][j]);
                dfs(cur);
                m(cur);
            }
        }
        System.out.println(max);
    }

    static void m(Point point) {
        int y = point.y;
        int x = point.x;
        int temp = point.sum;
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newX >= M || newY >= N || newX < 0 || newY < 0) continue;
            temp += map[newY][newX];
        }
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newX >= M || newY >= N || newX < 0 || newY < 0) {
                max = Math.max(max, temp);
                continue;
            }
            max = Math.max(max, temp - map[newY][newX]);
        }
    }

    static void dfs(Point point) {
        int y = point.y;
        int x = point.x;
        if (point.count == 4) {
            max = Math.max(max, point.sum);
            return;
        }
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newX >= M || newY >= N || newX < 0 || newY < 0 || visit[newY][newX]) continue;
            dfs(new Point(newY, newX, point.count + 1, point.sum + map[newY][newX]));
        }
        visit[y][x] = false;
    }
}

class Point {
    int y, x, count, sum;

    Point(int y, int x, int count, int sum) {
        this.y = y;
        this.x = x;
        this.count = count;
        this.sum = sum;
    }
}