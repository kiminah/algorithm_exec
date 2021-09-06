class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = (long)num; // 형변환
        // answer 500번 되면 -1 반환
        while(answer < 500){
            if(n == 1) break; // n이 1이 되면 반복문 종료
            // 짝수인 경우 2로 나누기
            // 홀수인 경우 3을 곱하고 1 더하기
            n = (n%2==0)? n/2 : (n*3)+1;
            answer++;
        }
        return (answer==500) ? -1 : answer;

        /** 더 간결한 코드
        long n = (long)num;
        // 500번 반복
        for(int i=0; i<500; i++){
            if(n == 1) return i; // n이 1이 되는 순간 반복 횟수 리턴
            // n의 값 짝,홀수에 따라 변경
            n = (n%2==0)? n/2 : (n*3)+1;
        }
        // 반복문 500번 시도한 경우 -1 리턴
        return -1;
         */
    }
}