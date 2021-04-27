import java.util.*;
public class backjoon_아기상어 {
    static int N;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        // 상어 위치 저장
        Queue<Shark> q = new LinkedList<>();
        int age = 2;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9){
                    q.add(new Shark(i, j, age));
                    map[i][j] = 0;
                }
            }
        }

        // 사냥 시작
        int eat = 0; // 먹은 물고기 수
        int time = 0; // 시간
        while(true){
            LinkedList<Shark> fish = new LinkedList<>(); // 물고기 거리 저장
            int[][] dist = new int[N][N];

            // 상어와 물고기와의 거리 저장
            while(!q.isEmpty()){
                Shark s = q.poll(); // 상어 현재 위치
                for(int i=0; i<4; i++){
                    int nx = s.x + dx[i];
                    int ny = s.y + dy[i];

                    // map 범위 안에 있고, 상어의 나이와 같거나 작으면 이동 가능
                    if(nx>=0 && nx<N && ny>=0 && ny<N && dist[nx][ny]==0 && map[nx][ny]<=age){
                        dist[nx][ny] = dist[s.x][s.y] + 1;
                        // 물고기는 1~6 의 숫자로 구성, 상어 나이보다 작으면 먹을 수 있음
                        if(map[nx][ny]>=1 && map[nx][ny]<=6 && map[nx][ny] < age){
                            fish.add(new Shark(nx,ny, dist[nx][ny]));
                            // 상어 위치 업데이트
                            q.add(new Shark(nx,ny, dist[nx][ny]));
                            continue;
                        }
                        // 먹을 물고기가 없다면 그냥 가기
                        q.add(new Shark(nx,ny, dist[nx][ny]));
                    }
                }
            }

            // 물고기 먹으러 가기
            // 먹을 물고기가 하나도 안 남은 경우
            if(fish.size() == 0){
                System.out.println(time);
                return;
            }
            // 가장 가까운 물고기
            Shark eatFish = fish.get(0);
            for(int i=1; i<fish.size(); i++){
                // 거리가 더 가까운 물고기를 먹기
                if(eatFish.dist > fish.get(i).dist){
                    eatFish = fish.get(i);
                }
                // 거리가 같은 물고기인 경우
                else if (eatFish.dist == fish.get(i).dist){
                    // 왼편 물고기 먼저 선택
                    if(eatFish.x > fish.get(i).x)
                        eatFish = fish.get(i);
                    else if(eatFish.x == fish.get(i).x){
                        if(eatFish.y > fish.get(i).y)
                            eatFish = fish.get(i);
                    }
                }
            }
            time += eatFish.dist; // 거리 1만큼 시간 1초 증가
            eat++; // 먹은 물고기 수 증가
            map[eatFish.x][eatFish.y] = 0; // 먹은 물고기는 지도에서 사라짐
            // 나이만큼 물고기를 먹으면 나이 증가
            if(eat == age){
                age++;
                eat = 0;
            }
            q.add(new Shark(eatFish.x, eatFish.y, age));
        }

    }
}

class Shark{
    int x, y, dist;
    Shark(int x, int y ,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}