import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Msg implements Comparable<Msg>{
    int num, idx, cnt;
    public Msg(int num, int idx, int cnt){
        this.num = num;
        this.idx = idx;
        this.cnt = cnt;
    }
    public void plus(){
        this.cnt++;
    }

    @Override
    public int compareTo(Msg o) {
        if (this.cnt == o.cnt){
            return this.idx-o.idx;
        }
        return o.cnt - this.cnt;
    }
}
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        HashMap<Integer,Msg> hm= new HashMap<>();
        ArrayList<Msg> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<N; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(!hm.containsKey(temp)){
                Msg msg = new Msg(temp, i , 0);
                hm.put(temp,msg);
                list.add(msg);
            }
            hm.get(temp).plus();
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<list.size();i++){
            Msg tmp = list.get(i);
            int num = tmp.num;
            int cnt = tmp.cnt;
            while (cnt-->0){
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb);

    }
}