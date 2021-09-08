class Solution {
    String res;
    public String solution(String s) {
        res = "";
        // Stream 사용
        // character로 하나씩 나눈다음 정렬
        // 뒤의 문자부터 차례대로 res에 추가하며 문자열 생성
        s.chars().sorted().forEach(c -> res = Character.valueOf((char)c)+res);
        return res;
    }
}