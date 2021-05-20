import java.util.*;
class Solution {
    Set<Integer> set;
    public int solution(int[] nums) {
        int answer = 0;
        
        // 중복없이 담을 수 있는 set
        set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
            // 총 N마리의 폰켓몬 중에서 N/2 마리를 가져갈 수 있기 때문
            if(set.size() == nums.length/2) break;
        }
        
        answer = set.size();
        
        return answer;
    }
}