/**
 * 1. 스택이용(런타임 에러)
 * 2. 스택 카운트 사용(통과 - 다양한 경우의 수를 if문으로 작성하며 가독성 떨어짐)
 * 3. cnt 개수를 이용한 if 문 완성
 */
class Solution {    
    boolean solution(String s) {
        boolean answer = false;
        
        int cnt = 0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='(') cnt++;
            else if(s.charAt(i) == ')') cnt--;
            
            if(cnt < 0) return false;
        }
        if(cnt == 0) return true;

        return answer;
    }
}