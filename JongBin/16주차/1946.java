import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
            }
            int answer = 1;
            int min = arr[1];
            for (int i = 2; i <= N; i++) {
                if (arr[i] < min) {
                    answer++;
                    min = arr[i];
                }
            }
            System.out.println(answer);
        }
    }
}