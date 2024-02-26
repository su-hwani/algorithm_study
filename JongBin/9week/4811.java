import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// todo :다시 풀어보기
class Main {
    public static int aToi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[31][31];
        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= 30; j++) {
                if(i>j) continue;
                if(i==0) {
                    dp[i][j] =1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int i = 0; i < 1000; i++) {
            int N = aToi(br.readLine());
            if (N == 0) break;
            System.out.println(dp[N][N]);
        }
    }
}