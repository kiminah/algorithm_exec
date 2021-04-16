import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class backjoon_구슬탈출2 {

    static int[] dx = new int[] {1,-1,0,0};
    static int[] dy = new int[] {0,0,1,-1};
    static int[][] map;
    static boolean[][][][] visit;
    static int N, M;
    static boolean flag=false;
    static int cnt = 0; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new int[N][M];
        visit = new boolean[N][M][N][M];
        int irx=0, iry=0, ibx=0, iby=0, ihx=0, ihy=0;

        // 맵 생성
        for(int i=0; i<N; i++){
            String[] m = sc.nextLine().split("");
            for(int j=0; j<M; j++){
                if(m[j].equals("#")) map[i][j] = 1;
                else if(m[j].equals(".")) map[i][j] = 0;
                else if(m[j].equals("O")){
                    map[i][j] = 2;
                    ihx = i;
                    ihy = j;
                }
                else if(m[j].equals("R")){
                    irx = i;
                    iry = j;
                }
                else if(m[j].equals("B")){
                    ibx = i;
                    iby = j;
                }
            }
        }
        
        bfs(irx, iry, ibx, iby, ihx, ihy);

        int answer = 0;
        if(flag) answer = cnt;
        else answer = -1;

        System.out.println(answer);
    }

    static public void bfs(int irx, int iry, int ibx, int iby, int hx, int hy){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {irx, iry, ibx, iby});

        visit[irx][iry][ibx][iby] = true;

        while(!q.isEmpty()){
            int[] location = q.poll();

            for(int i=0; i<4; i++){
                int rx = location[0] + dx[i];
                int ry = location[1] + dy[i];
                int bx = location[2] + dx[i];
                int by = location[3] + dy[i];
                
                if(!(rx > 0 && rx < N-1 && ry > 0 && ry < M-1)) continue;
                if(!(bx > 0 && bx < N-1 && by > 0 && by < M-1)) continue;

                if(cnt > 10) break;

                if(rx==hx && ry==hy){
                    flag = true;
                    break;
                }
                // red ball
                while(true){
                    // 벽을 만나면 후진
                    if(map[rx][ry]==1){
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }
                    // 출구를 만나면 반복문 종료
                    if(map[rx][ry]==2) break;
                    // 길이면 같은 방향으로 끝까지 이동
                    rx += dx[i];
                    ry += dy[i];
                }

                // blue ball
                while(true){
                    // 벽을 만나면 후진
                    if(map[bx][by]==1){
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }
                    // 출구를 만나면 반복문 종료
                    if(map[bx][by]==2) break;
                    // 길이면 같은 방향으로 끝까지 이동
                    bx += dx[i];
                    by += dy[i];
                }
                // 파란 구슬이 구멍에 빠졌을때
                if(bx == hx && by == hy) continue;

                // 구슬이 같은 위치로 겹쳤을 때
                if(rx == bx && ry == by){
                    switch(i){
                        case 0: if(irx > ibx) rx++; else bx++; break;
                        case 1: if(irx < ibx) rx--; else bx--; break;
                        case 2: if(iry > iby) ry++; else by++; break;
                        case 3: if(iry < iby) ry--; else by--; break;
                    }
                }

                if(!visit[rx][ry][bx][by]){
                    visit[rx][ry][bx][by] = true;
                    q.add(new int[] {rx,ry,bx,by});
                }
            }
            if (flag) break;
            else cnt++;
        }

        return;

    }

}
