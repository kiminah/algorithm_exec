import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        int start = 0;
        while(start != s.length()-1){
            // 문자가 모두 제거되면 1 반환
            if(s.length()==0) return 1;
            if(s.charAt(start)==s.charAt(start+1)){
                // 문자열 제거 후 앞뒤 문자열 이어 붙이기
                s=s.substring(0,start)+s.substring(start+2,s.length());
                // 처음부터 다시 시작
                start = 0;
            }else{
                start++;
            }
        }
        return answer;
    }
}