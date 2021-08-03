import java.util.*;
class Solution {
    int[][] map;
    int[][] cost;
    int INF = 1000000000;
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        
        map = new int[N+1][N+1];
        cost = new int[N+1][N+1];
        
        // 1. 초기화
        for(int i=1; i <= N; i++) {
            for(int j=1; j <= N; j++) {
                if(i == j) continue;
                map[i][j] = INF;
            }
        }
        
        // 2. 맵 만들기
        for(int i=0; i<road.length; i++){
            // 2-1. 마을을 연결한 도로가 2가지인 경우 최소값으로 설정
            if(map[road[i][0]][road[i][1]] < INF && map[road[i][0]][road[i][1]]<road[i][2])
                continue;
            else
                map[road[i][0]][road[i][1]] = map[road[i][1]][road[i][0]] = road[i][2];
        }
        
        // 3. 이동시간 초기화
        for(int i=0; i<map.length; i++){
            cost[i] = map[i].clone();
        }
        
        // 4. 플로이드 와샬 알고리즘 사용
        // 4-1. 지나가는 지점
        for(int k=1; k<=N; k++){
            // 4-2. 출발 지점
            for(int i=1; i<=N; i++){
                // 4-3. 도착 지점
                for(int j=1; j<=N; j++){
                    // 최단 시간 저장
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }
        
        // 5. 배달 가능한 마을의 개수
        for(int i=2; i<=N; i++){
            if(cost[1][i]<=K) answer++;
        }
        
        return answer;
    }
    
}