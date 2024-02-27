import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int n,m,dir,dist;
    public Node(int n, int m, int dir, int dist){
        this.n=n;
        this.m = m;
        this.dir = dir;
        this.dist = dist;
    }
}

class Main{
    public static int sToi(String s){
        return Integer.parseInt(s);
    }

    static char [][] map;
    static boolean[][][] directCheck;
    static final int[] dN = {-1, 0, 0, 1};
    static final int[] dM = {0, -1, 1, 0};
    static int M,N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = sToi(st.nextToken());
        M = sToi(st.nextToken());
        K = sToi(st.nextToken());
        map = new char[N][M];
        directCheck = new boolean[N][M][4];
        Node startPoint = null;
        for(int i = 0; i<N;i++){
            String line = br.readLine();
            for(int j = 0; j<M ;j++){
                map[i][j] = line.charAt(j);
                if(map[i][j]=='S'){
                    startPoint = new Node(i,j,-1,0);
                }
            }
        }
        Queue<Node> q= new ArrayDeque<>();
        q.add(startPoint);
        while(!q.isEmpty()){
            Node now = q.poll();
            if(map[now.n][now.m] == 'H'){
                System.out.println(now.dist);
                return;
            }
            for(int d = 0; d<4;d++){
                if (now.dir == d) continue; //바로 전 들어왔던곳은 체크안함
                int newn = now.n + dN[d];
                int newm = now.m + dM[d];
                if (newn < 0 || newn>=N || newm<0 || newm>=M || map[newn][newm] == 'X') continue;
                int newd = 3-d;
                int sum = sum(now.n, now.m, now.dir,newn,newm);
                if(sum>K || directCheck[newn][newm][newd]) continue;
                directCheck[newn][newm][newd] = true;
                q.add(new Node(newn,newm,newd, now.dist+1));
            }
        }
        System.out.println(-1);
    }
    public static int sum(int n, int m, int dir, int newn, int newm){
        int answer = getRisk(newn,newm);
        if(dir != -1) answer += getRisk(n+dN[dir],m+dM[dir]);
        return answer + getRisk(n,m);
    }

    public static int getRisk(int n,int m){
        char check = map[n][m];
        if (check == 'S' || check == 'H'){
            return 0;
        }
        return check - '0';
    }
}