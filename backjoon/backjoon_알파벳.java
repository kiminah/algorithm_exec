import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_알파벳 {
    static StringTokenizer st;
    static char[][] map;
    static Set<Character> set;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for(int i=0; i<r; i++){
            map[i] = br.readLine().toCharArray();
        }

        set = new HashSet<>();
        solve(r, c, 0, 0);

        System.out.println(answer);
    }

    private static void solve(int r, int c, int x, int y){
        // 1. 지난적 있는 알파벳인 경우
        if(!set.add(map[x][y])){
            // 말이 지난 칸의 최대값
            answer = Math.max(answer,set.size());
            return;
        }

        // 2. 말 이동
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<r && ny>=0 && ny<c){
                solve(r, c, nx, ny);
            }
        }
        
        // 3. 새로운 루트를 찾기 위해 지나온 알파벳 제거
        set.remove(map[x][y]);
    }
}