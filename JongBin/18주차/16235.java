import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int[][] s2d2;
    static int[][] map;
    static PriorityQueue<Tree> tree;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        s2d2 = new int[N][N];
        map = new int[N][N];
        tree = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                s2d2[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            tree.add(new Tree(x, y, z));
        }
        for (int k = 0; k < K; k++) {
            //spring,
            PriorityQueue<Tree> newTree = new PriorityQueue<>();
            ArrayList<Tree> dead = new ArrayList<>();
            ArrayList<Tree> s = new ArrayList<>();
            while (!tree.isEmpty()) {
                Tree cur = tree.poll();
                if (map[cur.x][cur.y] >= cur.age) {
                    map[cur.x][cur.y] -= cur.age;
                    Tree addTree = new Tree(cur.x, cur.y, cur.age + 1);
                    newTree.add(addTree);
                    if (addTree.age % 5 == 0) {
                        s.add(addTree);
                    }
                } else {
                    dead.add(cur);
                }
            }
            tree = newTree;
            //summer
            for (Tree cur : dead) {
                map[cur.x][cur.y] += cur.age / 2;
            }


            for (Tree cur : s) {
                for (int i = 0; i < 8; i++) {
                    int newX = cur.x + dx[i];
                    int newY = cur.y + dy[i];
                    if (newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
                    tree.add(new Tree(newX, newY, 1));
                }
            }
            //winter
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] += s2d2[i][j];
                }
            }
        }
        System.out.println(tree.size());
    }
}

class Tree implements Comparable<Tree> {
    int x;
    int y;
    int age;

    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }


    @Override
    public int compareTo(Tree o) {
        return age - o.age;
    }
}