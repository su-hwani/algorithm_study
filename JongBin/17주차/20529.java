import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static Map<String, Integer> MBTI = new HashMap<>();
    static String[] MBTIS = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < 16; i++) {
            MBTI.put(MBTIS[i], i);
        }
        int[] count;
        while (T-- > 0) {
            int answer = 12;
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            count = new int[16];
            boolean breakCheck = false;
            for (int i = 0; i < N; i++) {
                String cur = st.nextToken();
                int index = MBTI.get(cur);
                if (++count[index] >= 3) {
                    breakCheck = true;
                    break;
                }
            }
            if (breakCheck) {
                System.out.println(0);
                continue;
            }
            for (int i = 0; i < 16; i++) {
                if (count[i] == 0) {
                    continue;
                }
                String a = MBTIS[i];
                for (int j = i; j < 16; j++) {
                    if (count[j] == 0) {
                        continue;
                    }
                    if (i == j && count[j] < 2) {
                        continue;
                    }
                    String b = MBTIS[j];
                    for (int k = j; k < 16; k++) {
                        if (count[k] == 0) {
                            continue;
                        }
                        if (i == j && j == k) continue;
                        if (j == k && count[k] < 2) {
                            continue;
                        }
                        String c = MBTIS[k];
                        int tempAnwser = 0;
                        for (int C = 0; C < 4; C++) {
                            if (a.charAt(C) != b.charAt(C)) tempAnwser++;
                            if (c.charAt(C) != b.charAt(C)) tempAnwser++;
                            if (a.charAt(C) != c.charAt(C)) tempAnwser++;
                        }
                        answer = Math.min(tempAnwser, answer);
                    }
                }
            }
            System.out.println(answer);
        }

    }
}