import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class backjoon_스타트링크 {
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken()); //전체 층수
        int s = Integer.parseInt(st.nextToken()); // 강호 위치
        int g = Integer.parseInt(st.nextToken()); // 스타트링크 위치
        int u = Integer.parseInt(st.nextToken()); // 위로 u층
        int d = Integer.parseInt(st.nextToken()); // 아래로 d층

        // 강호와 스타트링크의 위치가 같은 경우 0 출력
        if(s==g){
            System.out.println(0);
            return;
        }

        // 각 층마다 도착하는 최소값 저장
        cnt = new int[f+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        cnt[s] = 1;
        while(!q.isEmpty()){

            // 현재 층
            int prev = q.poll();

            // 위 또는 아래로 가는 경우의 수 2가지 모두 수행
            for(int i=0; i<2; i++){

                int next = prev;

                if(i==0) next += u; // 위로가는 경우
                else next -= d; // 아래로 가는 경우

                // 스타트링크 층에 도착한 경우 버튼 누른 최소값 출력
                if(next == g){
                    System.out.println(cnt[prev]);
                    return;
                }

                // U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다.
                // 다음 이동 층이 1층부터 f층 사이에 존재하는 경우와
                // 방문한 적 없는 층인 경우 버튼 cnt 증가
                if(next>0 && next<=f && cnt[next] == 0){
                    cnt[next] = cnt[prev] + 1;
                    q.add(next); // 다음 이동 층 큐에 추가
                }
            }
        }

        // 엘리베이터로 이동할 수 없는 경우
        System.out.println("use the stairs");
    }
}
