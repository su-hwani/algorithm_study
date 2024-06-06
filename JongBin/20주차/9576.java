import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            PriorityQueue<Student> pq = new PriorityQueue<Student>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[a + 1];
            for (int i = 0; i < b; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                pq.add(new Student(start, end));
            }
            int answer = 0;
            while (!pq.isEmpty()) {
                Student cur = pq.poll();
                for (int i = cur.start; i <= cur.end; i++) {
                    if (!visit[i]) {
                        answer++;
                        visit[i] = true;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }

    }
}

class Student implements Comparable<Student> {
    int start, end;

    public Student(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Student o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}