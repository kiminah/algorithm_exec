import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 문자열 왼쪽으로 회전하며 올바른 괄호 문자열 찾기
        for(int i=0; i<s.length(); i++){
            answer += solve(s);
            s = s.substring(1) + s.substring(0,1);
        }
        
        return answer;
    }
    
    public int solve(String s){
        Stack<Character> st = new Stack<>();
        // 1. 문자열 하나씩 비교
        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);
            
            // 1-1. 괄호의 시작이면 스택에 추가
            if(c == '(' || c == '{' || c == '[') {
                st.add(c);
            // 1-2. 괄호가 닫히면 스택에 있는 괄호 제거
            //    괄호가 생기는 즉시 제거하기 때문에 스택의 상단에는 항상 괄호의 짝이 존재
            }else if(!st.isEmpty()){
                if(c == '}' && st.peek() == '{')
                    st.pop();
                else if(c==']' && st.peek() == '[')
                    st.pop();
                else if(c == ')' && st.peek() == '(')
                    st.pop();
            // 1-3. 괄호의 짝을 찾을 수 없는 경우
            }else{
                return 0;
            }
        }
        // 2. 괄호을 전부 제거한 상태임에도 스택에 괄호가 남아 있는 경우
        //    (올바른 괄호 문자열이 아닌경우)
        if(!st.isEmpty()) return 0;
        
        return 1;
    }
}