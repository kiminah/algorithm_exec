import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_벽부수고이동하기4 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visit;
    static Queue<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        list = new LinkedList<>();
        for(int i=0; i<N; i++){
            String[] str = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 1)
                    list.add(new int[] {i,j});
            }
        }
        
        solution(map, N, M);

        for(int[] arr : map){
            for(int num : arr)
                System.out.print(num);
            System.out.println();
        }
    }

    private static void solution(int[][] map, int n, int m){
        while(!list.isEmpty()){
            int[] pos = list.poll();
            visit = new boolean[n][m];
            map[pos[0]][pos[1]] = (map[pos[0]][pos[1]] + countArea(map, n, m, pos[0], pos[1])) % 10;
        }        
    }

    private static int countArea(int[][] map, int n, int m, int x, int y){
        int cnt = 0;
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m){
                if(map[nx][ny] == 0 && !visit[nx][ny]){
                    cnt++;
                    cnt += countArea(map, n, m, nx, ny);
                }
            }
        }
        
        return cnt;
    }
}