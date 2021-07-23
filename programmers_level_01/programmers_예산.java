import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        // 1. 예산 오름차순 정렬
        Arrays.sort(d);
        // 2. 예산 순차적으로 감산
        for(int num : d){
            budget -= num;
            // 2-1. 예산이 음수가 되면 반복문 종료
            if(budget<0) break;
            // 2-2. 예산이 남으면 지원 가능 부서의 수 증가
            answer++;
        }
        
        return answer;
    }
    
}