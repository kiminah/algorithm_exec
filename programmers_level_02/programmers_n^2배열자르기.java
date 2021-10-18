class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];

        int idx = -1;

        // 1. 시작 열 지정
        int start = (int)(left%n);

        // 2. 행은 left/n 행부터 시작해서 right/n행까지 진행
        for(int i=(int)(left/n); i<=(int)(right/n); i++){
            
            for(int j=start; j<n; j++){
                
                // 2-1. 행열 값의 최대값 + 1 인 값 넣기
                answer[++idx] = Math.max(i,j) + 1;
                
                // 2-2. 배열 다 채우면 반복문 종료
                if(idx==right-left) break;
            }
            
            // 2-3. 시작열 0으로 초기화
            start = 0;
        }

        return answer;
    }
}