import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>(); // 다리를 건너는 트럭
        
        // 다리 길이만큼 0 추가
        for(int i=0; i<bridge_length-1; i++){
            bridge.add(0);
        }
        
        // 첫번째 트럭 다리에 진입
        int current_weight = truck_weights[0];
        bridge.add(current_weight);
        int idx = 1;
        answer = 1;
        
        // 다리가 비어 있을 때까지 반복
        while(!bridge.isEmpty()){
            // 시간 증가
            answer++;
            // 가장 먼저 들어간 트럭 빼기
            int truck = bridge.poll();
            // 뺀 트럭만큼 무게 감소
            current_weight -= truck;
            
            // 대기 트럭이 있으면 진행
            if(idx < truck_weights.length){
                // 현재 다리에 있는 트럭의 무게와 들어올 트럭의 무게의 합이
                // weight보다 작거나 같으면 들어올 트럭 다리에 추가
                if(current_weight+truck_weights[idx] <= weight){
                    bridge.add(truck_weights[idx]);
                    current_weight += truck_weights[idx++];
                }else{ // weight보다 크면 0 추가하여 다리를 건너는 트럭의 무게 변함 없음
                    bridge.add(0);
                }
            }
        }
        
        return answer;
    }
}