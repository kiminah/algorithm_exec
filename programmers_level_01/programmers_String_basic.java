class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        // 문자열 길이 4 혹은 6인 경우만 수행
        if(len==4 || len==6){ 
            for(int i=0; i<len;i++){
                char c = s.charAt(i);
                // 문자가 들어 갔는 지의 여부 확인
                if(c>='a' && c<='z')
                    return false;
            }
        }else{ // 문자열 길이 4 혹은 6이 아닌경우 false 반환
            return false;
        }
        
        return answer;
    }
}