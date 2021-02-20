import java.util.Scanner;
import java.util.Arrays;
public class algorithm03_palindrome {
    public static void main(String[] args) {

        String n = "12321";
        boolean flag = true;
        for(int i=0; i<n.length()/2;i++){
            if(n.charAt(i)!=n.charAt(n.length()-i-1)){
                flag = false;
                break;
            }
        }

        System.out.println(flag);
        
    }
}
