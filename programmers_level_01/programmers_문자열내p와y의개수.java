class Solution {
    boolean solution(String s) {
        // 대소문자 구별하지 않음
        s = s.toUpperCase();
        
        // p와 y의 개수를 각각 count
        int p = 0;
        int y = 0;
        
        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i)=='P') p++;
            
            else if(s.charAt(i)=='Y') y++;
        }
        return p==y;

        /** 다른 사람 풀이 
         * 6~15줄 제외
         * return s.chars().filter(e -> e == 'P').count() == s.chars().filter(e -> e == 'Y').count();
         * 하지만 실행시간은 더 길다.
         */
    }
}