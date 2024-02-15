import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        int[] dp = new int[N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[i][0] = A;
            arr[i][1] = B;
        }
        Arrays.sort(arr, Comparator.comparingInt(ar->ar[0]));


        for(int i=0; i<N;i++){
            dp[i] = 1;
            for(int j = 0; j<i;j++){
                if(arr[i][1]>arr[j][1]){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int temp = Arrays.stream(dp).max().getAsInt();


        System.out.println(N-temp);
    }
}