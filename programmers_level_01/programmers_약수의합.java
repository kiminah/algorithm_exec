class Solution {
    public int solution(int n) {
        int answer = n; // 자기 자신 포함

        // 1을 제외한 약수의 최소값이 2이다.
        // 2가 만약 약수에 포함이 된다면 2의 몫도 약수에 포함이 된다.
        // 따라서 2의 몫 n/2 까지만 반복하면 약수를 구할 수 있다.
        for(int i=1; i<=n/2; i++){
            if(n%i !=0) continue;
            answer += i;
        }
        
        return answer;
    }
}