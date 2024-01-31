import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Balloon {
    int num;
    int count;

    public Balloon(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            dq.addLast(new Balloon(i, n));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Balloon temp = dq.pollFirst();
            int num = temp.num;
            int count = temp.count;
            sb.append(num);
            sb.append(" ");
            if (dq.isEmpty()) break;
            if (count > 0) {
                for (int j = 1; j < count; j++) {
                    Balloon move = dq.pollFirst();
                    dq.addLast(move);
                }
            } else {
                for (int j = 0; j > count; j--) {
                    Balloon move = dq.pollLast();
                    dq.addFirst(move);
                }
            }

        }
        System.out.println(sb);
    }
}