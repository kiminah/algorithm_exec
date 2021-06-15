class Solution {
    int[][] map;
    int[][] copymap;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // 1. 맵 만들기
        map = new int[rows+1][columns+1];
        for(int i=1; i<=rows; i++)
            for(int j=1; j<=columns; j++)
                map[i][j] = (i-1) * columns + j;
            
        // 2. 직사각형 모양의 범위에서 테두리 부분에 있는 숫자들 시계방향으로 회전
        for(int i=0; i<queries.length; i++){
            // 2-1. 회전할 때 기존 숫자를 가져오기 위한 맵 복사본
            copymap = new int[rows+1][columns+1];
            for(int j=1; j<=rows; j++)
                copymap[j] = map[j].clone();
            
            // 2-2. 시계방향으로 회전하며 최소값도 함께 검출
            answer[i] = rotate_map(queries[i]);
        }
        return answer;
    }
    
    // 테두리 숫자를 시계방향으로 회전 시키는 함수
    public int rotate_map(int[] q){
        // 최소값 저장 변수
        int min = Integer.MAX_VALUE;
        
        // 직사각형 모양의 범위
        int r = q[2]-q[0]; // 가로 길이
        int c = q[3]-q[1]; // 세로 길이
        
        int flag = 1; // 회전시 행렬 증가 또는 감소로 변경해주는 스위치
        int row = q[0], col = q[1]; // 첫 시작 위치
        int num = 0; // 기존 값 저장 변수
        
        for(int k=0; k<2; k++){
            // 가로 이동
            for(int i=0; i<c; i++){
                num = copymap[row][col];
                col += flag;
                map[row][col] = num;
                if(num<min) min = num;
            }
            // 세로 이동
            for(int i=0; i<r; i++){
                num = copymap[row][col];
                row += flag;
                map[row][col] = num;
                if(num<min) min = num;
            }
            // 감소로 변경
            flag *= -1;
        }
        return min;
    }
}