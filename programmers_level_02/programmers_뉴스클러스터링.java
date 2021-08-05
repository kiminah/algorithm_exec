import java.util.*;
class Solution {
    int total_cnt = 0;
    public int solution(String str1, String str2) {
        int answer = 0;
        // 대소문자 차이 무시
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        // 같은 문자인 경우
        if(str1.equals(str2))
            return 65536;
        
        // 1. 각 문자별 원소생성
        String[] arr1 = union(str1);
        String[] arr2 = union(str2);

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // 2. 교집합 
        Set<String> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            String tmp = arr1[i];
            if(set.add(tmp)){
                
                int a = 0;
                int b = 0;
                
                for(String arr:arr1)
                    if(arr.equals(tmp)) a++;
                
                for(String arr:arr2)
                    if(arr.equals(tmp)) b++;
                
                total_cnt += Math.min(a,b);
            }
        }
        
        answer = (arr1.length + arr2.length) - total_cnt;
        answer = (int)((double)total_cnt/answer * 65536);
        
        return answer;
    }
    public String[] union(String str){
        String result = "";
        String tmp = "";
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'A' && c<='Z'){
                tmp += c;
            }else{
                tmp = "";
            }

            if(tmp.length()==2){
                result += tmp + ",";
                tmp = c+"";
            }
        }
        result = result.substring(0,result.length()-1);
        return result.split(",");
        
    }
}