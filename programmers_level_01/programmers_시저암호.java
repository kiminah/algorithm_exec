class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            // 1. 대소문자를 구분하여 n만큼 밀어서 다른 알파벳으로 변경
            //    26으로 나눈 나머지 값을 사용하는 이유는
            //    n의 값이 최대 25이므로 25를 벗어난 경우
            //    a 또는 A부터 시작해야하므로 벗어난 만큼의 수를 더해줘야 하기 때문
            //    벗어나지 않았다면 나머지 값이 c의 값 그대로 나올 것이다.
            if(Character.isUpperCase(c))
                c = (char)((c-'A'+n)%26+'A');
            else if(Character.isLowerCase(c))
                c = (char)((c-'a'+n)%26+'a');
            answer += c;
        }
        return answer;
    }
}