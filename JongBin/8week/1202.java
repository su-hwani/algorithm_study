import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Jewelry{
    int weight;
    int value;

    public Jewelry(int w, int v) {
        this.weight = w;
        this.value = v;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> jewl = new PriorityQueue<>(new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.weight == o2.weight) {
                    return o2.value - o1.value;
                }
                return o1.weight - o2.weight;
            }
        });
        PriorityQueue<Integer> bag = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewl.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(br.readLine());
            bag.offer(k);
        }
        long answer = 0;

        PriorityQueue<Integer> valueq = new PriorityQueue<>(Comparator.reverseOrder());
        while(!bag.isEmpty()){
            int bagpeek = bag.poll();
            while(!jewl.isEmpty() && jewl.peek().weight<=bagpeek){
                valueq.add(jewl.poll().value);
            }
            if(!valueq.isEmpty()){
                answer += valueq.poll();
            }
        }
        System.out.println(answer);
    }
}