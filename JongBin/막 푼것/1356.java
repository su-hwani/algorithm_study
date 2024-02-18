import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] arr = new int[n.length()];
        for(int i = 0; i<n.length(); i++){
            arr[i] = Character.getNumericValue(n.charAt(i));
        }
        String answer = "NO";
        for(int i=1; i<n.length();i++){
            int a =1;
            int b =1;
            for(int j = 0; j< i; j++){
                a*=arr[j];
            }
            for(int j = i; j< n.length(); j++){
                b*=arr[j];
            }
            if(a == b){
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);


    }
}