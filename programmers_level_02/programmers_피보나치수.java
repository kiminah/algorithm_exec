class Solution {
    long[] arr;
    public int solution(int n) {
        int answer = 0;
        // n이 1 이상 100000 이하인 자연수 이므로 100001 크기로 지정
        arr = new long[100001];
        
        // 1. 피보나치 수열의 0번째 1번째 값 미리 지정
        arr[0] = 0;
        arr[1] = 1;
        
        // 2. 피보나치 수 구하기
        //    n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴해야 하므로 
        //    모든 값에 1234567의 나머지 값 저장
        for(int i=2; i<=n; i++){
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        }
        
        // 3. arr 배열이 long 타입이므로 int형으로 변환 후 리턴
        answer = (int)arr[n];
        return answer;
    }
}