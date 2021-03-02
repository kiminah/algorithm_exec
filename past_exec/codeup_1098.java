import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class codeup_1098 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] map = new int[w][h];

        int n = Integer.parseInt(br.readLine()); // 막대의 개수
        

        for(int i=0; i<n; i++){
            StringTokenizer bar = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(bar.nextToken());
            int d = Integer.parseInt(bar.nextToken());
            int x = Integer.parseInt(bar.nextToken());
            int y = Integer.parseInt(bar.nextToken());
            for(int j=0; j<l;j++){
                if(d==0){
                    map[x-1][y-1+j] = 1;

                }
                else{
                    map[x-1+j][y-1] = 1;
                }
                
            }

        }

        printmap(map, w, h);
    }

    public static void printmap(int[][] map, int w, int h){
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
