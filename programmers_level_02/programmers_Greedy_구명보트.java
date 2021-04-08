import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int first = 0;
        int second = people.length-1;
        
        // 정렬
        Arrays.sort(people);
        
        
        while(first <= second){
            // 가리키는 값이 제한값의 절반보다 작을경우
            // 그 다음 수들을 합하더라도 제한값을 초과하지 않음
            if(people[second] <= limit/2){
                // 최대 수용인원수가 2명이므로 나눠서 올림값으로 설정
                answer += Math.ceil((float)(second+1-first)/2);
                break;
            }
            // 두 명의 몸무게 합이 제한값보다 작을 경우
            if(people[first]+people[second--]<=limit)
                first++;
            
            answer++;
        }
        
        return answer;
    }
}