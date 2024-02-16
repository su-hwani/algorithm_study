import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Timetable {
    int start;
    int end;

    Timetable(int start, int end) {
        this.start = start;
        this.end = end;

    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Timetable[] timetable = new Timetable[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            timetable[i] = new Timetable(start, end);
        }
        Arrays.sort(timetable, (t1,t2) -> t1.start == t2.start ? t1.end-t2.end : t1.start - t2.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(timetable[0].end);

        for(int i=1; i<N; i++){
            if (pq.peek() <= timetable[i].start){
                pq.poll();
            }
            pq.offer(timetable[i].end);
        }
        System.out.println(pq.size());
    }
}