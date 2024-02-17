import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stacks = new Stack[N];
        for(int i =0; i<N; i++){
            stacks[i] = new Stack<>();
        }
        int count = 0;
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(stacks[A].isEmpty() || stacks[A].peek()<B){
                //stack이 비었을때
            }else if(stacks[A].peek()>B){
                while(!stacks[A].isEmpty() && stacks[A].peek()>B){
                    stacks[A].pop();
                    count++;
                }
                if(!stacks[A].isEmpty() && stacks[A].peek() == B){
                    continue;
                }
            }else{
                continue;
            }
            stacks[A].push(B);

            count++;
        }
        System.out.println(count);
    }
}