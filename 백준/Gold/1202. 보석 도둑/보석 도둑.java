import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), K = sc.nextInt();
        
        int[][] items = new int[N][2];

        for (int i = 0; i < N; i++) {
            int M = sc.nextInt(), V = sc.nextInt();
            items[i][0] = M;
            items[i][1] = V;
        }

        int[] bags = new int[K];

        

        long answer = 0;
        
        for (int i = 0; i < K; i++) {
            int C = sc.nextInt();
            bags[i] = C;
        }

        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int index = 0;
        for (int bag : bags) {
            while (index < N && items[index][0] <= bag) {
                pq.add(items[index][1]);
                index++;
            }

            if (!pq.isEmpty()) {
                answer += pq.remove();
            }
        }


        System.out.println(answer);
    }
}


// 2 1 
// 5 10 
// 100 100 
// 11