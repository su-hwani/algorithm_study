import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                System.out.println(1);
                continue;
            }
            if (a % 10 == 0) {
                System.out.println(10);
                continue;
            }
            int temp = 1;
            for (int i = 0; i < b; i++) {
                temp *= a;
                temp = temp % 10;
            }
            System.out.println(temp);
        }
    }
}