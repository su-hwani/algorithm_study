import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        long answer = 0;

        //0 1 2 3 4
        // 1 2 3 4 0
        for (int i = 0; i < input.length(); i++) {
            answer += Integer.parseInt(input);
            char temp = input.charAt(0);
            String a = input.concat(String.valueOf(temp));
            a = a.replaceFirst(String.valueOf(temp), " ");
            input = a.trim();
        }
        System.out.println(answer);
    }
}