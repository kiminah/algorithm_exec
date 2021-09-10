import java.util.*;
class Solution {
    int answer = 0;
    boolean[] visit;
    int[] dx = {1, 1, -1, -1};
    int[] dy = {1, -1, 1, -1};
    public int solution(int n) {
        
        // 첫번째 행의 위치에 따른 경우의 수
        // (각 행에 퀸 1개씩 배치해야 조건 만족)
        for(int i=0; i<n; i++){
            int[][] map = new int[n][n];
            visit = new boolean[n];
            queen(n, map, 0, i, 1);
        }
        
        return answer;
    }
    
    public void queen(int n, int[][] map, int x, int y, int depth){
        visit[y] = true;
        map[x][y] = 1;
        
        // 1. 공격 가능 여부 확인
        if(!isAttack(map, n, x, y)){
            // 서로 공격할 수 없는 퀸 n개를 다 배치한 경우 answer 증가
            // 서로 공격할 수는 없지만 퀸 n개가 아직 배치되지 않는 경우 퀸 배치 진행
            if(depth == n){
                answer++;
                return;
            }
        }else return;
        
        // 2. 퀸 배치
        for(int i=0; i<n; i++){
            // 배열 세로에 퀸이 없는 경우
            if(!visit[i]){
                // 다음 행에 퀸 배치
                queen(n, map, x+1, i, depth+1);

                visit[i] = false;
                map[x+1][i] = 0;
            }
        }
    }
    
    public boolean isAttack(int[][] map, int n, int x, int y){
        // 현재 위치에서 모든 대각선에 퀸의 존재 여부 확인
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위 내에서 진행
            while(isRange(nx, ny, n)){
                // 1을 발견한 경우 공격 가능 반환
                if(map[nx][ny] == 1) return true;
                nx += dx[i];
                ny += dy[i];
            }
        }
        return false;
    }
    
    public boolean isRange(int x, int y, int n){
        return (x>=0 && x<n && y>=0 && y<n) ? true : false;
    }
}