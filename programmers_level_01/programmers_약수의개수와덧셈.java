class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        boolean[] visit; // 약수 표시
        for(int num=left; num<=right; num++){
            visit = new boolean[num+1];
            // 1과 본인은 먼저 포함
            visit[1] = visit[num] = true;
            
            // 2부터 해당 수를 나눌 수 있는지 확인
            // 나눠지면서 포함시킨적 없는 수라면?
            // 그 수와 몫에 방문 표시
            for(int i=2; i<num; i++){
                if(num%i == 0 && !visit[i]){
                    visit[i] = visit[num/i] = true;
                }
            }
            
            // 방문한 수만 카운트
            int cnt = 0;
            for(int i=0; i<visit.length; i++){
                if(visit[i]) cnt++;
            }
            
            // 약수의 개수가 홀수이면 음수
            // 약수의 개수가 짝수이면 양수로 합산
            if(cnt%2 != 0) answer += num * -1;
            else answer += num;
            
        }
        
        
        return answer;
    }
}