import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_숨바꼭질 {
    static int n, k;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        time = new int[100001];

        // 같은 위치에 있는 경우 0 출력
        if(n==k) System.out.println(0);
        // 서로 다른 위치에 있는 경우 최단 시간 출력
        else solution();
    }
    private static void solution(){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n] = 1;

        while(!q.isEmpty()){
            int prev = q.poll();

            for(int i=0; i<3; i++){
                int next = prev;

                if(i==0) next -= 1;
                else if(i==1) next += 1;
                else next *= 2;

                // 동생의 위치에 도착하면 시간 출력
                if(next == k){
                    System.out.println(time[prev]);
                    return;
                }

                // 다음숫자가 범위내에 있고 해당 숫자를 방문한 적이 없는 경우
                if(next>=0 && next < time.length && time[next] == 0){
                    time[next] = time[prev] + 1;
                    q.add(next);
                }

            }

        }

    }
}
