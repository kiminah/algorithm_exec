import java.util.*;
class Solution {
    Stack<Integer> st;
    public int solution(String dartResult) {
        int answer = 0;
        st = new Stack<>(); // 얻은 점수 저장
        
        String tmp = ""; // 숫자 10을 만들기 위한 문자열
        int num = 0; // 만든 문자열을 숫자로 변환하기 위한 저장공간
        
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            // 1. 숫자인 경우
            if(c>='0' && c<='9'){
                tmp += c;
            }
            // 2. 문자인 경우
            else{
                // 숫자가 형성된 경우 num에 변환값 저장
                if(tmp.length()>0)
                    num = Integer.parseInt(tmp);
                
                // 2-1. 스타상인 경우
                if(c=='*'){
                    // 해당 점수 2배
                    int now = st.pop()*2;
                    // 바로 전에 얻은 점수 존재하면
                    // 이전 점수도 2배
                    if(st.size()>0){
                        int prev = st.pop()*2;
                        st.push(prev);
                    }
                    st.push(now);
                    continue;
                }
                // 2-2. 아차상인 경우
                // 점수 마이너스
                else if(c=='#'){
                    st.push(st.pop() * -1);
                    continue;
                }
                // 2-3. S,D,T 영역
                // 제곱근 값 결정
                else{
                    int loop = 0;
                    switch(c){
                        case 'S':
                            loop = 1;
                            break;
                        case 'D':
                            loop = 2;
                            break;
                        case 'T':
                            loop = 3;
                            break;

                    }
                    // 제곱값 저장 후 문자열 초기화
                    num = (int)Math.pow(num,loop);
                    st.push(num);
                    tmp = "";
                }
            } 
    
        }
        
        // 얻은 점수 합산
        while(!st.isEmpty()){
            answer += st.pop();
        }
        
        return answer;
    }
}