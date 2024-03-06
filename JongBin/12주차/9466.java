import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static boolean[] visited, complete;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            complete = new boolean[n + 1];
            visited = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            for (int i = 1; i <= n; i++) {
                if (!complete[i]) dfs(i);
            }
            System.out.println(n - count);
        }
    }

    public static void dfs(int n) {

        if (visited[n]) {
            complete[n] = true;   
            count++;    
        } else {
            visited[n] = true;
        }

        if (!complete[arr[n]]) {
            dfs(arr[n]);
        }

        visited[n] = false;
        complete[n] = true;
    }
}