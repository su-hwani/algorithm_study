import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
    static int N;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visit = new boolean[N][N];
        int visibleCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) {
                    continue;
                }
                BFS(i, j, true);
                visibleCount++;
            }
        }

        visit = new boolean[N][N];
        int invisibleCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) {
                    continue;
                }
                BFS(i, j, false);
                invisibleCount++;
            }
        }
        System.out.println(visibleCount + " " + invisibleCount);
    }

    public static void BFS(int y, int x, boolean visible) {
        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(y, x));
        while (!q.isEmpty()) {
            Position cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if (newX >= N || newY >= N || newX < 0 || newY < 0 || visit[newY][newX]) continue;
                char nextColor = map[newY][newX];
                char color = map[cur.y][cur.x];
                if (visible && nextColor != color) continue;// 색약이아닌데 색이 다른경우
                if (!visible && nextColor != color && !((nextColor == 'R' && color == 'G') || (nextColor == 'G' && color == 'R'))) {
                    continue;
                }
                visit[newY][newX] = true;
                q.add(new Position(newY, newX));
            }
        }
    }
}

class Position {
    int x, y;

    public Position(int y, int x) {
        this.x = x;
        this.y = y;
    }
}