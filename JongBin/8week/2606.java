import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        Boolean[] visited = new Boolean[N+1];
        for(int i=0; i<=N ;i++){
            visited[i] = false;
            for(int j=0; j<=N; j++){
                arr[i][j]=0;
            }
        }

        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1,arr,visited);
        System.out.println(count);
    }
    public static void dfs(int start, int[][] arr, Boolean[] visited){
        visited[start] = true;
        for(int j=1; j<arr[0].length; j++){
            if(arr[start][j] == 1 && visited[j] == false){
                count++;
                dfs(j,arr,visited);
            }
        }
    }
}