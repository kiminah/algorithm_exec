class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n];
        // 체육복 정보 1로 초기화
        for(int i=0; i<n; i++)
            student[i]=1;    
        // 학생별 체육복 정보 세팅
        // 체육복 도난당한 학생
        for(int i=0; i<lost.length; i++){
            int index=lost[i]-1;
            student[index]--;
        }
        // 체육복 여벌 가져온 학생
        for(int i=0; i<reserve.length; i++){
            int index=reserve[i]-1;
            student[index]++;
        }
        
        // 죄측 > 우측 순으로 체육복 빌려줄지 결정
        int len = student.length;
        for(int i=0; i<len; i++){
            // 본인 이전 학생이 체육복 0인경우
            if(i!=0 && student[i-1]==0){
                // 본인이 여벌 체육복이 있는 경우
                if(student[i]==2){
                    student[i]--;
                    student[i-1]++;
                }else{
                    continue;
                } 
            }
                
            // 본인 다음 학생이 체육복 0인 경우
            if(i!=len-1 && student[i+1]==0){
                // 본인이 여벌 체육복이 있는 경우
                if(student[i]==2){
                    student[i]--;
                    student[i+1]++;
                }else{
                    continue;
                }
            }
        } // 체육복 배분 종료
        
        // 체육수업 들을 수 있는 학생
        for(int i=0; i<len; i++){
            if(student[i]>=1) 
                answer++;
        }
        
        
        return answer;
    }
}