import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Main{
    //처음은 우선순위 큐 하나에 넣고 가운데 요소만 출력하고 싶었으나, index 개념이 없어서 실패
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(minheap.size() == maxheap.size()){
                maxheap.offer(num);
            }else{
                minheap.offer(num);
            }
            if(!minheap.isEmpty() && !maxheap.isEmpty()){
                if(minheap.peek()< maxheap.peek()){
                    int temp = minheap.poll();
                    minheap.offer(maxheap.poll());
                    maxheap.offer(temp);
                }
            }
            sb.append(maxheap.peek() + "\n");
        }
        System.out.println(sb);
    }
}