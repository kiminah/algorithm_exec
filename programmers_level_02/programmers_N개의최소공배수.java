import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        int g;
        for(int i=1; i<arr.length; i++){
            // 1. 최대공약수
            g = gcb(answer, arr[i]);
            // 2. 앞서 구한 최대공약수를 이용한 최대공배수
            answer = g * (answer/g) * (arr[i]/g);
        }
        return answer;
        
    }
    
    public int gcb(int n1, int n2){
        if(n1>n2)
            return (n1%n2==0) ? n2:gcb(n2, n1%n2);
        else
            return (n2%n1==0) ? n1:gcb(n1, n2%n1);
    }
}