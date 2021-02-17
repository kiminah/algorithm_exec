class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] sosu = new int[n+1];
        
        // 0과 1은 먼저 제외
        sosu[0]=1;
        sosu[1]=1;
        
        // 소수 아닌 숫자들은 1로 변경
        for(int i=2; i<=Math.sqrt(n); i++)
            if(sosu[i]==0)
                for(int j=i*2; j<=n; j+=i)
                    sosu[j]=1;
        
        // 소수인 숫자들의 개수
        for(int check:sosu)
            if(check==0)
                answer++;
        
        return answer;
    }
}