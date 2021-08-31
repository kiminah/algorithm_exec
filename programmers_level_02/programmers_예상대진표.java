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
    }
}