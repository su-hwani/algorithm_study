import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = line.charAt(j);
                if (temp == '0') map[i][j] = true;
            }
        }
        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(0, 0, 1));
        while (!q.isEmpty()) {
            Position cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                if (newX < 0 || newX >= M || newY < 0 || newY >= N || map[newY][newX]) continue;
                map[newY][newX] = true;
                if (newY == N - 1 && newX == M - 1) {
                    System.out.println(cur.count + 1);
                    return;
                }
                q.add(new Position(newY, newX, cur.count + 1));
            }
        }
    }
}

class Position {
    int y, x, count;

    public Position(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}