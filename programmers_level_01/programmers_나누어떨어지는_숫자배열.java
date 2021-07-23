import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {

        /* 간단한 코드 (실행 시간은 더 길다)
         * int[] answer = Arrays.stream(arr).filter(num -> num % divisor == 0).toArray();
         * if(answer.length == 0 )return new int[] {-1};
         * Arrays.sort(answer);
         */
        
        // 1. 나누어지는 값 저장할 배열
        ArrayList<Integer> al = new ArrayList<>();
        
        // 2. 나누어 떨어지는 값 확인
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0) al.add(arr[i]);
        }
        
        // 3. 없으면 -1 반환
        if(al.size()==0) return new int[] {-1};
        
        // 4. 있는 경우 정렬 후 반환
        Collections.sort(al);
        int[] answer = new int[al.size()];
        for(int i=0; i<al.size(); i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}