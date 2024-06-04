class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] astonia = new boolean[1000001];
        for (int i = 2; i < 1000001; i++) {
            if (astonia[i]) {
                continue;
            }
            int j = 2;
            while (j * i < 1000001) {
                astonia[i * j] = true;
                j++;
            }
        }
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            boolean answer = false;
            for (int i = 2; i < N - 1; i++) {
                if (!astonia[i] && !astonia[N - i]) {
                    System.out.println(N + " = " + i + " + " + (N - i));
                    answer = true;
                    break;
                }
            }
            if (!answer) {
                System.out.println("Goldbach's conjecture is wrong.");
            }


        }
    }
}