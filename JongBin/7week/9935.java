import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String boom = br.readLine();

        int stringLength = string.length();
        int boomLength = boom.length();

        Stack<Character> stack= new Stack<>();

        for (int i = 0 ; i<stringLength; i++){
            stack.push(string.charAt(i));
            //스택의 사이즈가 boom의 길이보다 클떄 동작
            int stackSize = stack.size();
            if (stackSize>=boomLength){
                boolean check = true;
                for(int j =0 ; j <boomLength; j++){
                    if (stack.get(stackSize - boomLength + j ) != boom.charAt(j)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    for(int k = 0; k<boomLength; k++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }
        System.out.println(sb.length()>0? sb.toString() : "FRULA");
    }
}