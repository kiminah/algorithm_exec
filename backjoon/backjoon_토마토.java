import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_토마토 {
    static int m, n, h;
    static int[][][] map;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        for(int k=0; k<h; k++){
            for(int i=0; i<n; i++){
                String[] tmp = br.readLine().split(" ");
                for(int j=0; j<m; j++){
                    map[k][i][j] = Integer.parseInt(tmp[j]);
                }
            }
        }
        solution();
    }

    private static void solution(){
        Queue<Pos> q = new LinkedList<>();

        // 1. 익은 토마토의 위치 저장
        for(int k=0; k<h; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[k][i][j] == 1){
                        q.add(new Pos(k,i,j));
                    }
                }
            }
        }
        
        // 2. 영향받은 토마토 표시
        while(!q.isEmpty()){
            Pos pos = q.poll();
            
            for(int d=0; d<dx.length; d++){
                int nx = pos.x + dx[d];
                int ny = pos.y + dy[d];
                int nz = pos.z + dz[d];

                if(nx>=0 && nx<n && ny>=0 && ny<m && nz>=0 && nz<h){
                    // 인접한 곳에 익지않은 토마토가 있다면 영향을 받아 익음
                    if(map[nz][nx][ny] == 0){
                        q.add(new Pos(nz, nx, ny));
                        map[nz][nx][ny] = map[pos.z][pos.x][pos.y] + 1;
                    }
                }
            }
        }

        // 3. 창고에 보관된 토마토들이 다 익게 되는 최소 일수
        int max = 0;
        for(int k=0; k<h; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    // 익지않은 토마토 발견 시 -1 반환
                    if(map[k][i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                    // 각 위치마다 토마토가 며칠째에 익었는지 표시해두었기 때문에
                    // max를 구하면 마지막으로 익은 토마토의 일수를 알 수 있다.
                    max = Math.max(max, map[k][i][j]);
                }
            }
        }
        // 기존 익은 토마토가 1로 시작했으므로 max-1
        System.out.println(max-1);
    }

    static class Pos{
        int z, x, y;
        public Pos(int z, int x, int y){
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}