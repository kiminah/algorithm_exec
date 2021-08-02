class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        // 1. N 번째 요금 계산
        for(int i=1; i<=count; i++){
            answer += price*i;
        }
        // 2. 필요한 놀이기구 이용금액
        answer -= money;
        
        if(answer<=0) return 0;
        return answer;
    }
}