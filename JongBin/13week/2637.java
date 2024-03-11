import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static ArrayList<Require>[] graph;
    static int[] inputRoot;
    static int[] require;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        inputRoot = new int[N + 1];
        require = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int require = Integer.parseInt(st.nextToken());
            graph[a].add(new Require(dir, require));
            inputRoot[dir]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        require[N] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                Require temp = graph[cur].get(i);
                require[temp.dir] += require[cur] * temp.require;
                inputRoot[temp.dir]--;
                if (inputRoot[temp.dir] == 0) {
                    q.offer(temp.dir);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            if (graph[i].isEmpty()) {
                sb.append(i).append(" ").append(require[i]).append("\n");
            }
        }
        System.out.println(sb);

    }
}

class Require {
    int dir, require;

    public Require(int dir, int require) {
        this.dir = dir;
        this.require = require;
    }
}