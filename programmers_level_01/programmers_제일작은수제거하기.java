import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        // 1. 가장 작은 수 추출
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            if(min > num) min = num;            
        }

        // 2. 가장 작은 수 제거
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == min) continue;
            list.add(arr[i]);
        }

        // 3-1. 배열이 빈 배열인 경우 -1 리턴
        if(list.size()==0) return new int[] {-1};
        
        // 3-2. 가장 작은 수를 제거한 배열 리턴
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}