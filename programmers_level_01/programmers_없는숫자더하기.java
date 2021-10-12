class Solution {
    public int solution(int[] numbers) {
        // 0~9 까지의 합 45
        int answer = 45;
        
        // 배열에 포함되지 않는 수의 합을 구하는 것
        // 따라서, 0~9까지의 총합중에서 배열에 존재하는 수만큼 제거하면 해결
        for(int num : numbers)
            answer -= num;
        
        return answer;
    }
}