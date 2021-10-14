class Solution {
    public int solution(int n) {
        // 나눈 나머지가 1을 만족하는 작은 자연수가 없는 경우
        // 나머지 1을 만족하는 가장 가까운 자연수 n-1 로 지정
        int answer = n-1; 
        
        // 나머지가 1이 되는 수를 발견한 경우 해당 값 반환
        // 나머지가 1이 되는 약수만 찾으면 되기 때문에
        // n/2 까지만 반복
        for(int i=2; i<=n/2; i++){
            if(n%i == 1) return i;
        }
        
        return answer;
    }
}