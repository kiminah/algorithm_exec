import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // 처음위치 0이 될 때까지 반복
        while(n!=0){
            // 1. 홀수의 경우 1칸 이동 및 건전지 사용
            if(n%2 !=0){
                ans++;
                n--;
            // 2. 짝수의 경우 2의 배수만큼 이동
            }else{
                n /= 2;
            }
        }
        
        return ans;
    }
}