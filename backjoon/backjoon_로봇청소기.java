import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class backjoon_로봇청소기 {
    static int n,m,result;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        result = 1;

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        solution(r,c,d);
        System.out.println(result);
    }

    private static void solution(int r, int c, int d){
        // 1. 현재위치 청소
        map[r][c] = -1;

        // 2. 현재 방향을 기준으로 왼쪽 청소여부 확인
        for(int i=0; i<4; i++){
            // 2-1. 현재 방향의 왼쪽방향으로 전환
            d = (d+3)%4; // 방향 갱신
            int nx = r + dx[d];
            int ny = c + dy[d];

            // 2-2. 청소여부 확인
            if(nx>=0 && nx<n && ny>=0 && ny<m){
                if(map[nx][ny] == 0){
                    result++;
                    solution(nx,ny,d);

                    // 되돌아오는 경우를 없애기 위한 return
                    // 이동하면 바로보는 방향으로 후진해야하기 때문
                    return;
                }
            }
        }

        // 3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우 후진
        //    네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향도 벽인 경우 작동 종료
        int back = (d+2)%4;
        int nx = r + dx[back];
        int ny = c + dy[back];
        if(nx>=0 && nx<n && ny>=0 && ny<m){
            if(map[nx][ny] != 1){
                // 바라보는 방향 유지한 채로 한 칸 후진하고 다시 인접한 칸 탐색
                solution(nx,ny,d);
            }
        }
    }
}
