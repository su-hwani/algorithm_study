import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        int dp[] = new int[N];
        int dp2[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            dp2[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (arr[N-i-1] > arr[N-j-1]) {
                    dp2[N-i-1] = Math.max(dp2[N-i-1], dp2[N-j-1] + 1);
                }
            }

        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i] + dp2[i]-1);
        }
        System.out.println(result);
    }
}