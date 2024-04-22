import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int max = 0;
    static int N;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        brut(0, 0);
        System.out.println(max);

    }

    public static void brut(int depth, int sum) {
        if (depth == N - 2) {
            max = Math.max(max, sum);
        }
        for (int i = 1; i < N - 1; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            int idx = 1;
            while (visit[i - idx]) {
                idx++;
            }
            int before = arr[i - idx];
            idx = 1;
            while (visit[i + idx]) {
                idx++;
            }
            int after = arr[i + idx];
            int temp = sum + before * after;
            brut(depth + 1, temp);
            visit[i] = false;
        }
    }
}