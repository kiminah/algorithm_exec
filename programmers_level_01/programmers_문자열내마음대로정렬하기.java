import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = strings.clone();
        // 람다식을 이용한 문자열 정렬
        Arrays.sort(answer, (a,b) -> {
            char o1 = a.charAt(n);
            char o2 = b.charAt(n);
            // n번째 글자가 같은 경우 사전순으로 정렬
            // 아닌 경우 n번째 글자를 기준으로 오름차순으로 정렬
            return (o1==o2) ? a.compareTo(b) : o1-o2; 
        });
        
        return answer;
    }
}