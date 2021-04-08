class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int idx=0; // 위치 인덱스
        int len=0; // 문자열 길이
        
        for(int i=0; i<k; i++){
            len = sb.length();
            idx = len-1; // j for문이 끝까지 갔을 경우 끝 문자가 제일 작다는 의미
            for(int j=0; j<len-1; j++){
                // 두 번째 문자가 크면 제거할 index 저장 후 반복문 종료
                if(sb.charAt(j)<sb.charAt(j+1)){
                    idx=j;
                    break;
                }
                // 만약 두번째 문자가 작다면 반복문 계속 진행
                // j가 len-1까지 갔는데도 큰 수를 발견하지 못하면
                // 끝 문자가 제일 작음
                // 위에서 선언한 idx=len-1이 그대로 적용됨
            }
            // 문자 제거
            sb.deleteCharAt(idx);            
        }
        
        // 문자열로 반환
        return sb.toString();
    }
}