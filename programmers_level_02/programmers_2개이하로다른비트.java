class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int idx = 0; // answer 넣을 index

        for(long num : numbers){
            long next = num; // 다음 수
            int cnt = Integer.MAX_VALUE; // 다른 비트의 개수
            // 다른 비트의 개수가 2개 이하이면 종료
            while(cnt > 2){
                next++;
                cnt = Long.toBinaryString(num^next).replaceAll("0", "").length();
            }
            answer[idx++] = next;
        }
        
        return answer;
    }
}