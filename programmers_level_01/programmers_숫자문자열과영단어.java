class Solution {
    public int solution(String s) {
        
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