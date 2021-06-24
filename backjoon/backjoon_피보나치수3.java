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
    static int pisano;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     
        long N = sc.nextLong();
        pisano = 1500000; // 피사노 주기
        memo = new long[pisano]; 
        memo[0] = 0;
        memo[1] = 1;
        for(int i=2; i<pisano; i++)
            memo[i] = (memo[i-1]+memo[i-2]) % 1000000;
        
        if(N >= pisano) N %= pisano;

        // N이 long 형태이기 때문에 int형으로 변경해줘야 함
        System.out.println(memo[(int)N]);
    }
}