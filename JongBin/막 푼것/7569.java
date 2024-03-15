import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static boolean[][][] map;
    static boolean[][][] visit;
    static int left = 0;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int N, M, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new boolean[H][N][M];
        visit = new boolean[H][N][M];
        Queue<Tomato> q = new ArrayDeque<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    String temp = st.nextToken();
                    if (temp.equals("-1")) {
                        map[k][i][j] = true;
                        continue;
                    }
                    if (temp.equals("1")) {
                        q.add(new Tomato(i, j, k, 0));
                        visit[k][i][j] = true;
                        continue;
                    }
                    left++;
                }
            }
        }

        int answer = bfs(q);
        if (left == 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    static int bfs(Queue<Tomato> q) {
        int answer = 0;
        while (!q.isEmpty()) {
            Tomato cur = q.poll();
            answer = cur.count;
            for (int i = 0; i < 6; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                int newH = cur.h + dh[i];
                if (newY >= N || newX >= M || newX < 0 || newY < 0 || newH >= H || newH < 0 || visit[newH][newY][newX] || map[newH][newY][newX])
                    continue;
                visit[newH][newY][newX] = true;
                q.add(new Tomato(newY, newX, newH, cur.count + 1));
                left--;
            }
        }
        return answer;
    }
}

class Tomato {
    int h, x, y, count;

    public Tomato(int y, int x, int h, int count) {
        this.y = y;
        this.x = x;
        this.h = h;
        this.count = count;
    }
}