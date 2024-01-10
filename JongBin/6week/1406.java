import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            stack.push(line.charAt(i));
        }
        int m = Integer.parseInt(br.readLine());


        for (int i = 0; i < m; i++) {
            String operation = br.readLine();
            char o = operation.charAt(0);

            if (o == 'L') {
                if (!stack.isEmpty()) {
                    stack1.push(stack.pop());
                }
            } else if (o == 'D') {
                if (!stack1.isEmpty()) {
                    stack.push(stack1.pop());
                }
            } else if (o == 'B') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(operation.charAt(2));
            }
        }

        while (!stack1.isEmpty()) {
            stack.push(stack1.pop());
        }

        for (int i = 0; i < stack.size(); i++) {
            bw.write(stack.get(i));
        }

        bw.flush();
        bw.close();
    }
}