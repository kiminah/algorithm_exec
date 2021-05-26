import java.util.*;
class Solution {
    Map<Integer, Double> map;
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 스테이지 - 실패율 저장
        map = new HashMap<>();
        
        // i : 스테이지 1~N
        // j : 사용자가 현재 도전 중인 스테이지
        for(int i=1; i<=N; i++){
            int total = 0;
            int cnt  = 0;
            for(int j=0; j<stages.length; j++){
                // 해당 스테이지에 도달했으나 아직 클리어하지 못한 플레이어
                if(stages[j]==i){
                    cnt++;
                    total++;
                }
                // 해당 스테이지에 도달한 플레이어
                else if(stages[j]>i) total++;
            }
            // 실패율
            double result = (double)cnt/total;
            if(cnt==0) result = 0; // 스테이지에 도달한 유저가 없는 경우
            map.put(i, result);
        }
        
        // 실패율을 내림차순으로 저장
        List<Double> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());
        // answer에 저장하기 위한 index
        int idx = 0;
        // 내림차순으로 정렬한 실패율 추출
        for (Double value : valueList) {
            // 해당 실패율에 맞는 key값 추출
            for(Integer key : map.keySet()){
                // 해당 실패율과 현재 key의 value값이 일치하면
                // answer에 저장
                if(map.get(key)==value){
                    answer[idx] = key;
                    idx++;
                }
            }
        }
        return answer;
    }
}