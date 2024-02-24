import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    static int stoi(String string){
        return Integer.parseInt(string);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int Q = stoi(st.nextToken());

        int[] root = new int[N+1];
        Arrays.fill(root,-1);

        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] {0,0});

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{stoi(st.nextToken()),stoi(st.nextToken())});
        }

        boolean[] visited = new boolean[M+1];
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<Q; i++){
            int query = stoi(br.readLine());
            stack.add(query);
            visited[query] = true;
        }
        for(int i = 1; i<=M;i++){
            if(!visited[i]){
                int [] temp = list.get(i);
                union(temp[0],temp[1],root);
            }
        }
        long answer = 0;

        for(int i=0; i<Q; i++){
            int query = stack.pop();
            int[] input = list.get(query);

            int x = find(input[0],root);
            int y = find(input[1],root);
            if (x!=y){
                answer += (long) root[x] *root[y];
            }
            union(x,y,root);
        }
        System.out.println(answer);
    }
    public static void union(int a, int b, int[] root){
        a = find(a,root);
        b = find(b,root);
        if(a==b) return;

        root[a]+=root[b];
        root[b] = a;
    }

    public static int find(int a,  int[] root){
        if(root[a]<0) return a;
        return root[a] = find(root[a], root);
    }
}