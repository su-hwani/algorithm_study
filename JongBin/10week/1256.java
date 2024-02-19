import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] dp = new int[101][101];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (check(N, M) < K) {
            System.out.println("-1");

        }else{
            find(N, M, K);
            System.out.println(sb.toString());
        }

    }

    public static int check(int n, int m) {
        if (n == 0 || m == 0) {
            return 1;
        }
        if (dp[n][m] != 0) return dp[n][m];

        return dp[n][m] = Integer.min(check(n - 1, m) + check(n, m - 1), 1000000001);
    }

    public static void find(int n, int m, int k) {
        if (n == 0) {
            for (int i = 0; i < m; i++) {
                sb.append("z");
            }
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return;
        }
        int check = check(n - 1, m);
        if (k > check) {
            sb.append("z");
            find(n, m - 1, k - check);
        } else {
            sb.append("a");
            find(n - 1, m, k);
        }
    }
}