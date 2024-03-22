import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static int N, M;
    public static boolean[][] map;

    public static int[] dx = {1, -1, 0, 0};//동 서 남 북
    public static int[] dy = {0, 0, 1, -1};
    public static int[] updown = {2, 3};
    public static int[] rightleft = {0, 1};
    public static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][M + 1];
        visit = new boolean[4][N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                String temp = st.nextToken();
                if (temp.equals("1")) map[i][j] = true;
            }
        }
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        visit[dir - 1][y][x] = true;
        Move startPoint = new Move(y, x, dir, 0);
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        Move endPoint = new Move(y, x, dir, 0);
        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.add(startPoint);
        while (!pq.isEmpty()) {
            Move cur = pq.poll();
            if (cur.y == endPoint.y && cur.x == endPoint.x && cur.dir == endPoint.dir) {
                System.out.println(cur.count);
                return;
            }
            for (int i = 1; i <= 3; i++) {
                int newX = cur.x + dx[cur.dir - 1] * i;
                int newY = cur.y + dy[cur.dir - 1] * i;
                if (newX > M || newY > N || newX <= 0 || newY <= 0 || visit[cur.dir - 1][newY][newX]) {
                    continue;
                }
                if (map[newY][newX]) break; // 앞에가 벽으로 막혀있으면 전진 X
                visit[cur.dir - 1][newY][newX] = true;
                pq.add(new Move(newY, newX, cur.dir, cur.count + 1));
            }
            for (int i = 0; i < 2; i++) {
                int curDir = rightleft[i];
                if (cur.dir == 1 || cur.dir == 2) {
                    curDir = updown[i];
                }
                if (visit[curDir][cur.y][cur.x]) continue;
                visit[curDir][cur.y][cur.x] = true;
                pq.add(new Move(cur.y, cur.x, curDir + 1, cur.count + 1));
            }
        }
    }
}

class Move implements Comparable<Move> {
    int y, x, dir, count;

    public Move(int y, int x, int dir, int count) {
        this.y = y;
        this.x = x;
        this.dir = dir;
        this.count = count;
    }


    @Override
    public int compareTo(Move o) {
        return this.count - o.count;
    }
}