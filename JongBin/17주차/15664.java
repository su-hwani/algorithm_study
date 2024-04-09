import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] answer = new int[M];
        search(0, 0, answer);

    }

    static public void search(int depth, int idx, int[] answer) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }
        int before = -1;
        for (int i = idx; i < N; i++) {
            if (arr[i] == before) {
                continue;
            }
            answer[depth] = arr[i];
            search(depth + 1, i + 1, answer);
            before = arr[i];
        }

    }
}