import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class backjoon_구슬탈출2 {

    static int[] dx = new int[] {1,-1,0,0};
    static int[] dy = new int[] {0,0,1,-1};
    static String[][] map;
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        sc.nextLine();
        map = new String[N][M];
        visit = new boolean[N][M];

        int[] idx_b = new int[2];
        int[] idx_r = new int[2];
        // 맵 생성
        for(int i=0; i<N; i++){
            String[] str = sc.nextLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = str[j];
                if(str[j]=="B"){
                    idx_b[0] = i;
                    idx_b[1] = j;
                }else if(str[j] == "R"){
                    idx_r[0] = i;
                    i9``09-=_r[1] = j;
                }
            }
        }

        // 구슬 이동
        // 빨간 구슬 이동
        bfs(N, M, "R", 0);

        // 파란 구슬 이동
        bfs(N, M, "B");


    }

    public static int bfs(int N, int M, String ball, int cnt){
        Queue<int[]> q = new LinkedList<>();
        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==ball){
                    q.add(new int[] {i,j});
                    visit[i][j]=true;
                }
            }
        }

        while(!q.isEmpty()){
            cnt++;
            int[] location = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = location[0] + dx[i];
                int ny = location[1] + dy[i];
                if(nx>0 && ny>0 && nx<N-1 && ny<M-1){
                    if(map[nx][ny]=="." || !visit[nx][ny]){
                        visit[nx][ny]=true;
                        q.offer(new int[] {nx, ny});
                    }else if(map[nx][ny] == "O"){
                        result = Math.min(result, cnt);
                    }
                }
            }
        }

        return result;
        
    }
}
