import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class backjoon14502 {
    static int n, m;
    static int[][] map;
    static int[][] copymap;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int max =0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        copymap = new int[n][m];

        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
                
            }
        }

        dfs(0);
        System.out.println(max);
    }

    //벽 새우는 함수
    public static void dfs(int depth){
        if(depth==3){
            copy_Map();//바이러스 퍼트릴 맵

            bfs();

            return;//바이러스 퍼트리기
        }

        //벽 세우기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(depth+1);
                    map[i][j]=0;
                }
            }
        }
    }

    public static void copy_Map(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copymap[i][j] = map[i][j];
            }
        }
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 2){
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
                    if(copymap[nx][ny]==0){
                        copymap[nx][ny] = 2;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        max = Math.max(max, getSafeArea());
    }

    public static int getSafeArea(){
        int cnt =0;
        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                if(copymap[i][j]==0)
                    cnt++;
            }
        }
        return cnt;
    }
}