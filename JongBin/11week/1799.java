import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static boolean[][] map;
    static int[][] visit;
    static int N;
    static int[] answer = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        visit = new int[N+2][N+2];
        StringTokenizer st;
        for (int i =0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                if(st.nextToken().equals("1")){
                    map[i][j] = true;
                    continue;
                }
                map[i][j] = false;
            }

        }
        dfs(0,0,0,0);
        dfs(0,1,0,1);
        System.out.println(answer[0]+answer[1]);
    }
    public static void dfs(int row, int col, int count ,int color){
        if(col>= N){
            row++;
            if(col%2 == 0) col =1;
            else col =0;
        }

        if (row>=N){
            answer[color] = Integer.max(answer[color], count);
            return;
        }
        // 기본 0
        // 현위치에 체크 1
        // \대각선방향으로 있으면 2
        // /대각선 방향으로 있으면 3
        // 둘다있으면 5
        int leftUp = visit[row][col];
        int rightUp = visit[row][col+2];
        if (map[row][col] && (leftUp==0 || leftUp==3) && (rightUp==2 || rightUp==0)){
            //대각선 둘다 없으니 현위치 체크
            visit[row+1][col+1] = 1;
            dfs(row,col+2,count+1, color);
            visit[row+1][col+1] = 0;
        }
        if(leftUp ==1 || leftUp ==2 || leftUp ==5){
            visit[row+1][col+1] = 2;
        }
        if(rightUp ==1 || rightUp ==3 || rightUp ==5){
            visit[row+1][col+1] = 3;
        }
        if(!(rightUp==0 || rightUp ==2) && !(leftUp==0 || leftUp == 3)){
            visit[row+1][col+1] = 5;
        }
        dfs(row,col+2,count,color);
        visit[row+1][col+1] = 0;
    }
}