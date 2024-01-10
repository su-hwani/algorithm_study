import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;

        int plus = 1;
        int temp = 10;
        for (int i = 1; i<=num; i++ ){
            if (i % temp==0){
                plus += 1;
                temp *=10;
            }
            count +=plus;
        }

        System.out.println(count);
        scanner.close();
    }
}
