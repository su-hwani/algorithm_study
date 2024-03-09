import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<CCTV> cctv = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    static int[] moveY = {-1, 0, 1, 0}; //상,우,하,좌
    static int[] moveX = {0, 1, 0, -1};
    static int[][] cctvView = {{1}, {1, 3}, {0, 1}, {0, 1, 3}, {0, 1, 2, 3}};
    static int[] cctvRotateCount = {4, 2, 4, 4, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if (temp != 0 && temp != 6) {
                    cctv.add(new CCTV(j, i, temp));
                }
            }
        }
        dfs(map, 0, cctv);
        System.out.println(min);
    }

    static void dfs(int[][] map, int count, ArrayList<CCTV> cctv) {
        if (count == cctv.size()) {
            min = Math.min(min, countZero(map));
            return;
        }
        CCTV cur = cctv.get(count);
        int type = cur.type;
        int x = cur.x;
        int y = cur.y;
        int[][] tempMap;
        int cctvViewNum = cctvView[type - 1].length;
        int[] cctvDir = new int[cctvViewNum];
        System.arraycopy(cctvView[type - 1], 0, cctvDir, 0, cctvViewNum);
        for (int i = 0; i < cctvRotateCount[type - 1]; i++) {
            tempMap = mapCopy(map);
            checkCctv(tempMap, cctvDir, x, y);
            dfs(tempMap, count + 1, cctv);
            for (int j = 0; j < cctvViewNum; j++) {
                cctvDir[j] += 1;
                if (cctvDir[j] >= 4) {
                    cctvDir[j] -= 4;
                }
            }
        }
    }

    static void checkCctv(int[][] map, int[] cctvDir, int x, int y) {
        for (int dir : cctvDir) {
            int i = y;
            int j = x;
            while (N > i && i >= 0 && M > j && j >= 0 && map[i][j] != 6) {
                map[i][j] = -1;
                i += moveY[dir];
                j += moveX[dir];
            }
        }
    }

    static int countZero(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    static int[][] mapCopy(int[][] map) {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, temp[i], 0, M);
        }
        return temp;
    }
}

class CCTV {
    int x, y, type;

    public CCTV(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}