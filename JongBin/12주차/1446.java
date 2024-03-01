import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Road{
    int start,end,distance;
    public Road(int s, int e, int d){
        this.start=s;
        this.end = e;
        this.distance = d;
    }
}
class Main{
    static int sToi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = sToi(st.nextToken());
        int D = sToi(st.nextToken());
        int[] distance = new int[D+1];
        Arrays.fill(distance,10001);
        List<Road> road = new ArrayList<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = sToi(st.nextToken());
            int e = sToi(st.nextToken());
            int d = sToi(st.nextToken());
            if(e>D || e-s<=d){
                continue;
            }
            road.add(new Road(s,e,d));
        }
        road.sort(new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                if(o1.start==o2.start) return o1.end-o2.end;
                return o1.start-o2.start;
            }
        });

        int arrayIdx =0;
        int location =0;
        distance[0] = 0;
        while (location<D){
            if(arrayIdx<road.size()){
                Road r = road.get(arrayIdx);
                if(r.start == location){
                    distance[r.end] = Math.min(distance[r.end],distance[location]+r.distance);
                    arrayIdx++;
                    continue;
                }
            }
            distance[location+1] = Math.min(distance[location+1],distance[location]+1);
            location++;
        }
        System.out.println(distance[D]);
    }
}