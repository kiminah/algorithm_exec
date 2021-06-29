import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.io.InputStreamReader;

public class backjoon_가운데를_말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 최소, 최대 힙
        // 가운데 값을 추출하기 위해 두 분류로 나눠서 저장
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1-o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
        
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            // 두 힙의 크기가 같은 경우 max힙부터 채운다
            if(minHeap.size() == maxHeap.size())  maxHeap.add(num);
            else minHeap.add(num);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                // 최소 힙보다 최대힙의 값이 큰경우 값을 swap
                if(minHeap.peek() < maxHeap.peek()){
                    int tmp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(tmp);
                }
            }
            sb.append(maxHeap.peek()+"\n");
        }
        System.out.print(sb);
    }
}