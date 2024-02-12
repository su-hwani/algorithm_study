import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        //첫째줄은 그냥 복사
        System.arraycopy(arr[0], 0, dp[0], 0, 3);

        //해당 집의 윗집(윗줄)에서 안겹치는 색깔 중 가장 비용이 적은 집을 선택해 본인집의 해당 색을 칠하는 최소 비용을 구해놓음
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
                } else if (j == 1) {
                    dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
                } else {
                    dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+arr[i][2];
                }
            }
        }

        int answer = Arrays.stream(dp[N-1]).min().getAsInt();
        System.out.println(answer);
    }
}