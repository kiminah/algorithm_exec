import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        int loop = 0;
        int cnt = 0;
        // 1이 될때까지 반복
        while(!s.equals("1")){
            String tmp = "";
            // 1. 0제거
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    tmp += s.charAt(i);
                }else 
                    cnt++; // 0의 개수
            }
            // 2. 0 제거한 문자열 길이를 이진법으로 변환
            s = Integer.toBinaryString(tmp.length());
            // 3. 이진변환 횟수
            loop++;
        }
        
        return new int[] {loop, cnt};
    }
}