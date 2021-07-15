import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] nums) {
        
        for(int i=0; i<nums.length; i++)
            make_sum(nums, i, 0, 1);
        
        return answer;
    }
    
    public boolean check_sosu(int num){
        for(int j=2; j*j<=num; j++){
            if(num % j == 0) return true;
        }
        return false;
    }
    
    public void make_sum(int[] nums, int start, int sum, int depth){
        sum += nums[start];
        
        // 1. 3개를 골랐을 때 소수 판별
        if(depth == 3){
            if(!check_sosu(sum)) answer++;
            return;
        }
        
        // 2. 3개 미만인 경우 3개 될때까지 진행
        for(int i=start+1; i<nums.length; i++){
            make_sum(nums, i, sum, depth+1);
        }
    }
    
}