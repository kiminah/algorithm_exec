import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        // 2행부터 시작
        for(int i=1; i<n; i++){
            // 바로 이전행의 최대값을 합산 (본인이 해당하는 열은 제외)
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        
        // 마지막 행에는 각 열의 합산된 최대값들이 존재
        // 그 중 최대값을 선별
        answer = Math.max(land[n-1][0], Math.max(land[n-1][1], Math.max(land[n-1][2], land[n-1][3])));
        
        return answer;
    }
}