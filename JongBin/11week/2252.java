import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        int[] inputCount = new int[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0 ;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            //진입차수 구하기
            inputCount[B]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for( int i =1 ; i<=N;i++){
            if(inputCount[i]==0){
                queue.add(i);
                inputCount[i]--;
                sb.append(i).append(" ");
            }
        }
        while(!queue.isEmpty()){
            int point = queue.poll();
            ArrayList<Integer> temp = graph[point];
            if (temp.isEmpty()){
                continue;
            }
            for (Integer integer : temp) {
                inputCount[integer]--;
                if (inputCount[integer]==0){
                    queue.add(integer);
                    sb.append(integer).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}