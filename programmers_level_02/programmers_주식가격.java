import java.util.*;
class Solution {
    Stack<Integer> st;
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        st = new Stack<>(); // 주식가격 담는 스택
        
        // 첫 시작 주식가격을 먼저 넣기
        int first = 0;
        int second = 1;
        st.push(first);
        
        // 비교를 위한 시작 주식가격이 끝까지 왔을 때 종료
        while(first < prices.length-1){
            // 비교 주식가격 push
            st.push(prices[second]);
            
            // 비교 주식가격이 끝이거나 주식가격이 떨어진 경우
            if(second == prices.length-1 || prices[first] > prices[second]){
                answer[first] = st.size()-1;
                st.clear();
                st.push(++first);
                second = first+1;
            }else{
                second++;
            }
        }
        // 가장 마지막 주식가격은 0초이므로 따로 추가
        answer[--second] = 0;
        
        return answer;
    }
}