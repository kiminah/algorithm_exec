public class algorithm05_cycle {
    public static void main(String[] args) {
        // 26 2+6=8 -> 68 6+8=14 -> 84 8+4=12 -> 42 4+2=6 -> 26 4회
        // 05 0+5=5 -> 55 5+5=10 -> 50 5+0=5 -> 05 3회
        // 42 4+2=6 -> 26 2+6=8 -> 68 6+8=14 -> 84 8+4=12 -> 42 4회
        int num = 26;
        int res = num;

        int cnt = 0;

        do{
            // 각 자리수 구하기
            int sum = res/10 + res%10;
            res = res%10*10 + (sum%10);
            cnt++;
            
        }while (res != num);

        System.out.println(cnt);
    }
}
