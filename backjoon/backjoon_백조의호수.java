import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Main {
    static char[][] map;
    static char[][] copy;
    static boolean[][] visit;
    static ArrayList<Pos> duck;
    static Queue<Pos> ice;
    static Queue<Pos> q;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sc = br.readLine().split(" ");
        int R = Integer.parseInt(sc[0]);
        int C = Integer.parseInt(sc[1]);

        map = new char[R][C];
        duck = new ArrayList<>();
        ice = new LinkedList<>();

        // 1. create map
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
                if(str.charAt(j) == 'L')
                    duck.add(new Pos(i, j));
                else if(str.charAt(j)=='X')
                    ice.add(new Pos(i,j));
            }
        }

        copy = new char[R][C];
        int answer = 0;
        while(true){
            boolean meet = meet_duck(duck.get(0), duck.get(1),R, C);
            if(meet) break;
            copy_map(R, C);
            melt_ice(R, C);
            ++answer;
        }

        // 2. melting ice
        System.out.println(answer);

    }
    public static void copy_map(int R, int C){
        for(int i=0; i<R; i++){
            copy[i] = map[i].clone();
        }
    }
    public static void melt_ice(int R, int C){
        int l = ice.size();
        for(int i=0; i<l; i++){
            Pos pos = ice.poll();
            for(int j=0; j<4; j++){
                int nx = pos.x + dx[j];
                int ny = pos.y + dy[j];

                if(nx>=0 && nx<R && ny>=0 && ny<C){
                    if(copy[nx][ny]=='.') {
                        map[pos.x][pos.y] = '.';
                    }
                }
            }
            if(map[pos.x][pos.y]=='X')
                ice.add(new Pos(pos.x, pos.y));
        }
    }

    // check meet duck
    public static boolean meet_duck(Pos dPos1, Pos dPos2, int R, int C){

        q = new LinkedList<>();
        visit = new boolean[R][C];
        q.add(new Pos(dPos1.x, dPos1.y));
        visit[dPos1.x][dPos1.y] = true;
        while(!q.isEmpty()){
            Pos pos = q.poll();
            for(int i=0; i<4; i++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(dPos2.x == nx && dPos2.y == ny) return true;

                if (nx>=0 && nx<R && ny>=0 && ny<C && !visit[nx][ny]){
                    if(map[nx][ny] == '.'){
                        visit[nx][ny] = true;
                        q.add(new Pos(nx, ny));
                    }
                }
            }
        }
        return false;
    }
    
}

class Pos{
    int x, y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}