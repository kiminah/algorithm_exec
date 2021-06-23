import java.util.*;
public class backjoon_피보나치수 {
    // 각 수에 해당하는 피보나치 수 저장
    // n은 45보다 작거나 같은 자연수
    static int[] memo = new int[46];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
    }
    public static int fibo(int n){
        // 0과 1의 피보나치 수는 0, 1 이기 때문에
        // 들어온 n의 값 그대로 반환
        if(n<=1) return n;
        // 2의 경우 피보나치 수가 1이기 때문
        else if(n==2) return 1;
        else{
            // 저장된 값이 0보다 크면 저장된 값을 사용
            if(memo[n]>0) return memo[n];
            // 피보나치 수는 본인의 이전 값과 그 이전값의 합
            memo[n] = fibo(n-1) + fibo(n-2);
            return memo[n];
        } 
    }
}
