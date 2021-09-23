import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class backjoon_맥주마시면서걸어가기 {
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){

            // 1. 편의점 개수
            int store = Integer.parseInt(br.readLine());
            
            // 2. 좌표 입력 (상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표)
            List<int[]> list = new ArrayList<>();
            
            for(int i=0; i<2+store; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }


            // 3. 각 지점 방문
            boolean[] visit = new boolean[list.size()];
            result = false;
            solution(list, visit, 0);
            
            // 4. 결과 출력
            if(result){
                System.out.println("happy");
                continue;
            }
            System.out.println("sad");
        }
    }

    private static void solution(List<int[]> list, boolean[] visit, int prev){
        visit[prev] = true;
        
        // 1. 펜타포트 락 페스티벌 좌표에 도달한 경우 
        if(prev == list.size()-1){
            result = true;
            return;
        }

        // 2. 모든 지점 방문
        for(int i=1; i<list.size(); i++){
            
            // 맥주는 50m 마다 1병씩 마신다. 맥주 최대 개수는 20병이다.
            // 따라서, 1000m 내에 편의점 또는 페스티벌이 존재해야 한다.
            // 만약 1000m를 초과한 경우 맥주는 전부 마시고 없는 상태가 된다.
            if(dist(list, prev, i)<=1000 && !visit[i]){
                solution(list, visit, i);
            }
        }
    }
    private static int dist(List<int[]> list, int prev, int next){
        int[] o1 = list.get(prev);
        int[] o2 = list.get(next);

        return Math.abs(o1[0]-o2[0])+Math.abs(o1[1]-o2[1]);
    }
}