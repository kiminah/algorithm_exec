import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 1. 정렬
        Arrays.sort(citations);
        
        // 2. h번 이상 인용된 논문의 수
        for(int h=1; h<=citations.length; h++){
            int cnt = 0; // 논문의 수
            for(int i=0; i<citations.length; i++){
                if(h<=citations[i]) cnt++;
            }
            // 2-1. h번 이상 인용된 논문이 h편 이상인 경우
            if(h<=cnt){
                answer = h; // h의 최대값
            }
        }
        
        return answer;
    }
}