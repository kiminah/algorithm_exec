class Solution {
    public String solution(int n) {
        String answer = "";
        String[] world = {"4","1","2"};
        
        int num = n;
        
        // 3으로 나눠지는 한 계속 반복
        while(num > 0){
            int na = num % 3;
            num /= 3;
            
            // 3의 배수인 경우 숫자를 1 감소시켜
            // 제대로된 값이 나오도록 설정
            if(na == 0) num--;
            
            // 제일 오른쪽 자리수부터 계산하기 때문에
            // 최근 계산 값을 왼쪽으로 오게 합산
            answer = world[na] + answer; 
            
        }
        
        return answer;
    }
}