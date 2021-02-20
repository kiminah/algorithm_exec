import java.util.Arrays;

public class algorithm04_string {
    // 문자열 뒤집기
    public static void main(String[] args) {
        String str = "ADEFH";
        char[] new_str = str.toCharArray();
        System.out.println(str);
        int len = str.length();

        for(int i=0; i<len/2;i++){
            char temp = new_str[i];
            new_str[i] = new_str[len-i-1];
            new_str[len-i-1] = temp;

        }
        
        str = new String(new_str);
        System.out.println(str);
    }
}
