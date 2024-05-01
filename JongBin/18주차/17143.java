import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static Shark[][] map;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r, c, s, d, z);
        }
        int fisherLoc = 0;
        int answer = 0;
        while (fisherLoc < C) {
            for (int i = 0; i < R; i++) {
                if (map[i][fisherLoc] != null) {
                    answer += map[i][fisherLoc].z;
                    map[i][fisherLoc] = null;
                    break;
                }
            }
            Shark[][] newMap = new Shark[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == null) continue;
                    Shark newPosition = move(map[i][j]);
                    if (newMap[newPosition.r][newPosition.c] != null && newMap[newPosition.r][newPosition.c].z > newPosition.z) {
                        continue;
                    }
                    newMap[newPosition.r][newPosition.c] = newPosition;
                }
            }
            map = newMap;
            fisherLoc++;
        }
        System.out.println(answer);
    }

    static Shark move(Shark shark) {
        int i = shark.r;
        int j = shark.c;
        //위,아래,오른쪽,왼쪽
        int dir = shark.d;
        int speed = shark.s;
        while (speed-- > 0) {
            if (dir == 1) {
                i--;
                if (i < 0) {
                    i = 1;
                    dir = 2;
                    continue;
                }
            }
            if (dir == 2) {
                i++;
                if (i >= R) {
                    i = R - 2;
                    dir = 1;
                    continue;
                }
            }
            if (dir == 3) {
                j++;
                if (j >= C) {
                    j = C - 2;
                    dir = 4;
                    continue;
                }
            }
            if (dir == 4) {
                j--;
                if (j < 0) {
                    j = 1;
                    dir = 3;
                    continue;
                }
            }
        }
        return new Shark(i, j, shark.s, dir, shark.z);
    }
}

class Shark {
    int r, c, s, d, z;

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}