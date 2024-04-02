import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //접시 수
        int d = Integer.parseInt(st.nextToken()); //초밥 종류 수
        int k = Integer.parseInt(st.nextToken()); //먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
        int[] dish = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            dish[i] = cur;
            list.add(cur);
        }
        for (int i = 0; i < k; i++) {
            list.add(dish[i]);
        }
        int front = 0;
        int back = k - 1;
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> seq = new ArrayList<>();
        for (int i = front; i <= back; i++) {
            set.add(list.get(i));
            seq.add(list.get(i));
        }
        while (true) {
            if (set.contains(c)) {
                max = Math.max(max, set.size());
            } else {
                max = Math.max(max, set.size() + 1);
            }
            front++;
            back++;
            seq.add(list.get(back));
            seq.remove(list.get(front - 1));
            set = new HashSet<>(seq);
            if (back == list.size() - 1) {
                break;
            }
        }

        System.out.println(max);
    }

}