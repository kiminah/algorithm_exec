import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class backjoon_촌수계산 {
    static StringTokenizer st;
    static int[][] relation;
    static boolean[] visit;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 전체 사람의 수
        int n = Integer.parseInt(br.readLine());

        // 서로 다른 두 사람의 번호
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 부모 자식들 간의 관계의 개수
        int m = Integer.parseInt(br.readLine());

        // 부모 자식간의 관계를 나타내는 두 번호 x, y
        relation = new int[n+1][n+1];
        visit = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            relation[x][y] = relation[y][x] = 1;
        }

        // 촌수 구하기
        solution(n,a,b,0);
        System.out.println(answer);
    }

    private static void solution(int n, int x, int y, int depth){
        visit[x] = true;
        
        // 찾고자 하는 다른 사람의 번호 y에 도달한 경우 depth(촌수) 저장
        if(x == y){
            answer = depth;
            return;
        }

        // 연결된 부모 자식간의 관계 확인 및 이동
        for(int i=1; i<=n; i++){
            if(relation[x][i] == 1 && !visit[i]){
                solution(n, i, y, depth+1);
            }
        }
    }
}