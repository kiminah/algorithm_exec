class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] word = s.split(""); // 공백도 포함하기 위해서
        int cnt = 0; // s의 idx
        for(int i=0; i<word.length; i++){
            // 공백인 경우 idx 초기화
            if(word[i].equals(" ")){
                cnt = -1;
            }
            // 짝수번째 문자를 대문자, 홀수번째 문자를 소문자로 변경
            answer += (cnt%2 == 0)? word[i].toUpperCase() : word[i].toLowerCase();
            cnt++; // idx 증가
        }
        return answer;
    }
}