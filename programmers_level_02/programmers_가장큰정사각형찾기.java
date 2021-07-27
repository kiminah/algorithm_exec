class Solution
{
    int row;
    int col;
    int[][] dp;
    public int solution(int[][] board)
    {
        int answer = board[0][0];
        row = board.length;
        col = board[0].length;
        dp = new int[row][col];
        
        // 1. 크기 저장할 배열 생성
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                dp[i][j] = board[i][j];
            }
        }
        
        // 2. (1,1) 부터 시작하여 주변 값으로 크기 결정 (주변값의 최솟값 + 1)
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(board[i][j]==1){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]))+1;
                    if(answer < dp[i][j]) answer = dp[i][j];
                }
            }
        }
        
        return answer*answer;
    }
    
}