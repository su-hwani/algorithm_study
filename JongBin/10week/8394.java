import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    /*
    1 = 1
    2 = 2
    3 = 3
    4 = 5
    5 = 8
     => 피보나치 수열이다

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3 ; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10;
        }
        System.out.println(dp[N]);

    }
}