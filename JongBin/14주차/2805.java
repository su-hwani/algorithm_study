import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        int min = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(tree[i], max);
        }
        while (min <= max) {
            int mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) sum += tree[i] - mid;
            }
            if (sum >= M) {
                min = mid + 1;
                continue;
            }
            max = mid - 1;
        }
        System.out.println(max);
    }
}