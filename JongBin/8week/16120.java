import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);

            if (st.size() >= 3 && temp == 'P' && st.peek() == 'A') {
                StringBuilder stb = new StringBuilder();
                for (int re = 0; re < 3; re++) {
                    stb.append(st.pop());
                }
                if (!stb.toString().equals("APP")) {
                    for (int re = 2; re >= 0; re--) {
                        st.add(stb.charAt(re));
                    }
                }

            }
            st.add(temp);
        }
        while (st.size()>=4 && st.peek()=='P'){
            StringBuilder stb = new StringBuilder();
            for (int re = 0; re < 4; re++) {
                stb.append(st.pop());
            }
            if (!stb.toString().equals("PAPP")) {
                for (int re = 3; re >= 1; re--) {
                    st.add(stb.charAt(re));
                }
                break;
            }
            st.add('P');
        }

        if (st.size() == 1 && st.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}