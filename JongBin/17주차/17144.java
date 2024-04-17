import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int R, C, T;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int airY = -1, airX = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                if (cur == -1 && airY == -1) {
                    airY = i;
                    airX = j;
                }
            }
        }

        while (T-- > 0) {
            map = spread(map);
            map = turn(map);
        }
        int answer = count(map);
        System.out.println(answer);
    }

    public static int count(int[][] map) {
        int answer = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += map[i][j];
            }
        }
        return answer;
    }

    public static int[][] turn(int[][] map) {
        int[][] newMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            newMap[i] = Arrays.copyOf(map[i], C);
        }

        for (int i = 0; i < C - 1; i++) {
            int temp = map[airY][i];
            if (temp == -1) {
                temp = 0;
            }
            newMap[airY][i + 1] = temp;
        }
        for (int i = airY; i > 0; i--) {
            int temp = map[i][C - 1];
            if (temp == -1) {
                temp = 0;
            }
            newMap[i - 1][C - 1] = temp;
        }
        for (int i = C - 1; i > 0; i--) {
            int temp = map[0][i];
            if (temp == -1) {
                temp = 0;
            }
            newMap[0][i - 1] = temp;
        }
        for (int i = 0; i < airY - 1; i++) {
            int temp = map[i][0];
            if (temp == -1) {
                temp = 0;
            }
            newMap[i + 1][0] = temp;
        }
        //
        for (int i = 0; i < C - 1; i++) {
            int temp = map[airY + 1][i];
            if (temp == -1) {
                temp = 0;
            }
            newMap[airY + 1][i + 1] = temp;
        }
        for (int i = airY + 1; i < R - 1; i++) {
            int temp = map[i][C - 1];
            if (temp == -1) {
                temp = 0;
            }
            newMap[i + 1][C - 1] = temp;
        }
        for (int i = C - 1; i > 0; i--) {
            int temp = map[R - 1][i];
            if (temp == -1) {
                temp = 0;
            }
            newMap[R - 1][i - 1] = temp;
        }
        for (int i = R - 1; i > airY + 1; i--) {
            int temp = map[i][0];
            if (temp == -1) {
                temp = 0;
            }
            newMap[i - 1][0] = temp;
        }
        newMap[airY][airX] = -1;
        newMap[airY + 1][airX] = -1;
        return newMap;
    }

    public static int[][] spread(int[][] map) {

        int[][] newMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            newMap[i] = Arrays.copyOf(map[i], C);
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int temp = map[i][j] / 5;
                for (int k = 0; k < 4; k++) {
                    int newY = i + dy[k];
                    int newX = j + dx[k];
                    if (newY >= R || newY < 0 || newX >= C || newX < 0 || map[newY][newX] == -1) {
                        continue;
                    }
                    newMap[newY][newX] += temp;
                    newMap[i][j] -= temp;
                }
            }
        }
        return newMap;
    }
}