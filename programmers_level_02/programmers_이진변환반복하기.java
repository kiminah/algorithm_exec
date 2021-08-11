import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        // 1이 될때까지 반복
        while(!s.equals("1")){
            // 1. 문자열 길이 저장
            answer[1] += s.length();
            // 2. 0 제거
            s = s.replaceAll("0", "");
            int tmp = s.length();
            // 3. 0 제거한 문자열 길이를 이진법 변환
            s = Integer.toBinaryString(tmp);

            // 이진변환 횟수 증가
            answer[0]++;
            // 제거된 0의 개수 = 전체 문자열 - 1의 개수
            answer[1] -= tmp;
        }
        
        return answer;
    }
}