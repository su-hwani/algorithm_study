import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(Integer.valueOf(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            if (hashSet.contains(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append('\n');
                continue;
            }
            sb.append(0).append('\n');
        }
        System.out.println(sb);
    }
}