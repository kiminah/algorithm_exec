import java.util.*;
public class codeup_1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.close();
        int a = 10000;
        for(int i=0; i<5;i++){
            int out = input/a * a;
            System.out.println(out);
            input = input%a;
            a /= 10;
        }
    }
}
