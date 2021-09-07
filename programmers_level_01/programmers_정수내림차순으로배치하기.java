import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        // 1. 숫자 단위별로 배열생성
        String[] arr = Long.toString(n).split("");
        // 2. 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        // 3. 배열 -> 숫자
        for(int i=0; i<arr.length; i++){
            answer = answer*10 + Integer.valueOf(arr[i]);
        }
        return answer;
    }
}