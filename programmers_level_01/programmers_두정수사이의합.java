class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int num1=a; // 작은수
        int num2=b; // 큰수
        
        if(a==b){ return a;} // 두 수가 같은 경우 둘 중 아무 수나 리턴
        else if(a>b){ // a와 b 대소 비교
            num1=b;
            num2=a;
        }
        
        for(int i=num1; i<=num2; i++){
            answer += i;
        }
        
        return answer;
    }
}