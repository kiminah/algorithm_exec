class Solution {
    public String solution(String s) {
        String answer = "";
        
        int len = s.length()/2;
        
        if(s.length() % 2 == 0){ // 문자열 길이 짝수 일때
            answer = s.substring(len-1, len+1);
        }else{ // 문자열 길이 홀수 일때
            answer += s.charAt(len);
        }
        return answer;
    }
}