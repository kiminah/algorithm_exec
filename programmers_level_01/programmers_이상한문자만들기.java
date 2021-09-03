class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] wordList = s.split(""); // 공백도 포함하기 위해서
        int cnt = 0; // s의 idx
        for(String word : wordList){
            // 공백인 경우 초기화, 아닌경우 증가
            cnt = word.equals(" ") ? 0 : cnt+1;
            // cnt를 1부터 시작하기 때문에 
            // 홀수인 경우를 대문자로, 짝수인 경우를 소문자로 변경
            answer += (cnt%2 != 0) ? word.toUpperCase() : word.toLowerCase();
        }

        return answer;
    }
}