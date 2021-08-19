class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int idx = 0;
        for(long num : numbers){
            // 이진수로 변환
            String num_str = Long.toBinaryString(num);
            // 연속된 1의 개수
            long cnt = count(num_str);
            // 1의 최소 1개를 갖고 있어야 한다.(짝수의 경우 이진수 끝이 0 이므로)
            if(cnt==0) cnt = 1;
            // 1의 개수만큼 10진법으로 더해주기
            else cnt = (long)Math.pow(2,cnt-1);
            
            answer[idx++] = num+cnt;
        }
        return answer;
    }
    public long count(String str){
        long cnt = 0;
        for(int i=str.length()-1; i>=0;i--){
            if(str.charAt(i)=='0') break;
            cnt++;
        }
        return cnt;
    }
}