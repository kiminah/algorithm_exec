import java.util.*;
class Solution {
    int[][] map;
    boolean[] visit;
    List<int[]> link;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];
        link = new ArrayList<>();

        // 1. 전력망 만들기
        for(int i=0; i<wires.length; i++){
            int x = wires[i][0];
            int y = wires[i][1];
            
            map[x][y] = map[y][x] = 1;
            link.add(new int[] {x,y});
        }

        // 2. 전선들 중 하나를 끊어서 송전탑 개수 가능한 비슷하도록 나누기
        for(int[] pos : link){
            int x = pos[0];
            int y = pos[1];
            
            // 2-1. 전선들 중 하나 끊기
            map[x][y] = map[x][y] = 0;

            // 2-2. 송전탑 개수 구하기
            int cnt = topCount(x, y, n);

            // 2-3. 송전탑 개수의 차
            //      두 전력망이 가지고 있는 송전탑 개수의 차의 최소값
            int result = Math.abs((n-cnt)-cnt);
            answer = Math.min(answer, result);
            
            // 2-4. 끊은 전선 다시 연결
            map[x][y] = map[x][y] = 1;
        }
        
        return answer;
    }
    private int topCount(int x, int y, int n){
        Queue<Integer> q = new LinkedList<>();
        visit = new boolean[n+1];
        q.add(x);
        
        int cnt = 1; // 송전탑 개수
        while(!q.isEmpty()){
            int pos = q.poll();
            visit[pos] = true;
            for(int i=1;i<=n;i++){
                if(map[pos][i] == 1 && !visit[i]){
                    cnt++;
                    q.add(i);
                }
            }
        }
        return cnt;
    }
}