class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        // 두 참가자가 처음 라운드에서 만나는 경우
        if(a%2==0 && b == a-1) return 1;
        else if(a%2 != 0 && b == a+1) return 1;
            
        while(answer < n/2){
            answer++;

            // 라운드 마다 참가자 번호 갱신
            if(a != 1) a = (int)Math.ceil((double)a/2);
            if(b != 1) b = (int)Math.ceil((double)b/2);
            
            // 두 참가자가 만나는 경우 라운드 반환
            if(a%2==0 && b == a-1) return answer;
            else if(a%2 != 0 && b == a+1) return answer;
        }
        
        return answer;

        /** 실행 시간이 더 짧은 코드
        int round = 0;
        // 두 참가자가 같은 참가자 번호인 경우 반복문 종료
        while(a != b)
        {
            // 두 참가자의 참가자 번호 갱신
            a = a/2 + a%2;
            b = b/2 + b%2;
            
            round++;
        }
        return round;
          
         */
    }
}