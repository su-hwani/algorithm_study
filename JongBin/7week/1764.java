import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String input = br.readLine();
       String[] inputs = input.split(" ");
       int n = Integer.valueOf(inputs[0]);
       int m = Integer.valueOf(inputs[1]);

       // 2중 For문으로 하면 시간 초과가 발생
       // hashing을 이용해 값을 저장하는 hahs set을 사용. 빠르게 검색,삽입,삭제 가능
       HashSet<String> set = new HashSet<>();
       ArrayList<String> strList = new ArrayList<String>();
       for(int i = 0; i<n;i++){
           set.add(br.readLine());
       }
       for(int i = 0; i<m; i++){
           String str = br.readLine();
           if (set.contains(str)){
               strList.add(str);
           }
       }

       Collections.sort(strList);
       System.out.println(strList.size());
       for(String s : strList){
           System.out.println(s);
       }

   }
}