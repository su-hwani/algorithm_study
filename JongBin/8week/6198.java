import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int building = Integer.parseInt(br.readLine());
            // stack 이 비었을때는 Pass
            if (st.isEmpty()) {
                st.add(building);
                continue;
            }
            //stack이 비지않았고 stack의 꼭대기에 있는 building이 새로들어오는 building의 크기보다 작거나같을때 stack에서 제거
            //새로들어오는애보다 낮은 building은 어쩌피 들어오는 building들을 못봄
            while(!st.isEmpty() && st.peek()<=building){
                    st.pop();
            }
            //stack에 있는 애들은 새로 들어오는 building을 볼수있는 building들
            answer +=st.size();
            st.add(building);
        }
        System.out.println(answer);
    }
}