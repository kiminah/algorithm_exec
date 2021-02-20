import java.util.Arrays;

public class algorithm02_fibo {
    public static void main(String[] args) {
        int[] fibo = new int[10];
        fibo[0]=1;
        fibo[1]=1;

        //An = An-1 + An-2
        // a1 = 1, a2 = 1

        for(int i=2; i<10; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        for(int i=0; i<10; i++){
            System.out.println(fibo[i]);
        }

        
        //2번째 방법
        int prePrevNum = 1;
        int preNum = 1;

        System.out.print(prePrevNum + " ");
        System.out.print(preNum + " ");


        for(int i=3; i<10; i++){
            int nNum = preNum + prePrevNum;
            System.out.print(nNum + " ");
        }
        

    }
}
