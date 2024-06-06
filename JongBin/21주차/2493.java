import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int record = 0;
            while (!stack.isEmpty()) {
                if (stack.peek().height < cur) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                record = stack.peek().num;
            }
            sb.append(record).append(" ");
            stack.push(new Node(i, cur));
        }
        System.out.println(sb);

    }
}

class Node {
    int num, height;

    public Node(int num, int height) {
        this.num = num;
        this.height = height;
    }
}