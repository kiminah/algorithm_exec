import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class backjoon4963_BFS {
    static int w, h,cnt;
    static int[][] map;
    static int[] dx = {1,-1,0,0,1,-1,1,-1};
    static int[] dy = {0,0,1,-1,1,1,-1,-1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if(w == 0 && h == 0) break;
            
            map = new int[h][w];
            visit = new boolean[h][w];

            cnt = 0;

            for(int i=0; i<h; i++){
                String[] temp = br.readLine().split(" ");
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
            
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j]==1 && !visit[i][j]) bfs(i, j, ++cnt);
                }
            }
            System.out.println(cnt);
        }
    }

    public static void bfs(int x, int y, int depth){
        if(visit[x][y]) return;

        visit[x][y] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int[] location = q.poll();
            for(int i=0; i<dx.length; i++){
                int nx = location[0] + dx[i];
                int ny = location[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<h && ny<w){
                    if(map[nx][ny]==1 && !visit[nx][ny]){
                        bfs(nx,ny,cnt);
                    }
                }
            }
        }
    }
}
