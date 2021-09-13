import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_백조의호수 {
    static Queue<Pos> swanList;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sc = br.readLine().split(" ");
        int R = Integer.parseInt(sc[0]);
        int C = Integer.parseInt(sc[1]);

        char[][] map = new char[R][C];
        // 1. create map
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(solution(map, R, C));

    }
    private static int solution(char[][] map, int R, int C){
        int answer = 0;

        visit = new boolean[R][C];
        LinkedList<Pos> waterPos = new LinkedList<>(); // 물의 위치
        swanList = new LinkedList<>(); // 백조의 위치 저장(매일 물로 이동하는 백조)
        Pos[] swanPos = new Pos[2]; // 백조 처음 위치

        int idx = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == '.' || map[i][j] == 'L'){
                    Pos pos = new Pos(i, j);
                    waterPos.add(pos);
                    if(map[i][j] == 'L'){
                        swanPos[idx++] = pos;
                    }
                }
            }
        }

        swanList.add(swanPos[0]); // 백조 처음 위치 추가
        visit[swanPos[0].x][swanPos[0].y] = true; // 다음번에 방문 못하게 만들기

        // 백조가 서로 만날 때까지 반복
        while(!isMeet(swanPos, map, R, C)){
            int len = waterPos.size(); 
            // 물 위치 담긴 크기만큼 반복
            // 물 주변에 얼음 있으면 물로 변환
            for(int i=0; i<len; i++){
                Pos pos = waterPos.poll();
                for(int j=0; j<4; j++){
                    int nx = pos.x + dx[j];
                    int ny = pos.y + dy[j];

                    if(isRange(nx, ny, R, C)){
                        if(map[nx][ny] == 'X'){
                            map[nx][ny] = '.';
                            // 새롭게 생성된 물의 위치 추가
                            // 반복문이 이전 물 list의 크기만큼만 반복되기 때문에
                            // 새롭게 생선된 물은 확인하지 않는다.
                            waterPos.add(new Pos(nx, ny)); 
                        }
                    }
                }
            }
            answer++; // day 증가
        }

        return answer;
    }
    // check meet swan
    private static boolean isMeet(Pos[] swanPos, char[][] map, int R, int C){

        Queue<Pos> move = new LinkedList<>(); // 이동 list

        while(!swanList.isEmpty()){
            Pos pos = swanList.poll(); // 백조가 이동할 수 있는 list

            // 백조 2를 만나면 반복문 종료
            if(pos.x == swanPos[1].x && pos.y == swanPos[1].y){
                return true;
            }
            for(int i=0; i<4; i++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(isRange(nx, ny, R, C) && !visit[nx][ny]){
                    // 얼음인 경우 이동 list에 추가
                    if(map[nx][ny] == 'X') move.add(new Pos(nx, ny));
                    // 물인 경우 백조 이동할 수 있는 list에 추가
                    else swanList.add(new Pos(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }

        // 반복문 종료 후, 백조가 이동할 수 있는 list를 전체map 이동 list로 변경
        // 불필요한 이동반경을 없애기 위한 처리
        swanList = move;

        return false;
    }

    private static boolean isRange(int x, int y, int R, int C){
        return (x>=0 && x<R && y>=0 && y<C);
    }

    static class Pos{

        int x, y;
    
        Pos(int x, int y){
    
            this.x = x;
            this.y = y;
    
        }
    }
}