import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        PriorityQueue<Jongbin> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Jongbin(a, b));
        }
        int max = 0;
        while (!pq.isEmpty()) {
            Jongbin cur = pq.poll();
            if (max > cur.b) {
                continue;
            }
            int a = arr[cur.a];
            int start = Math.max(cur.a, max);
            max = cur.b;
            for (int i = start; i <= cur.b; i++) {
                arr[i] = a;
            }

        }

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (i == arr[i]) answer++;
        }
        System.out.println(answer);
    }

    static class Jongbin implements Comparable<Jongbin> {
        int a, b;

        public Jongbin(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Jongbin o) {
            if (a == o.a) {
                return o.b - b;
            }
            return a - o.a;
        }
    }


}