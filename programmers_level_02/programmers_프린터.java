import java.util.*;
class Solution {
    Queue<Printer> q;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        q = new LinkedList<>();
        
        // 큐에 인쇄 목록 담기
        for(int i=0; i<priorities.length; i++){
            q.add(new Printer(i, priorities[i]));
        }
        
        // 인쇄목록 비어있을때까지 반복
        while(!q.isEmpty()){
            Printer doc = q.poll(); // 첫번째 작업
            
            boolean flag = false;
            for(Printer p : q){
                if(doc.prior < p.prior){ // 뒤에 중요도가 큰 작업이 있을 경우
                    flag  = true;
                }
            }
            
            if(flag) // 중요도가 큰 작업이 뒤에 있는 경우 현재 작업 뒤로 이동
                q.add(doc);
            else 
            {
                // 중요도가 가장 큰 작업이 현재 작업인 경우 큐에서 제거
                // 요청한 문서의 순서 증가
                answer++;
                // 현재 작업과 요청한 문서의 위치가 같으면 반복문 종료
                if(doc.location == location)
                    break;
            }
        }
        
        return answer;
    }
}
class Printer{
    int location;
    int prior;
    
    Printer(int location, int prior){
        this.location = location;
        this.prior = prior;
    }
}