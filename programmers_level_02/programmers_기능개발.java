import java.util.*;
class Solution {
    Stack<Integer> st; // 가능한 작업
    ArrayList<Integer> al; // 배포 수
    int[] work;
    public int[] solution(int[] progresses, int[] speeds) {
        al = new ArrayList<>();
        st = new Stack<>();
        
        // 배포 가능 일자
        work = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            int w = (int)Math.ceil((float)(100-progresses[i])/speeds[i]);
            work[i] = w;
        }
        
        // 첫번째 작업 넣어두기
        st.push(work[0]);
        // 일자
        int day = work[0];
        
        // 작업이 1개 이상일 경우 진행
        if(work.length>1){
           for(int i=1; i<work.length; i++){
               // 앞의 작엽이 완료된 일수보다 크면 (현재 기능이 완료되지 않은 상태)
               // 해달 일수에 배포할 수 있는 최대 기능수를 저장하고
               // 그 다음 배포 일수를 저장한다.
               if(day<work[i]){
                    al.add(st.size());
                    st.clear();
                    day=work[i];
               }
               // 앞의 작업보다 먼저 작업을 완료한 상태이면
               // 일단 대기상태로 들어간다.
               st.push(work[i]);
            } 
        }
        
        // 마지막 남은 배포의 수를 넣어준다
        al.add(st.size());
        
        int[] answer = new int[al.size()];
        
        for(int i=0; i<al.size(); i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}