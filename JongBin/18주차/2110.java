import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = 1;
        int max = arr[N - 1] - arr[0] + 1;
        int anwser = 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (installCheck(mid) < C) {
                max = mid;
                continue;
            }
            min = mid+1;
        }
        System.out.println(min-1);
    }

    private static int installCheck(int mid) {
        int count=1;
        int temp = arr[0];
        for(int i =1;i<N;i++){
            int locate= arr[i];
            if(locate-temp>=mid){
                count++;
                temp = locate;
            }
        }
        return count;
    }


}