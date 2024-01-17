import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack= new Stack<>();
        int result = 0;
        for(int i=0; i<input.length();i++){
            char temp = input.charAt(i);
            if(temp == '('){
                stack.push('(');
            }else if(temp == ')'){
                stack.pop();
                if (input.charAt(i-1) == '('){
                    result += stack.size();
                }else{
                    result ++;
                }
            }

        }
        System.out.println(result);
    }
}