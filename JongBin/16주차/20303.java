import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int cost;
    int value;

    public Node(int cost, int value) {
        this.cost = cost;
        this.value = value;
    }
}

class Main {
    static int[] parent;
    static int[] candies;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        candies = new int[N + 1];
        parent = new int[N + 1];
        count = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
            count[i] = 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        sumsum(N);
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) {
                list.add(new Node(count[i], candies[i]));
            }

        }
        int[][] dp = new int[list.size() + 1][K]; // 세로 : 가로 : 무게,
        for (int i = 1; i <= list.size(); i++) {
            for (int j = 0; j < K; j++) {
                if (list.get(i - 1).cost <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list.get(i - 1).cost] + list.get(i - 1).value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        System.out.println(dp[list.size()][K - 1]);
    }

    public static void sumsum(int N) {
        for (int i = 1; i <= N; i++) {
            if (parent[i] != i) {
                int p = find(i);
                candies[p] += candies[i];
                count[p] += count[i];
            }
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}