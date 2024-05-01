import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[][][] dp;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        while (a != 0) {
            arr.add(a);
            a = Integer.parseInt(st.nextToken());
        }
        dp = new int[5][5][arr.size()];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(solve(0, 0, 0));
    }

    static int solve(int left, int right, int cnt) {
        if (cnt == arr.size()) return 0;
        if (dp[left][right][cnt] != -1) return dp[left][right][cnt];
        dp[left][right][cnt] = Math.min(solve(arr.get(cnt), right, cnt + 1) + costCheck(left, arr.get(cnt)),
                solve(left, arr.get(cnt), cnt + 1) + costCheck(right, arr.get(cnt)));
        return dp[left][right][cnt];
    }

    public static int costCheck(int position, int order) {
        if (position == order) {
            return 1;
        }
        if (position == 0) {
            return 2;
        }
        if (position % 2 == order % 2) {
            return 4;
        }
        return 3;
    }

}

