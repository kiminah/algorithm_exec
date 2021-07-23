import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] score = {6,6,5,4,3,2,1}; // 로또 순위 정하는 방식
        
        // 1. 당첨 번호를 boolean 형식으로 저장
        boolean[] check = new boolean[46];
        int zero_cnt = 0; // 최고 순위를 나타내기 위한 0의 개수
        for(int num : lottos){
            check[num] = true;
            if(num == 0) zero_cnt++;
        }
        // 2. 당첨 번호가 true 이면 맞춘 개수 증가
        int match = 0;
        for(int num : win_nums){
            if(check[num]) match++;
        }
        // 3. 순위 반환 (score[최대 맞춘개수], score[최소 맞춘개수])
        return new int[] {score[match+zero_cnt], score[match]};
    }
}