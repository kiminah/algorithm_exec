class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 3진법으로 전환하며 바로 앞뒤 반전 수행
        String tmp = "";
        for(;n>0;n/=3){
            tmp += Integer.toString(n%3);
        }
        
        // 10진법 전환
        int ln = (int)Math.pow(3,tmp.length()-1);
        for(int i=0; i<tmp.length(); i++){
            int a = Integer.parseInt(tmp.charAt(i)+""); // 숫자로 전환
            answer += a * ln;
            ln /= 3;
        }
        
        return answer;
    }
}