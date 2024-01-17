import java.io.*;
import java.util.StringTokenizer;

class Main {
    // https://loosie.tistory.com/273?category=972195 세그먼트 트리 설명
    // 처음엔 우선순위 큐로 풀려고 했으나, M번 우선순위큐를 만들면 비효율적이였음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer testCase = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(testCase.nextToken());
        int m = Integer.parseInt(testCase.nextToken());


        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = Integer.parseInt(br.readLine());
        }

        int[] minSegmentTree = new int[n * 4];
        int[] maxSegmentTree = new int[n * 4];

        init (elements, minSegmentTree, 1,0,n-1, "min");
        init (elements, maxSegmentTree, 1,0,n-1, "max");

        for(int i =0; i<m;i++){
            StringTokenizer maxmin = new StringTokenizer(br.readLine());
            // 문제에서는 index가 1부터 시작해서 -1해야함
            int left = Integer.parseInt(maxmin.nextToken())-1;
            int right = Integer.parseInt(maxmin.nextToken())-1;

            int minValue = getValue(minSegmentTree,1,0,n-1,left,right,"min");
            int maxValue = getValue(maxSegmentTree,1,0,n-1,left,right,"max");
            bw.write(minValue+" "+maxValue);
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();

    }

    // 세그먼트 트리 초기화
    public static int init(int[] arr, int[] segmentTree, int node, int start, int end, String minOrMax) {
        //끝부분에 도달하면(리프노드) 배열의 값 저장
        if (start == end) {
            return segmentTree[node] = arr[start];
        } else {
            int leftNodeValue = init(arr, segmentTree, node * 2, start, (start + end) / 2, minOrMax);
            int rightNodeValue = init(arr, segmentTree, node * 2 + 1, (start + end) / 2 + 1, end, minOrMax);
            // 조건에 따라서 노드에 값 저장
            if (minOrMax.equals("min")) {
                return segmentTree[node] = Math.min(leftNodeValue, rightNodeValue);
            } else {
                return segmentTree[node] = Math.max(leftNodeValue, rightNodeValue);
            }
        }
    }

    public static int getValue(int[] segmentTree, int node, int start, int end, int left, int right, String minOrMax) {
        if (end < left || right < start) {
            if (minOrMax.equals("min")) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (left <= start && end <= right){
            return segmentTree[node];
        }else{
            int leftNodeValue = getValue(segmentTree,node*2, start,(start+end)/2,left,right,minOrMax);
            int rightNodeValue = getValue(segmentTree,node*2+1, (start+end)/2+1,end,left,right,minOrMax);
            if(minOrMax.equals("min")){
                return Math.min(leftNodeValue, rightNodeValue);
            }else{
                return Math.max(leftNodeValue,rightNodeValue);
            }
        }
    }
}