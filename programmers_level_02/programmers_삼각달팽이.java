class Solution {
    public int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        int loop = n;
        int num = 0;
        
        int row = -1;
        int col = 0;

        // 1. 행 증가, 열 증가, 행과 열 감소를 반복
        //    한 파트를 반복할 때마다 루프수가 감소(달팽이 모양이기 때문)
        for(int i=0; i<n; i++){
            for(int j=0; j<loop; j++){
                arr[++row][col] = ++num;
            }
            loop--;
            for(int j=0; j<loop; j++){
                arr[row][++col] = ++num;
            }
            loop--;
            for(int j=0; j<loop; j++){
                arr[--row][--col] = ++num;
            }
            loop--;
        }
        
        int[] answer = new int[num];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j]==0) break;
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
}