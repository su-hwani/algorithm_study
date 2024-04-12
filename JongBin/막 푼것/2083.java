import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (name.equals("#")) {
                break;
            }
            String answer;
            if (age > 17 || weight >= 80) {
                answer = "Senior";
            } else {
                answer = "Junior";
            }
            System.out.println(name + " " + answer);
        }
    }
}