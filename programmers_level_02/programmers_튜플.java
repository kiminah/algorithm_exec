import java.util.*;
class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        // 1. 문자열 s 배열로 변환
        String[] str = s.replaceAll("[{]"," ").replaceAll("[}]", " ").trim().split(" , ");
        
        // 2. 배열 길이별로 정렬
        Arrays.sort(str, (a,b)->(a.length()-b.length()));
        
        int[] answer = new int[str.length];
        int idx = 0;
        for(String ss : str){
            for(String num : ss.split(",")){
                // set에 추가되는 경우에만 answer 배열에 추가
                if(set.add(num)) answer[idx++] = Integer.parseInt(num);
            }
        }
        
        return answer;
    }
}