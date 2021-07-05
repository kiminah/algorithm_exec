class Solution {
    public int solution(int n) {
        int answer = 0;
        // 1. 현재 숫자의 1의 개수
        int cnt = Integer.bitCount(n);
        
        // 2. 다음 숫자의 1의 개수와 비교
        //    같은 개수가 나올 때까지 반복
        while(Integer.bitCount(++n) != cnt){}
        
        return n;
    }
}