class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        // dfs(numbers, depth, sum, target)
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public int dfs(int[] numbers, int n, int sum, int target){
        // numbers를 다 돈 상태일때
        if(n == numbers.length){
            // 그 때의 합이 target과 같은지 비교
            // 같으면 1 반환
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        
        // 아직 다 안 돌았으면 깊이 들어간다
        // 첫번째 dfs는 양수인 경우
        // 두번째 dfs는 음수인 경우
        return (dfs(numbers, n+1, sum+numbers[n], target)+
                dfs(numbers, n+1, sum-numbers[n], target));
    }
}