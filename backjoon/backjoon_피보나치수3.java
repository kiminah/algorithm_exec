import java.util.*;
public class backjoon_피보나치수3 {
    /** 피사노 주기?
     *  피보나치 수를 나눈 나머지는 항상 주기를 가진다.
     * 피보나치 수를 나눌 수를 K라고 할때 K=10의 n승이면
     * 피사노 주기는 15 x 10의 n-1 승
     * 
     * 즉, K가 1,000,000이면 피사노 주기는 1,500,000
     */
    static long[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     
        long N = sc.nextLong();
        memo = new long[10000];
        // 0과 겹치지 않기 위해 -1로 채우기
        Arrays.fill(memo, -1);
        System.out.println(fibo((int)N));
    }

    public static long fibo(int n){
        if(n<=1) return n;
        if(memo[n] == -1)
            memo[n] = fibo(n-1) + fibo(n-2);
        return memo[n];
    }
}