import java.util.*;
public class backjoon_평범한배낭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        // 1. 물품의 수, 버틸 수 있는 무게 입력
        int N = sc.nextInt();
        int K = sc.nextInt();
        // 2. 각 물건의 무게와 가치 입력
        int[] W = new int[N];
        int[] V = new int[N];
        for(int i=0; i<N; i++){
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }
        int[] tmp = new int[K+1]; // 이전 배낭에 들어있는 가치
        int[] result = new int[K+1]; // 결과 값
        // 3. 배낭의 무게마다 들어간 물건의 무게
        for(int i=0; i<N; i++){
            // 3-1. 가치가 높은 물건으로 갱신
            for(int j=W[i]; j<=K; j++){
                // tmp[j] 는 원래 배낭에 있던 물건의 가치

                // tmp[j-W[i]]+V[i] 는 i번째 물건의 가치를 추가한 가치
                // 즉, j-W[i]번째 무게에 i번째 무게의 가치를 더한 값이다.
                // 이 둘을 비교하여 가치가 더 큰 값으로 교체
                result[j] = Math.max(tmp[j], tmp[j-W[i]]+V[i]);
            }
            // 3-2. 새롭게 변경된 가치 합산 갱신
            tmp = result.clone();
        }
        System.out.println(result[K]);
    }
}