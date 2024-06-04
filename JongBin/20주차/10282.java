import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Computer implements Comparable<Computer> {
    int depend;
    int time;

    public Computer(int depend, int time) {
        this.depend = depend;
        this.time = time;
    }

    @Override
    public int compareTo(Computer o) {
        return this.time - o.time;
    }
}

public class Main {
    static ArrayList<Computer>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list = new ArrayList[n + 1];
            dist = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                dist[i] = Integer.MAX_VALUE;
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list[b].add(new Computer(a, s));
            }
            dijstra(c);
            int count = 0;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    count++;
                    total = Math.max(total, dist[i]);
                }
            }
            System.out.println(count + " " + total);
        }

    }

    public static void dijstra(int start) {
        PriorityQueue<Computer> q = new PriorityQueue<>();
        dist[start] = 0;
        q.offer(new Computer(start, 0));
        while (!q.isEmpty()) {
            int cur = q.poll().depend;
            if (!visited[cur]) {
                visited[cur] = true;
                for (Computer next : list[cur]) {
                    if (dist[next.depend] > dist[cur] + next.time) {
                        dist[next.depend] = dist[cur] + next.time;
                        q.add(new Computer(next.depend, dist[next.depend]));
                    }
                }
            }
        }
    }
}