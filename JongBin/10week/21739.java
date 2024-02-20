import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static long mod = (int) Math.pow(10,9)+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i = 4; i<=N; i++){
            for(int j=0; j<i;j++){
                dp[i] += dp[j] *dp[i-j-1];
                dp[i] %= mod;
            }
        }
        System.out.println(dp[N]);
    }
}