import java.util.*;
public class backjoon_피보나치수2 {
    static long[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     
        int N = sc.nextInt();
        // 각 수에 해당하는 피보나치 수 저장
        memo = new long[N+1]; 
        // 0과 겹치지 않기 위해 -1로 채우기
        Arrays.fill(memo, -1);
        System.out.println(fibo(N));
    }
    public static long fibo(int n){
        if(n<=1) return n;
        if(memo[n] == -1)
            memo[n] = fibo(n-1) + fibo(n-2);
        return memo[n];
    }
}