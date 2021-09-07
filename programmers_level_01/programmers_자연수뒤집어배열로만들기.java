class Solution {
    public int[] solution(long n) {
        
        // 1. n 자릿수별로 배열 생성
        String[] arr = Long.toString(n).split("");
        int[] answer = new int[arr.length];

        // 2. 뒤에서부터 배열에 넣기
        for(int i=0; i<arr.length; i++){
            answer[arr.length-1-i] = Integer.parseInt(arr[i]);
        }
        
        /** 다른 방법(효율적)        
            int[] answer = new int[String.valueOf(n).length()];
            int idx = 0;
            // n을 10으로 나누기를 반복
            while(n>0){
                answer[idx++] = (int)(n%10); // 10으로 나눈 나머지값 넣기
                n /= 10; // n의 값 10으로 나눈 몫으로 갱신
            }
         */

         return answer;
    }
}