import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        StringTokenizer st;
        int[] arr;
        int[] dp;
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            dp = new int[N];
            dp[0] = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < N; i++) {
                dp[i] = arr[i] - arr[i - 1];
            }
            long answer = 0;
            int max = Integer.MIN_VALUE;
            for (int i = N - 1; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                }
                dp[i] = max - arr[i];
            }
            for (int i = 0; i < N; i++) {
                if (dp[i] > 0) {
                    answer += dp[i];
                }
            }
            System.out.println(answer);
        }
    }
}