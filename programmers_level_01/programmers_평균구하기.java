class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        // 점수 합산
        for(int num : arr)
            answer += num;
        // 평균
        return answer/arr.length;
    }
}