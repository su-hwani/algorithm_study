import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i =0; i<N ;i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            if(map.containsKey(name)){
                map.remove(name);
            }else if(status.equals("enter")){
                map.put(name,1);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> curList = new ArrayList<>(map.keySet());
        Collections.sort(curList,(a,b) -> b.compareTo(a));
        for(String s : curList){
            sb.append(s+"\n");
        }
        System.out.println(sb.toString());
    }
}