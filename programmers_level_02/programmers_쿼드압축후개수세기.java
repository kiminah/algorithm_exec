class Solution {
    boolean[][] visit;
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        
        visit = new boolean[arr.length][arr.length]; // 압축 완료된 구간
        divid(arr, arr.length, 0, 0); // 압축 진행 : divid(배열, 균일한 정사각형 영역, 시작 row, 시작 col);
        
        return answer;
    }
    
    public void divid(int[][] arr, int len, int row, int col){
        // 1. 압축 완료된 구간인 경우 pass
        if(visit[row][col]) return;
        
        // 2. 모든 수가 같은 값인 경우 확인(합으로 확인)
        int sum = 0;
        for(int i=row; i<row+len; i++){
            for(int j=col; j<col+len; j++){
                sum += arr[i][j];
            }
        }
        
        // 3. 하나의 수로 압축
        // 3-1. 0인 경우 0의 개수 count & 하나로 압축
        if(sum == 0){
            visit[row][col] = true;
            answer[0]++;
        }
        // 3-2. 1인 경우 1의 개수 count & 하나로 압축
        else if(sum == len*len){
            visit[row][col] = true;
            answer[1]++;
        }
        // 3-3. 그외의 경우 압축 진행
        else{
            len /= 2;
            if(len > 0){
                divid(arr, len, row, col);
                divid(arr, len, row, col+len);
                divid(arr, len, row+len, col);
                divid(arr, len, row+len, col+len);
            }
        }
    }
}