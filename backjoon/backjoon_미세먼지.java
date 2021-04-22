import java.util.*;
public class backjoon_미세먼지 {
    static int R, C, T;
    static ArrayList<Dot> air;
    static Queue<Dot> dust;
    static int[][] map;
    static int[][] copymap;
    static int[] dx = new int[] {1,-1,0,0};
    static int[] dy = new int[] {0,0,1,-1};
    static int ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt(); // 행
        C = sc.nextInt(); // 열
        T = sc.nextInt(); // 초

        map = new int[R+1][C+1];

        air = new ArrayList<Dot>(); // 공기청정기 위치

        // map 구성
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                int input = sc.nextInt();
                map[i][j] = input;

                // 공기청정기 위치 저장
                if(input == -1){
                    air.add(new Dot(i,j,input));
                }
            }
        }
        
        int[] c_up = new int[] {2, 1, 3, 0}; // 반시계 방향
        int[] c_down = new int[] {2, 0, 3, 1}; // 시계 방향
      

        // T초 동안 미세먼지의 확산과 공기청정기 가동
        for(int i=0; i<T; i++){
            spread();
            copy_map();
            circulate(air.get(0), c_up);
            circulate(air.get(1), c_down);
        }

        // 미세먼지 합산
        calc();
        System.out.println(ret);
    }
    
    // 미세먼지의 확산
    static void spread(){
        dust = new LinkedList<Dot>();

        // 미세먼지 초기 위치 저장
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(map[i][j] > 0){
                    dust.add(new Dot(i,j, map[i][j]));
                } 
            }
        }

        // 저장한 미세먼지 초기 위치가 다 poll 될 떄까지 반복
        while(!dust.isEmpty()){
            Dot pos = dust.poll();
            for(int i=0; i<4; i++){
                // 하상우좌로 이동
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                // map 범위 내에 존재하는 경우 진행
                if(nx > 0 && nx <= R && ny > 0 && ny <= C){
                    if(map[nx][ny] != -1){
                        map[nx][ny] += pos.input/5;
                        map[pos.x][pos.y] -= pos.input/5;
                    }
                }
            }
        }
    }

    // 공기청정기 바람 불 때 미세먼지 이동
    static void circulate(Dot pos, int[] d){
        int x = pos.x;
        int y = pos.y+1;

        // 공기청정기 나오는 바로 앞은 0
        map[x][y] = 0;

        // 시계방향 또는 반시계 방향으로 진행
        for(int i=0; i<4; i++){
            while(true){
                int nx = x + dx[d[i]];
                int ny = y + dy[d[i]];
            
                // 공기청정기 궤도 안쪽이면 break
                if(!(nx > 0 && nx <= R && ny > 0 && ny <= C)) break;

                // 순환하여 공기청정기로 다시 되돌아오면 break
                if(ny == pos.y && nx == pos.x) break;

                // 이동
                map[nx][ny] = copymap[x][y];
                x = nx;
                y = ny;
            }
        }
    }

    // map 복사
    static void copy_map(){
        copymap = new int[R+1][C+1];
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                copymap[i][j] = map[i][j];
            }
        }
    }

    // 미세먼지의 합
    static void calc(){
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(map[i][j] > 0) 
                    ret += map[i][j];
            }
        }
    }
}

class Dot{
    int x, y, input;

    Dot(int x, int y, int input){
        this.x = x;
        this.y = y;
        this.input = input;
    }
}
