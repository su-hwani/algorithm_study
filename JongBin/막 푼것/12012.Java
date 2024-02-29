import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {
    Map<Integer, List<Integer>> graph;

    public Graph(int num) {
        graph = new HashMap<>();
        for (int i = 1; i <= num; i++) {
            addVertex(i);
        }
    }

    public void addVertex(int vertex) {
        graph.put(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {

        graph.get(source).add(destination);
        graph.get(destination).add(source);

    }
}


class Main {
    public static Graph graph;
    public static int[] root;
    public static boolean[] isExist;

    public static int aToi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = aToi(st.nextToken());
        int M = aToi(st.nextToken());
        graph = new Graph(N);
        root = new int[N + 1];
        isExist = new boolean[N + 1];
        Arrays.fill(root, -1);
        Arrays.fill(isExist, false);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = aToi(st.nextToken());
            int b = aToi(st.nextToken());
            graph.addEdge(a, b);
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int node = aToi(br.readLine());
            stack.add(node);
        }

        int count = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            isExist[node] = true;
            if (root[node] == -1) {
                root[node] = node;
            }
            count++;
            for (int i : graph.graph.get(node)) {
                if (!isExist[i]) continue;
                if (i != node && find(i) != find(node)) {
                    union(node, i);
                    count--;
                }

            }
            if (count == 1) {
                outputStack.add(1);
            } else {
                outputStack.add(0);
            }
        }
        while (!outputStack.isEmpty()) {
            if (outputStack.pop() == 1) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }


    public static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        root[b] = a;
    }


}