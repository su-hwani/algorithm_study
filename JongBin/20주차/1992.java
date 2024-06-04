import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        divide(0, 0, N);
        System.out.println(sb);
    }

    public static void divide(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(arr[row][col]);
            return;
        }
        sb.append("(");
        int newSize = size / 2;
        divide(row, col, newSize);
        divide(row, col + newSize, newSize);
        divide(row + newSize, col, newSize);
        divide(row + newSize, col + newSize, newSize);
        sb.append(")");
    }

    public static boolean check(int row, int col, int size) {
        int temp = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (temp != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}