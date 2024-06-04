import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < N * N + 1; i++) {
            arr.add(i, new HashSet<>());
        }
        int[] order = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;
            for (int j = 0; j < 4; j++) {
                arr.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }
        //배치단계
        for (int n = 0; n < N * N; n++) {
            PriorityQueue<Seat> pq = new PriorityQueue<>();
            HashSet<Integer> cur = arr.get(order[n]);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0) {
                        continue;
                    }

                    //주변확인
                    int count = 0;
                    int blank = 0;
                    for (int k = 0; k < 4; k++) {
                        int newY = i + dy[k];
                        int newX = j + dx[k];
                        if (newY >= N || newY < 0 || newX >= N || newX < 0) {
                            continue;
                        }
                        int temp = map[newY][newX];
                        if (temp == 0) {
                            blank++;
                            continue;
                        }
                        if (cur.contains(temp)) {
                            count++;
                        }
                    }
                    pq.add(new Seat(count, blank, i, j));
                }
            }
            Seat seatCur = pq.poll();
            map[seatCur.y][seatCur.x] = order[n];
        }
        //만족도 계산 단계
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                HashSet<Integer> cur = arr.get(map[i][j]);
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int newY = i + dy[k];
                    int newX = j + dx[k];
                    if (newY >= N || newY < 0 || newX >= N || newX < 0) {
                        continue;
                    }
                    int temp = map[newY][newX];
                    if (cur.contains(temp)) {
                        count++;
                    }
                }
                if (count == 1) {
                    answer += 1;
                } else if (count == 2) {
                    answer += 10;
                } else if (count == 3) {
                    answer += 100;
                } else if (count == 4) {
                    answer += 1000;
                }
            }

        }
        System.out.println(answer);
    }
}

class Seat implements Comparable<Seat> {
    int like;
    int blank;
    int y, x;

    public Seat(int like, int blank, int y, int x) {
        this.like = like;
        this.blank = blank;
        this.y = y;
        this.x = x;


    }

    @Override
    public int compareTo(Seat o) {
        if (like == o.like) {
            if (blank == o.blank) {
                return y * 3 + x - o.y * 3 + o.x;
            }
            return o.blank - blank;
        }
        return o.like - like;
    }
}