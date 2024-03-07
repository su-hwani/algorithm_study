import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int dir, weight;

    public Node(int dir, int weight) {
        this.dir = dir;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        LinkedList<Node>[] graph = new LinkedList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }
        boolean[] visit = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        long weight = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (visit[n.dir]) continue;
            visit[n.dir] = true;
            weight += n.weight;
            LinkedList<Node> temp = graph[n.dir];
            for (Node node : temp) {
                if (!visit[node.dir]) pq.add(node);
            }
        }
        System.out.println(weight);
    }
}