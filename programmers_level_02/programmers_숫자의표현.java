class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 1부터 연속되는 자연수들로 표현하는 방법 찾기
        for(int i=1; i<=n; i++)
            answer += solve(n,i);
        
        return answer;
    }
    
    public int solve(int n, int start){
        int sum = 0;
        
        // 시작 숫자부터 n까지 더한 값이 n인 경우 찾기
        for(int i=start; i<=n; i++){
            sum += i;
            
            // 1. 합이 n인 경우 1 리턴
            if(sum == n) return 1;
            
            // 2. 합이 n 이상인 경우 반복문 종료
            else if(sum > n) break;
            
        }
        return 0;
    }
}