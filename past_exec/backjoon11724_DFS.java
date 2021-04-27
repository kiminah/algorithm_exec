import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class backjoon11724 {
    static int n, m, cnt;
    static int[][] map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수

        map = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            StringTokenizer s = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s.nextToken());
            int v = Integer.parseInt(s.nextToken());

            map[u][v] = map[v][u] = 1;
        }

        visit = new boolean[n+1];

        cnt = 0;
        for(int i=1; i<=n; i++){
            if(!visit[i]){
                dfs(i);
                cnt++;
            }
            
        }
        System.out.println(cnt);
    }

    public static void dfs(int v){
        if(visit[v]) return;
        else{
            visit[v] = true;

            for(int i=1; i<=n; i++)
                if(map[v][i]==1)
                    dfs(i);
        }
    }
}