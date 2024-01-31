import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String sid = br.readLine();
            if (set.contains(sid)) {
                set.remove(sid);
            }
            set.add(sid);
        }
        int count =0;
        for (String s : set){
            if(count == K){
                break;
            }
            count++;
            System.out.println(s);
        }

    }
}