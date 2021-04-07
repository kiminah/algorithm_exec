class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int len = sb.length(); // 문자열 길이
        int first = 0, second = 0; // 문자 앞뒤 비교를 위한 변수
        int cnt = 0; // 제거후 문자열의 길이
        
        
        while(k>0){
            
            // 제거된 문자열의 길이와 동일하면 반환
            if(cnt == len -1){
                return sb.substring(0,len-k);
            }else{
                cnt++;
                first = (int)sb.charAt(cnt-1) - '0';
                second = (int)sb.charAt(cnt) - '0';
                
                // 첫번째 수가 두번째 수보다 작으면 제거
                if(first < second){
                    sb.delete(cnt-1, cnt);
                    cnt=0;
                    len=sb.length();
                    k--;
                }
            }
        }
        return sb.toString();
    }
}