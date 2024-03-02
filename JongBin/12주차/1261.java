import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node{
    int x,y,count;
    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
class Main{
    static int[] moveX = {-1,0,1,0}; // 좌,상,우,하
    static int[] moveY = {0,1,0,-1};
    static int N,M;
    static Boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로

        map = new Boolean[N][M];

        for(int i =0 ;i<N; i++){
            String line = br.readLine();
            Arrays.fill(map[i],false);
            for(int j =0; j<M; j++){
                if (line.charAt(j) =='1') map[i][j] = true;
            }
        }
        System.out.println(bfs(0,0));


    }
    public static int bfs(int x, int y){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.count-o2.count;
            }
        });
        Boolean[][] visit = new Boolean[N][M];
        for(int i = 0 ;i<N;i++){
            Arrays.fill(visit[i],false);
        }
        pq.offer(new Node(x,y,0));
        visit[x][y] = true;
        int dx,dy;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.x == M-1 && node.y == N-1){
                return node.count;
            }
            for( int i =0; i<4; i++){
                dx = node.x+moveX[i];
                dy = node.y+moveY[i];

                if(dx<0 || dy<0 || dx>=M|| dy>=N){
                    continue;
                }
                int nextCnt = node.count;
                if(!visit[dy][dx]){
                    visit[dy][dx] = true;
                    if (map[dy][dx]) nextCnt++;
                    pq.offer(new Node(dx,dy,nextCnt));
                }
            }
        }
        return 0;
    }
}