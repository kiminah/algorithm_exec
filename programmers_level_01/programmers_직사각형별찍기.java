import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // 가로 a인 별 찍기
        String str = "";
        for(int i=0; i<a; i++){
            str += "*";
        }

        // 가로 a인 별 세로 b만큼 출력
        for(int i=0; i<b; i++){
            System.out.println(str);
        }
    }
}