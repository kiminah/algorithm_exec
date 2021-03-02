import java.util.*;
public class Dijkstra_a {
    static int v = 6;
    static int[][] map;
    static boolean[] visit;
    static int[] d;
    public static void main(String[] args) {
        map = new int[][] {
            {0, 2, 5, 1, 0, 0},
            {2, 0, 3, 0, 2, 0},
            {5, 3, 0, 3, 1, 5},
            {1, 0, 3, 0, 1, 0},
            {0, 2, 1, 1, 0, 2},
            {0, 0, 5, 0, 2, 0}
        };

        visit = new boolean[v];
        d = new int[v];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        course(0);

        System.out.println(Arrays.toString(d));
    }

    public static int getSmall(){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0 ; i<v; i++){
            if(!visit[i] && d[i] != Integer.MAX_VALUE){
                if(d[i]<min){
                    min=d[i];
                    index = i;
                }
            }
        }
        return index;
    }

    public static void course(int start){
        visit[start] = true;
        
        for(int i=0; i<v-1; i++){
            int current = getSmall();
            visit[current] = true;
            for(int j=0; j<v; j++){
                if(!visit[j] && map[current][j] != 0){
                    if(d[current] + map[current][j] < d[j]){
                        d[j] = d[current] + map[current][j];
                    }
                }
            }
        }
    }
}
