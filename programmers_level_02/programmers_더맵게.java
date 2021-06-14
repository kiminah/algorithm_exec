import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int cnt = 0; // 섞어야하는 최소 횟수
        int scov = 0; // 새로운 스코빌 지수
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // 1. 우선순위 큐 만들기
        boolean flag = false; // 모든 스코빌 지수가 K보다 작거나 같은 경우 확인
        for(int i=0; i<scoville.length; i++){
            heap.add(scoville[i]);
            if(scoville[i]<K) flag = true;
        }
        
        // 모든 스코빌 지수가 K보다 같거나 큰 경우 
        // 새로운 음식을 만들 필요가 없으므로 0 반환
        if(!flag) return 0;
        
        // 2. 스코빌 지수가 K 이상이 될 때까지 반복
        while(cnt<scoville.length-1){
            
            // 2-1. 스코빌 지수
            scov = heap.poll() + heap.poll()*2;
                        
            // 2-2. 새로운 스코빌 지수 추가
            cnt++;
            heap.add(scov);
            
            // 2-3. 최소값과 K 비교
            if(heap.peek()>=K){
                break;
            }
        }
        
        // 3. 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
        if(heap.peek() < K) cnt = -1;
        
        answer = cnt;
        return answer;
    }
}