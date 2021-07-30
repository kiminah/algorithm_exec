class Solution {
    public String solution(String p) {

        // 1. 빈 문자열 또는 올바른 괄호 문자열 확인
        if(p.equals("") || check(p)) return p;
        
        String u="",v="";
        int cnt = 0;

        // 2. u, v 분리
        for(int i=0; i<p.length(); i++){
            // 2-1. 균형잡힌 괄호 문자열 판별
            if(p.charAt(i)=='(') cnt++;
            else cnt--;
            // 2-2. 균형잡힌 괄호 문자열, v 분리
            if(cnt == 0){
                u = p.substring(0,i+1);
                v = p.substring(i+1);
                break;
            }
        }
        
        // 3. 올바른 괄호 문자열 확인
        if(check(u)) return u + solution(v); 
        
        // 4. 아닌 경우 올바른 괄호 문자열로 변경
        String str = "(" + solution(v) + ")";
        
        for(int i=1; i<u.length()-1; i++){
            str += (u.charAt(i)=='('?")":"(");
        }
        
        return str;
    }
    public boolean check(String u){
        int st = 0;
        for(int i=0; i<u.length();i++){
            if(u.charAt(i)=='(') st++;
            else st--;
            
            if(st<0) return false;
        }
        return st == 0;
    }
}