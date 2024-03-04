import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int cost;
    int destination;

    public Node(int cost, int destination) {
        this.cost = cost;
        this.destination = destination;
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}

class Main {
    public static ArrayList<Node>[] graph;
    public static int n, m;

    public static int[] distance, route;
    public static boolean[] visited;

    public static int sToi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = sToi(br.readLine());
        m = sToi(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = sToi(st.nextToken());
            int b = sToi(st.nextToken());
            int cost = sToi(st.nextToken());
            graph[a].add(new Node(cost, b));
        }
        st = new StringTokenizer(br.readLine());
        int start = sToi(st.nextToken());
        int end = sToi(st.nextToken());

        distance = new int[n + 1];
        Arrays.fill(distance, 100000000);
        visited = new boolean[n + 1];
        route = new int[n + 1];

        dijkstra(start);
        System.out.println(distance[end]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, start));
        route[start] = 0;
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visited[cur.destination]) {
                visited[cur.destination] = true;
                for (int i = 0; i < graph[cur.destination].size(); i++) {
                    Node next = graph[cur.destination].get(i);
                    if (distance[next.destination] > distance[cur.destination] + next.cost) {
                        distance[next.destination] = distance[cur.destination] + next.cost;
                        pq.offer(new Node(distance[next.destination], next.destination));
                        route[next.destination] = cur.destination;
                    }
                }

            }

        }
    }
}