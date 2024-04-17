import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Stone> list = new ArrayList<>();
        list.add(new Stone(0, 0, 0, 0));
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Stone(i + 1, width, height, weight));
        }
        Collections.sort(list);
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i).width > list.get(j).width) {
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).height);
                }
            }
        }
        int max = -1;
        for (int d : dp) {
            if (max < d) max = d;
        }
        int index = N;
        ArrayList<Integer> result = new ArrayList<>();
        while (index != 0) {
            if (max == dp[index]) {
                result.add(list.get(index).id);
                max -= list.get(index).height;
            }
            index--;
        }
        System.out.println(result.size());
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }
}

class Stone implements Comparable<Stone> {
    int id, width, height, weight;

    public Stone(int id, int area, int height, int weight) {
        this.id = id;
        this.width = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Stone o) {
        return this.weight - o.weight;
    }
}