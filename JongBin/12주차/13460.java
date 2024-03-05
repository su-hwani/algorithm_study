import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static char[][] map;
    static int[] moveX = {1, -1, 0, 0};//우 좌 상 하
    static int[] moveY = {0, 0, -1, 1};

    static boolean holeCheck(Position p) {
        return map[p.y][p.x] == 'O';
    }

    static Ball moveBall(int i, Position first, Position second, int count) {
        String status = "run";
        Position f = new Position(first.y, first.x, first.color);
        Position s = new Position(second.y, second.x, second.color);
        int changeCount = 0;
        while (true) {
            if (map[f.y + moveY[i]][f.x + moveX[i]] != '#') {
                changeCount++;
                f.y += moveY[i];
                f.x += moveX[i];
                if (holeCheck(f)) {
                    if (f.color == 'r') {
                        status = "clear";
                    } else {
                        status = "false";
                    }
                    f.y = 0;
                    f.x = 0;
                    break;
                }
                continue;
            }
            break;
        }
        while (true) {
            if (map[s.y + moveY[i]][s.x + moveX[i]] != '#' &&
                    (f.y != s.y + moveY[i] || f.x != s.x + moveX[i])) {
                changeCount++;
                s.y += moveY[i];
                s.x += moveX[i];
                if (holeCheck(s)) {
                    if (s.color == 'r' && !status.equals("false")) {
                        status = "clear";
                    } else {
                        status = "false";
                    }
                    s.y = 0;
                    s.x = 0;
                    break;
                }
                continue;
            }
            break;
        }

        if (changeCount == 0) status = "no";
        return new Ball(f, s, status, count + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Position blue = new Position(0, 0, 'b');
        Position red = new Position(0, 0, 'r');

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = s.charAt(j);
                if (temp == 'B') {
                    blue = new Position(i, j, 'b');
                    map[i][j] = '.';
                    continue;
                }
                if (temp == 'R') {
                    red = new Position(i, j, 'r');
                    map[i][j] = '.';
                    continue;
                }

                map[i][j] = temp;
            }
        }
        System.out.println(bfs(red, blue));


    }

    public static int bfs(Position red, Position blue) {
        Queue<Ball> queue = new ArrayDeque<>();
        queue.offer(new Ball(red, blue, "run", 0));
        int answer = -1;
        while (!queue.isEmpty()) {
            Ball cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                //우 좌 상 하
                Position first;
                Position second;
                if (i == 0) {
                    if (cur.blue.x > cur.red.x) {
                        first = cur.blue;
                        second = cur.red;
                    } else {
                        first = cur.red;
                        second = cur.blue;
                    }
                } else if (i == 1) {
                    if (cur.blue.x < cur.red.x) {
                        first = cur.blue;
                        second = cur.red;
                    } else {
                        first = cur.red;
                        second = cur.blue;
                    }
                } else if (i == 2) {
                    if (cur.blue.y < cur.red.y) {
                        first = cur.blue;
                        second = cur.red;
                    } else {
                        first = cur.red;
                        second = cur.blue;
                    }
                } else {
                    if (cur.blue.y > cur.red.y) {
                        first = cur.blue;
                        second = cur.red;
                    } else {
                        first = cur.red;
                        second = cur.blue;
                    }
                }
                Ball result = moveBall(i, first, second, cur.count);
                if (result.status.equals("clear")) {
                    if (answer == -1) {
                        answer = result.count;
                    } else {
                        answer = Math.min(answer, result.count);
                    }

                } else if (result.status.equals("run") && result.count < 10) {
                    queue.add(result);
                }
            }
        }
        return answer;
    }
}

class Ball {
    Position red, blue;
    String status;
    int count;

    public Ball(Position a, Position b, String status, int count) {
        this.status = status;
        this.count = count;
        if (a.color == 'b') {
            this.blue = a;
        }
        if (a.color == 'r') {
            this.red = a;
        }
        if (b.color == 'b') {
            this.blue = b;
        }
        if (b.color == 'r') {
            this.red = b;
        }
    }
}

class Position {
    int x, y;
    char color;

    public Position(int y, int x, char color) {
        this.y = y;
        this.x = x;
        this.color = color;
    }
}