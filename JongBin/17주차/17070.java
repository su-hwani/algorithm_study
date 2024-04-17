import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 1, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            if (y == N - 1 && x == N - 1) {
                answer++;
                continue;
            }
            int dir = cur.dir;
            boolean rightCheck = rightCheck(y, x);
            boolean cornerCheck = cornerCheck(y, x);
            boolean downCheck = downCheck(y, x);
            if (dir == 0) {
                if (rightCheck) {
                    q.add(new Node(y, x + 1, 0));
                }
            } else if (dir == 1) {
                if (downCheck(y, x)) {
                    q.add(new Node(y + 1, x, 1));
                }
            } else {
                if (rightCheck) {
                    q.add(new Node(y, x + 1, 0));
                }
                if (downCheck) {
                    q.add(new Node(y + 1, x, 1));
                }
            }
            if (cornerCheck) {
                q.add(new Node(y + 1, x + 1, 2));
            }

        }
        System.out.println(answer);
    }

    public static boolean rightCheck(int y, int x) {
        return y < N && x + 1 < N && map[y][x + 1] != 1;
    }

    public static boolean downCheck(int y, int x) {
        return y + 1 < N && x < N && map[y + 1][x] != 1;
    }

    public static boolean cornerCheck(int y, int x) {
        return y + 1 < N && x + 1 < N && map[y + 1][x + 1] != 1 && map[y][x + 1] != 1 && map[y + 1][x] != 1;
    }
}

class Node {
    int y, x, dir;

    public Node(int y, int x, int dir) {
        this.y = y;
        this.x = x;
        this.dir = dir;
    }
}