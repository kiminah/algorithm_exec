import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        // 1의 자리수부터 차례대로 합산
        while(n>0){
            answer += n%10;
            n/=10;
        }

        return answer;
    }
}