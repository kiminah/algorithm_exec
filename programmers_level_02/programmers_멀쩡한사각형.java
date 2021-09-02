class Solution {
    public long solution(int w, int h) {
        // 최소공배수
        long g = gcb(w,h);

        // 총 정사각형 개수 - 사용할수 없는 정사각형 개수
        return ((long)w*h - (((long)w/g + (long)h/g - 1) * g));
    }

    public long gcb(int a, int b){
        if(a>b)
            return (a%b==0) ? b:gcb(b, a%b);
        else
            return (b%a==0) ? a:gcb(a, b%a);
    }
}

/** 최대공약수 : BigInteger 클래스의 내장 함수 gcd
import java.math.BigInteger;
int g = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
 */