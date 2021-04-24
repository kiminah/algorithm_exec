import java.util.*;
public class backjoon_퇴사 {
    static int N;
    static int[] t, f, d;
    static int ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        t = new int[N+1];
        f = new int[N+1];
        d = new int[N+1]; // pay 저장

        for(int i=0; i<N; i++){
            t[i] = sc.nextInt();
            f[i] = sc.nextInt();
        }

        // N+1일째에는 회사에 없음
        // i 번째 일을 하면 i+t[j]에 돈을 받기 때문에
        // N+1 까지 진행
        for(int i=0; i<N+1; i++){
            for(int j=0; j<i; j++){
                d[i] = Math.max(d[i],d[j]);

                // 해당 기간동안 받은 돈
                if(j+t[j]==i){
                    d[i] = Math.max(d[i], d[j]+f[j]);
                }
            }
            // 최대값 갱신
            ret = Math.max(ret, d[i]);
        }

        System.out.println(ret);
    }

}
