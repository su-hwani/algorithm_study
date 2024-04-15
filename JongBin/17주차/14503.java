import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[][] map;

    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {-1, 0, 1, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(r, c, d));
        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            //작동 순서 1번
            if (map[cur.y][cur.x] == 0) {
                map[cur.y][cur.x] = -1; //-1 : 청소함
                answer++;
            }
            //작동순서 3번
            for (int i = 1; i < 5; i++) {
                int dir = cur.dir - i;
                if (dir < 0) dir += 4;
                int newX = cur.x + dirX[dir];
                int newY = cur.y + dirY[dir];
                if (map[newY][newX] == 0) {
                    queue.add(new Position(newY, newX, dir));
                    break;
                }
            }
            //작동순서 3번
            if (queue.isEmpty()) {
                int newX = cur.x - dirX[cur.dir];
                int newY = cur.y - dirY[cur.dir];
                if (map[newY][newX] != 1) {
                    queue.add(new Position(newY, newX, cur.dir));
                }
            }
        }
        System.out.println(answer);
    }
}

class Position {
    int y, x, dir;

    public Position(int y, int x, int dir) {
        this.y = y;
        this.x = x;
        this.dir = dir;
    }
}