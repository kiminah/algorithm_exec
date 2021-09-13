import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_안전영역 {
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // map 생성
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(solution(map));
    }

    private static int solution(int[][] map){
        int answer = 1; // 최소 안전지역 수

        for(int h=1; h<101; h++){
            cnt = 0; // 안전지역 수
            
            visit = new boolean[N][N];

            // 침수피해가 일어나지 않는 마을 count
            for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                    if(map[x][y] > h && !visit[x][y]){
                        cnt += safeArea(map, x, y, h);
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    private static int safeArea(int[][] map, int x, int y, int h){
        visit[x][y] = true;

        // 상하좌우만 확인
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny<N){
                if(map[nx][ny] > h && !visit[nx][ny])
                    safeArea(map, nx, ny, h);
            }
        }
        return 1;
    }
}