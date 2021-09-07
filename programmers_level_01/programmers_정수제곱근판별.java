class Solution {
    public long solution(long n) {
        // 1. 정수 i의 제곱이 n이 될때까지 반복
        //    i의 제곱이 n이 되면 i+1의 제곱 반환
        for(long i=1; i*i<=n; i++){
            if(i*i == n) return (i+1)*(i+1);
        }
        // 2. 제곱이 아닌 경우 -1 반환
        return -1;
    }
}