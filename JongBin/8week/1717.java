import java.io.*;
import java.util.StringTokenizer;

class Main{
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (order == 0){
                union(a,b);
            }else if (order == 1){
                sb.append((find(a,b) ? "YES" : "NO") +"\n");
            }else{
                continue;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int util(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = util(parent[x]);
    }
    public static void union(int x, int y){
        x = util(x);
        y = util(y);
        if(x!=y){
            if (x<y){
                parent[y] = x;
            }else {
                parent[x] = y;
            }
        }
    }
    public static boolean find(int x, int y){
        x = util(x);
        y = util(y);
        if( x== y ){
            return true;
        }
        return false;
    }
}