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

        /** 다른 방법 (실행시간은 길다)
         * 
            // 1. n번째 글자를 index값으로 맨 앞에 추가
            List<String> list = new ArrayList<>()
            for(String str : strings){
                list.add(str.charAt(n)+str);
            }

            // 2. 정렬
            Collections.sort(list);

            // 3. index 값으로 설정한 맨 앞글자를 제거한 문자를 추가
            String[] answer = new String[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i).substring(1);
            }
            
            return answer;

        */

    }
}