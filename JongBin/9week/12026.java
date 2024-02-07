import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long dp[] = new long[N];
        String st = br.readLine();
        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < N; i++) {
            if (st.charAt(i) == 'J') {
                for (int j = i - 1; j >= 0; j--) {
                    long temp = dp[j] + (j - i) * (j - i);
                    if (st.charAt(j) == 'O' && dp[i] > temp) {
                        dp[i] = temp;
                    }
                }
            }
            if (st.charAt(i) == 'B') {
                for (int j = i - 1; j >= 0; j--) {
                    long temp = dp[j] + (j - i) * (j - i);
                    if (st.charAt(j) == 'J' && dp[i] > temp) {
                        dp[i] = temp;
                    }
                }
            }
            if (st.charAt(i) == 'O') {
                for (int j = i - 1; j >= 0; j--) {
                    long temp = dp[j] + (j - i) * (j - i);
                    if (st.charAt(j) == 'B' && dp[i] > temp) {
                        dp[i] = temp;
                    }
                }
            }
        }
        long answer = dp[N-1] == Integer.MAX_VALUE ?  -1 : dp[N-1] ;
        System.out.println(answer);

    }
}