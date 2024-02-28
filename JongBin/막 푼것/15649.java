import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static boolean[] visited;
    static int[] temp;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        temp = new int[M];
        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int n){
        if(n == M){
            for(int c : temp){
                sb.append(c).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                temp[n] = i+1;
                dfs(n+1);
                visited[i]=false;
            }
        }
    }
}