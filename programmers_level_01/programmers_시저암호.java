class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            // 1. 공백은 그대로 추가
            if(c==' '){
                answer += c;
                continue;
            }

            // 2. 문자인 경우 n만큼 밀어주기
            char new_c = c;
            new_c += n;
            // 3-1. 밀기 전 문자가 대문자인 경우 + Z를 넘어간 경우
            //      Z를 넘어간 크기 만큼 A에서 다시 시작
            if(c>='A' && c<='Z' && new_c>'Z')
                new_c = (char)(new_c-'Z'+'A'-1);
            // 3-2. 밀기전 문자가 소문자인 경우 + z를 넘어간 경우
            //      z를 넘어간 크기 만큼 a에서 다시 시작
            else if(new_c>'z') 
            new_c = (char)(new_c-'z'+'a'-1);

            answer += new_c;
        }

        return answer;
    }
}