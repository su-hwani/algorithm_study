import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> cheese;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cheese = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tenp = Integer.parseInt(st.nextToken());
                map[i][j] = tenp;
                if (tenp == 1) {
                    cheese.add(new Point(i, j));
                    count++;
                }
            }
        }
        int time = 0;
        while (count != 0) {
            time++;
            visited = new boolean[N][M];
            dfs(0, 0);
            melting();
        }
        System.out.println(time);

    }

    static void melting() {
        for (int i = 0; i < cheese.size(); i++) {
            int x = cheese.get(i).x;
            int y = cheese.get(i).y;
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int newX = x + dx[j];
                int newY = y + dy[j];
                if (map[newY][newX] == 2) {
                    cnt++;
                }
            }
            if (cnt >= 2) {
                map[y][x] = 0;
                count--;
                cheese.remove(i);
                i--;
            }
        }
    }


    static void dfs(int y, int x) {
        visited[y][x] = true;
        map[y][x] = 2;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newY < 0 || newX < 0 || newY >= N || newX >= M) continue;
            if (visited[newY][newX] || map[newY][newX] == 1) continue;

            dfs(newY, newX);
        }
    }
}

class Point {
    int x;
    int y;

    Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}