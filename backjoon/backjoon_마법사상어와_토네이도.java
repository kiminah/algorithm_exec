import java.util.*;
public class backjoon_마법사상어와_토네이도 {
    static int N;
    static int[][] map;
    static int[] dx = new int[] {1,-1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static int[] ratio = new int[] {1,1,2,2,7,7,10,10,5};
    static int[][] t_x = new int [][] {
        {-1,1,0,0,0,0,-1,1,0},
        {-1,-1,-2,2,-1,1,1,1,2},
        {-1,1,0,0,0,0,-1,1,0},
        {1,1,0,0,0,0,-1,-1,-2}
    };
    static int[][] t_y = new int [][] {
        {1,1,-2,2,-1,1,-1,-1,-2},
        {-1,1,0,0,0,0,-1,1,0},
        {-1,-1,-2,2,-1,1,1,1,1},
        {1,-1,-2,2,-1,1,1,-1,0}
    };
    static int ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int input = sc.nextInt();
                map[i][j] = input;
            }
        }

        move(N/2, N/2);
        System.out.println(ret);

    }

    public static void move(int x, int y){
        int k = 1;
        int sw = -1;
        int depth = 1;
        int x_ticks = x;
        int y_ticks = y;

        while(true){
            for(int i=0; i<k; i++){
                y_ticks += sw;
                if(y_ticks == -1) break;
                spread(x_ticks, y_ticks, depth);
            }
            depth++;
            if(depth==N) break;
            sw *= -1;
            for(int i=0; i<k; i++){
                x_ticks += sw;
                spread(x_ticks, y_ticks, depth);
            }
            k++;

        }
    }

    public static void spread(int x, int y, int d){
        int origin = map[x][y];
        int copy = origin;
        map[x][y] = 0;
        for(int i=0; i<9; i++){
            int dx = x + t_x[d%4][i];
            int dy = y + t_y[d%4][i];

            int sand = (ratio[i]* map[x][y])/100 
            copy -= sand            

            // 격자 밖으로 나간 모래의 양
            if(dx>=0 && dx<N && dy>=0 && dy<N){
                map[dx][dy] += sand;
            }else{
                ret += sand;
            }

        }
        origin = copy;
        int nx = x + t_x[d];
        int ny = y + t_y[d];
        if(dx>=0 && dx<N && dy>=0 && dy<N){
            map[nx][ny] += origin;
        }else{
            ret += origin;
        }
    }
}
