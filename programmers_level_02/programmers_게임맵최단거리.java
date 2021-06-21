import java.util.*;
class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    Queue<Pos> q;
    public int solution(int[][] maps) {
        int n = maps.length-1;
        int m = maps[0].length-1;
        q = new LinkedList<Pos>();
        
        // 1. 너비우선탐색으로 접근
        bfs(maps,n,m);
        
        // 2. 상대 팀 진영 위치의 값을 확인
        if(maps[n][m] == 1) return -1;
        else return maps[n][m];
    }
    
    public void bfs(int[][] maps, int n, int m){
        // 1. 본인의 캐릭터의 위치 미리 추가
        q.add(new Pos(0,0));
        
        // 2. 길을 따라 이동
        while(!q.isEmpty()){
            Pos pos = q.poll();
            // 2-1. 상대팀 진영에 도착한 경우 함수 종료
            if(pos.x==n && pos.y==m)
                return;
            // 2-2. 현재 위치에서 길이 있는 동서남북 확인 및 이동
            for(int i=0; i<4; i++){
                int nx = pos.x+dx[i];
                int ny = pos.y+dy[i];
                // 2-2-1. 지도 내에 위치한 경로인 경우
                //        그 경로가 길인 경우 방문 예정의 위치로 추가
                //        맵의 값도 변경(이동한 칸의 수)
                if (nx>=0 && nx<=n && ny>=0 && ny<=m){
                    if(maps[nx][ny]==1){
                        q.add(new Pos(nx,ny));
                        maps[nx][ny] = maps[pos.x][pos.y] + 1;
                    }
                }
            }  
        }
    }
}
class Pos{
    int x,y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}