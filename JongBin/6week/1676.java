import java.util.Scanner;

// 5만 없으면 0이 안생김. 5의 갯수만 찾으면 된다.
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;

        while (num >= 5){
            num /= 5;
            count += num;

        }
        System.out.println(count);
        scanner.close();
    }
}
