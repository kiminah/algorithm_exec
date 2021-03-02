import java.io.*;
import java.util.*;
public class codeup_1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\.");
        System.out.println(input[2]+"-"+input[1]+"-"+input[0]);
    }
}
