class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            // signs가 false면 음수이면
            // absolutes 값을 음수로 변경후 합산
            if(!signs[i]) absolutes[i] *= -1;
            answer += absolutes[i];
        }
        
        return answer;
    }
}