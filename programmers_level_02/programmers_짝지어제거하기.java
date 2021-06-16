import java.util.*;
class Solution
{
    public int solution(String s)
    {
        // 문자열 담을 스택
        Stack<Character> st = new Stack<>();
        
        // 1. 첫 문자는 미리 담고 반복문 실행
        st.push(s.charAt(0));
        int idx = 1;
        while(idx != s.length()){
            
            // 1-1. 스택이 비어 있거나 문자열이 다른 경우 스택에 추가
            if(st.size() == 0 || st.peek() != s.charAt(idx)) st.push(s.charAt(idx));
            
            // 1-2. 스택 상단문자와 현재 문자가 같은 경우
            //      스택 상단 문자 제거
            else st.pop();
            idx++;
        }
        
        // 스택 크기에 따른 결과 반환
        if(st.size() == 0) return 1;
        else return 0;
    }
}