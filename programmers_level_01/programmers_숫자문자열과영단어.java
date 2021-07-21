class Solution {
    public int solution(String s) {
        /** << 처음에 푼 방법 >> 
         * Map을 이용하여 영단어 map을 생성
         * 문자열을 비교하여 숫자면 answer에 합치고
         * 아니라면 임시 문자열에 추가하여 map에 매칭되는 key가 있으면
         * 숫자로 변경 후 임시 문자열 초기화
         */
        
        // 1. 영단어 배열 만들기
        String[] num = {"zero", "one", "two", "three", "four", "five",
                        "six", "seven", "eight", "nine", "ten"};
        // 2. 영단어 숫자로 변경
        for(int i=0; i<10; i++){
            s = s.replaceAll(num[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}