import java.util.*;
class Solution {
    boolean[][] visit;
    Queue<int[]> q;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visit = new boolean[m][n]; // 방문여부
        q = new LinkedList<int[]>(); // 방문한 위치
            
        // 그림의 각 원소 방문
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int max = 0;
                // 그림의 해당 영역이 색칠해야 하는 경우와
                // 이전에 방문하지 않은 경우
                if(picture[i][j]>0 && !visit[i][j]){
                    numberOfArea++; // 그림 영역 카운트
                    max = bfs(picture,i,j,m,n); // 각 영역의 크기
                }
                // 각 영역의 크기 중 가장 큰 영역
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, max);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int[][] picture, int x, int y, int m, int n){
        int cnt = 1; // 영역 크기 결정하는 변수
        // 1. 그림 영역 위치 저장
        visit[x][y] = true;
        q.add(new int[] {x,y});
        // 2. 주변에 연결된 같은 영역 찾기
        while(!q.isEmpty()){
            // 2-1. 처음 방문한 영역 추출
            int[] pos = q.poll();
            for(int i=0; i<4; i++){
                // 2-2. 상하좌우 방문
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                // 2-3. 그림 크기를 벗어나지 않으면
                //      같은 영역 + 방문한 적 없는 영역인 경우
                //      큐에 추가 및 영역 크기 증가
                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    if(picture[nx][ny] == picture[x][y] && !visit[nx][ny]){
                        q.add(new int[] {nx, ny});
                        visit[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}