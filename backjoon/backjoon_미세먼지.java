import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import java.utll.*;
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

        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        map = new int[R+1][C+1];

        air = new ArrayList<Dot>();
        dust = new LinkedList<Dot>();

        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                int input = sc.nextInt();
                map[i][j] = input;
                if(input == -1){
                    air.add(new Dot(i,j,input));
                }else if(input > 0){
                    dust.add(new Dot(i,j, input));
                }
            }
        }
        
        int[] c_up = new int[] {2, 1, 3, 0}; // 반시계 방향
        int[] c_down = new int[] {2, 0, 3, 1}; // 시계 방향
        
        spread();
        System.out.println("map----------------------");
        print_map();

        for(int i=0; i<T; i++){
            copy_map();

            circulate(air.get(0), c_up);
            circulate(air.get(1), c_down);

            System.out.println("----------------------");
            print_map();
        }

        calc();

        System.out.println(ret);
    }

    static void print_map(){
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    static void spread(){

        while(!dust.isEmpty()){
            Dot pos = dust.poll();
            for(int i=0; i<4; i++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx > 0 && nx <= R && ny > 0 && ny <= C){
                    if(map[nx][ny] != -1){
                        map[nx][ny] += pos.input/5;
                        map[pos.x][pos.y] -= pos.input/5;
                    }
                }
            }
        }
    }

    static void circulate(Dot pos, int[] d){
        int x = pos.x;
        int y = pos.y+1;

        map[x][y] = 0;
        for(int i=0; i<4; i++){
            while(true){
                int nx = x + dx[d[i]];
                int ny = y + dy[d[i]];
            
                if(!(nx > 0 && nx <= R && ny > 0 && ny <= C)) break;

                if(ny == pos.y && nx == pos.x) break;

                map[nx][ny] = copymap[x][y];
                x = nx;
                y = ny;
            }

        }

    }

    static void copy_map(){
        copymap = new int[R+1][C+1];
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                copymap[i][j] = map[i][j];
            }
        }
    }

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
