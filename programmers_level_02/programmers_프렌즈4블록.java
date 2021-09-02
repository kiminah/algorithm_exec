class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        
        for(int i=0; i<m; i++){
            map[i] = board[i].toCharArray();
        }
        
        while(true){
            // 1. 2x2 형태 찾아서 지워지는 블록 개수 구하기
            int cnt = checkBlock(map, m, n);
            // 2. 지울 블록이 없으면 반복문 종료
            if(cnt == 0) break;
            
            answer += cnt;
            // 3. 블록이 지워진 후 위에 있는 블록을 아래로 떨어져 빈 공간 채우기
            dropBlock(map, m, n);
        }
        
        return answer;
    }
    
    public int checkBlock(char[][] map, int m, int n){
        boolean[][] visit = new boolean[m][n]; // 지워진 블록 체크
        int cnt = 0; // 지워진 블록 개수

        // 1. 블록 순서대로 진행
        //    2x2 배열 모양으로 찾기 위해 m-1, m-1
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                // 1-1. 빈 블록이면 통과
                if(map[i][j] == '.') continue;
                // 1-2. 2x2 배열 확인
                checkFour(map, visit, i, j);
            }
        }
        
        // 2. 지워진 블록의 개수 확인
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visit[i][j]){
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }
        return cnt;
    }
    public void checkFour(char[][] map, boolean[][] visit, int r, int c){
        char block = map[r][c]; // 비교할 블록의 모양
        
        for(int i=r; i<r+2; i++){
            for(int j=c; j<c+2; j++){
                // 블록이 다르면 함수 종료
                if(map[i][j] != block) return;
            }
        }
        
        // 4개의 블록이 같은 경우 지울 수 있는 블록이라고 체크
        for(int i=r; i<r+2; i++){
            for(int j=c; j<c+2; j++){
                visit[i][j] = true;
            }
        }
    }
    
    public void dropBlock(char[][] map, int m, int n){
        // 블록을 떨어트리기 위해 가장 밑 행부터 시작
        for(int i=m-1; i>0; i--){
            for(int j=0; j<n; j++){
                // 빈 블록을 발견한 경우 가장 가까운 상단의 블록으로 바꾸기
                if(map[i][j] == '.'){
                    for(int r=i-1; r>=0; r--){
                        if(map[r][j] != '.'){
                            map[i][j] = map[r][j];
                            map[r][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}