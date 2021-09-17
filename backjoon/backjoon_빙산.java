import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_빙산 {
    static int n, m;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        solution(1);
    }

    private static void solution(int year){
        // 1. 바다 위치 저장
        Queue<Pos> sea = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0) sea.add(new Pos(i,j));
            }
        }

        // 2. 바닷물에 인접한 만큼 빙산의 높이 감소
        while(!sea.isEmpty()){
            Pos pos = sea.poll();
            for(int d=0; d<4; d++){
                int nx = pos.x + dx[d];
                int ny = pos.y + dy[d];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

                if(map[nx][ny]>0){
                    map[nx][ny] -= 1;
                }
            }
        }

        // 3. 빙산의 위치 저장
        Queue<Pos> ice = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]>0) ice.add(new Pos(i,j));
            }
        }

        // 4. 빙산이 모두 녹은 경우 0 출력
        if(ice.isEmpty()){
            System.out.println(0);
            return;
        }

        // 5. 빙산 덩어리 개수 확인
        int cnt = 0; 
        boolean[][] visit = new boolean[n][m]; 
        while(!ice.isEmpty()){
            Pos pos = ice.poll();
            if(!visit[pos.x][pos.y]){
                iceCount(pos.x, pos.y, visit);
                cnt++;
            }
        }

        // 6. 빙산 덩어리가 2개 이상인 경우 초최의 시간(년) 출력
        //    빙상 덩어리가 1개인 경우 반복 진행
        if(cnt>=2) System.out.println(year);
        else solution(year+1);

    }

    private static void iceCount(int x, int y, boolean[][] visit){
        visit[x][y] = true;
        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

            if(map[nx][ny]>0 && !visit[nx][ny]){
                iceCount(nx, ny, visit);
            }
        }
    }

    static class Pos{
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
