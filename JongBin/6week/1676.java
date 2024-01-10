import java.util.Scanner;

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
