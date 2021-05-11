import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        int start = 0;
        int end = 1;
        while(true){
            // 시작점이 문자열 끝이거나 문자열이 아무것도 남지 않은 경우 반복문 종료
            if(start == s.length()-1 || s.length()==0) break; 
            // 문자가 연속되어 있는 경우
            if(s.charAt(start) == s.charAt(end)){
                // 연속된 문자열을 제외한 나머지 합치기
                if(end != s.length()-1)
                    s = s.substring(0,start) + s.substring(end+1,s.length());
                else
                    s = s.substring(0,start);
                // 다시 처음부터 시작
                start = 0;
                end = 1;
            }else{
                // 연속성을 못 찾으면 다음 문자로 넘어가기
                start++;
                end++;
            }
            
        }
        
        // 문자열이 모두 제거되었으면 1 반환
        if(s.length() == 0) return 1;

        return answer;
    }
}