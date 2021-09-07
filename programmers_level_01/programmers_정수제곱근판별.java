class Solution {
    public long solution(long n) {
        // 1. 정수 i의 제곱이 n이 될때까지 반복
        //    i의 제곱이 n이 되면 i+1의 제곱 반환
        for(long i=1; i*i<=n; i++){
            if(i*i == n) return (i+1)*(i+1);
        }
        // 2. 제곱이 아닌 경우 -1 반환
        return -1;

        /** 효율성 높은 코드
            // 1. 주어진 수 n의 제곱근을 제곱했을 때 n이 나오는 경우
            //    주어진 수 n의 제곱근 + 1의 제곱수 리턴
            if(Math.pow((int)Math.sqrt(n),2)==n){
                return (long)Math.pow(Math.sqrt(n)+1,2);
            }
        
            // 2. 제곱이 아닌경우 -1 반환
            return -1;

         */
    }
}