import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int len = name.length();
        int min_move = len - 1;
        
        for(int i=0; i<len; i++){
            // 1. 상하
            //    A...I 'M' N...Z
            if(name.charAt(i)<='M') answer += name.charAt(i) - 'A';
            else answer += 'Z'-name.charAt(i)+1;
            
            // 2. 좌우
            int next = i+1;
            while(next < len && name.charAt(next)=='A') ++next;
            min_move = Math.min(min_move, i+len-next+Math.min(i, len-next));
        }
        
        answer += min_move;
        
        return answer;
    }
   
}