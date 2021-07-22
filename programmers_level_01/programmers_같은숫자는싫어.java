import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();

        /* 다른 방법
         * int prev = 10;
         * for(int num : arr){
         *     if(prev != num) al.add(num);
         *     prev = num;
         * }
        */

        al.add(arr[0]);
        // 연속적으로 나타나는 숫자 확인
        // 연속적인 숫자가 아니면 배열에 추가
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i]) al.add(arr[i]);
        }
        
        int[] answer = new int[al.size()];
        for(int i=0; i<al.size(); i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}