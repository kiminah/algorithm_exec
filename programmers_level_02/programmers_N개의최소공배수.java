import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i<arr.length; i++){
            // 두 수의 최소공배수
            answer = min_num(answer, arr[i]);
        }
        return answer;
        
    }
    
    public int min_num(int n1, int n2){
        int result = 1;
        for(int i=2; i<=Math.max(n1,n2);i++){
            // 최대 공약수
            if(n1%i==0 & n2%i==0){
                result *= i;
                n1 /= i;
                n2 /= i;
                i=1;
            }
        }
        // 최대공약수로 나눈 나머지 수 곱
        result *= n1*n2;
        return result;
    }
}