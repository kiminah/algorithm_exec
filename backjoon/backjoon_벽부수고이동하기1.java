import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_벽부수고이동하기1 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n, m;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        
        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }

        solution(map);
        
        result = (result == Integer.MAX_VALUE) ? -1 : result;

        System.out.println(result);

        
    }

    private static void solution(char[][] map){
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0,0,1,false));

        // 벽을 안 부순 상태로 이동하는 경우와 벽을 부순 상태로 이동하는 경우로
        // 나눠야하기 때문에 3차원 배열을 사용
        boolean[][][] visit = new boolean[n][m][2];

        while(!q.isEmpty()){
            Info pos = q.poll();
            // N,M에 도달한 경우
            if(pos.x==n-1 && pos.y==m-1 && pos.depth < result){
                result = pos.depth;
                return;
            }

            // 맵 이동
            for(int i=0; i<4; i++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    // 이동한 거리 증가
                    int depth = pos.depth + 1; 
                    // 1. 이동할 수 있는 곳을 만난 경우
                    if(map[nx][ny] == '0'){
                        // 1-1. 벽을 한번도 안 부순 경우
                        if(!pos.wall && !visit[nx][ny][0]){
                            visit[nx][ny][0] = true;
                            q.add(new Info(nx, ny, depth, false));
                        // 1-2. 벽을 부순적이 있는 경우
                        }else if(pos.wall && !visit[nx][ny][1]){
                            visit[nx][ny][1] = true;
                            q.add(new Info(nx, ny, depth, true));
                        }
                    // 2. 이동할 수 없는 벽을 만난 경우
                    }else if(map[nx][ny] == '1'){
                        // 벽을 한번도 안 부순 경우만 가능
                        if(!pos.wall){
                            visit[nx][ny][1] = true;
                            q.add(new Info(nx, ny, depth, true));
                        }
                    }
                }
            }
        }
    }

    static class Info{
        int x, y, depth;
        boolean wall;
        public Info(int x, int y, int depth, boolean wall){
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.wall = wall;
        }
    }
}