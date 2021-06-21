import java.util.*;
class Solution {
    int[][] map;
    boolean[][] visit;
    int[] cost;
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        
        map = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];
        cost = new int[N+1];
        
        // 1. 맵 만들기
        for(int i=0; i<road.length; i++){
            int[] root = road[i];
            if(map[root[0]][root[1]]>0){
                map[root[0]][root[1]] = map[root[1]][root[0]] = Math.min(map[root[0]][root[1]], root[2]);
            }else{
                map[root[0]][root[1]] = map[root[1]][root[0]] = root[2];
            }
        }
        
        // 2. 각 마을별 시간 최대로 설정
        for(int i=2; i<=N;i++){
            cost[i] = Integer.MAX_VALUE;
        }
        
        dfs(map, N, K, 1, 0);
        
        // 3. 각 마을별 거리가 K값 이하인 경우의 개수 count
        //    마을 1은 count 되어 있는 상태이기 때문에 i를 2부터 시작
        for(int i=2; i<=N; i++){
            if(cost[i]<=K) answer++;
        }
        
        return answer;
    }
    
    public void dfs(int[][] map, int N, int K, int start,int time){
        // 1. 각 마을별 시간 cost 배열에 저장(최소값으로 저장)
        cost[start] = Math.min(cost[start], time);
        
        // 2. 시간이 K를 넘으면 반환
        if(time > K) return;
        
        // 3. 연결된 마을 방문(1에서 시작했으므로 2부터 시작)
        for(int i=2; i<=N; i++){
            if(map[start][i] >0 && !visit[start][i]){
                visit[start][i] = visit[i][start] = true;
                dfs(map, N, K, i, time + map[start][i]);
                visit[start][i] = visit[i][start] = false;
            }
        }
        
    }
}