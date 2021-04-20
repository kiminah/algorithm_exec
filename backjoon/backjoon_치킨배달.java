import java.util.*;
public class backjoon_치킨배달 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, ret;
    static ArrayList<Dot> house;
    static ArrayList<Dot> shop;
    static int[] output;
    static boolean[] visit;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 베열 크기
        M = sc.nextInt(); // 최대 치킨집 개수

        house = new ArrayList<Dot>(); // 집 위치 저장
        shop = new ArrayList<Dot>(); // 치킨집 위치 저장

        // 치킨집과 집의 좌표 저장
        for(int i=0; i<N; i++){
            for(int j=0; j<N;j++){
                int input = sc.nextInt();
                if(input == 1){
                    // 1일때 집에 저장
                    house.add(new Dot(i,j));
                }else if(input == 2){
                    // 2일때 치킨집에 저장
                    shop.add(new Dot(i,j));
                }
            }
        }

        visit = new boolean[shop.size()]; // 방문여부
        output = new int[shop.size()]; // 선택한 치킨집

        ret = INF;

        // 치킨집 선택
        for(int i=0; i<shop.size(); i++){
            visit[i] = true;
            dfs(i, 0);
            visit[i] = false;
        }

        System.out.println(ret);

    }

    static void dfs(int pos, int depth){
        output[depth] = pos;

        // 최대 치킨집 개수가 채워지면
        // 집에서 가장 가까운 치킨집의 거리 계산
        if(depth == M-1){
            int sum = 0;
            for(int i=0; i<house.size(); i++){
                int min_dist= INF;
                for(int j=0; j<M; j++){
                    // 최소거리
                    min_dist = Math.min(min_dist, calc(house.get(i), shop.get(output[j])));
                }
                // 최소 거리의 합산
                sum += min_dist;
            }
            
            // 최소 거리의 합산이 최소면 변경
            ret = Math.min(ret, sum);
        }

        for(int i=pos; i<shop.size(); i++){
            if(visit[i]) continue;
            visit[i] = true;
            dfs(i, depth+1);
            visit[i] = false;
        }
    }

    // 거리 계산
    static int calc(Dot d1, Dot d2){
        return Math.abs(d1.x - d2.x) + Math.abs(d1.y - d2.y);
    }

}

class Dot {
    int x, y;

    Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
}