import java.util.Collections;
import java.util.ArrayList;
class Solution {
    ArrayList<Integer> list;
    public int[] solution(int[] numbers) {
        int[] answer;
        list = new ArrayList<>();
        
        // 두 요소의 합
        for(int i=0; i<numbers.length-1; i++){
            pick_num(numbers,i);
        }
        
        // 오름차순 정렬
        Collections.sort(list);
        
        // answer에 list 요소 넣기
        answer= new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    public void pick_num(int[] numbers, int index){
        for(int i=index+1; i<numbers.length;i++){
            int sum = numbers[index]+numbers[i];
            if(!list.contains(sum)){
                list.add(sum);
            }
        }
    }
}