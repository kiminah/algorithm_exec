import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        // 1. 정렬용 배열 생성
        ArrayList<Integer> al = new ArrayList<>();
        for(Integer num : numbers){
            al.add(num);
        }
        // 2.. 람다식 이용한 정렬
        Collections.sort(al, (a,b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            // 두 수를 조합했을 때, 큰 수가 나와야 하기 때문에 내림차순으로 정렬
            return -Integer.compare(Integer.parseInt(as+bs), Integer.parseInt(bs+as));
        });
        
        // 3. 정렬된 배열 순서대로 조합
        StringBuilder sb = new StringBuilder();
        for(Integer i : al)
            sb.append(i);
            
        // 4. Integer -> String
        answer = sb.toString();
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}