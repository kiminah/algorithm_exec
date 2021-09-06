class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num; // 형변환
        // answer 500번 되면 -1 반환
        while(answer < 500){
            if(n == 1) break; // n이 1이 되면 반복문 종료
            // 짝수인 경우 2로 나누기
            // 홀수인 경우 3을 곱하고 1 더하기
            n = (n%2==0)? n/2 : (n*3)+1;
            answer++;
        }
        
        return (answer==500) ? -1 : answer;
    }
}