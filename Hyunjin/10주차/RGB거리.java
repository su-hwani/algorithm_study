import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n+1][3];

        int[][] dp = new int[n+1][3];

        StringTokenizer st;
        for(int i  = 1; i<n+1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1000000;

        //첫집 색깔 고르기
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(i == j) dp[1][j] = cost[1][j];
                else dp[1][j] = 10000;
            }
            
            for(int k=2; k<n+1; k++){
                dp[k][0] = Math.min(dp[k-1][1], dp[k-1][2]) + cost[k][0];
                dp[k][1] = Math.min(dp[k-1][0], dp[k-1][2]) + cost[k][1];
                dp[k][2] = Math.min(dp[k-1][0], dp[k-1][1]) + cost[k][2];
                if(k==n) answer = Math.min(answer, Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
            }
        }

        System.out.println(answer);

    }
}