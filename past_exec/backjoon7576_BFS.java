import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class backjoon7576 {
    static int m, n;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        
        bfs();
                
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        //익은 작물들 큐에 넣기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1){
                    q.add(new int[] {i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] location = q.poll();

            for(int i=0; i<4; i++){
                int nx = location[0] + dx[i];
                int ny = location[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(map[nx][ny]==0){
                        q.offer(new int[] {nx, ny});
                        map[nx][ny] = map[location[0]][location[1]] + 1;
                    }
                }
            }
        }

        //농장 상태 확인
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max-1);
    }
}
