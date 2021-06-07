import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        // 쿼리 
        for(int i=0; i<query.length; i++){
            String[] q = query[i].replaceAll(" and", "").split(" ");
            
            for(int j=0; j<info.length; j++){
                // j번째 지원자
                String[] candi = info[j].split(" ");
                
                // 쿼리 비교
                boolean flag = true;
                for(int idx=0; idx<4; idx++){
                    // '-' : 조건 고려하지 않음
                    if(q[idx].equals("-")){
                        continue;
                    }
                    // 쿼리문과 지원자의 상황이 같지 않은 경우 반복문 종료
                    else if(!q[idx].equals(candi[idx])){
                        flag = false;
                        break;
                    }
                }
                // 쿼리문이 지원자와 일치하는 경우 점수 비교
                // 점수가 쿼리문보다 크거나 같으면 count
                if(flag){
                    if(Integer.parseInt(q[4]) <= Integer.parseInt(candi[4])){
                        answer[i] += 1;
                    }
                }
            }
            
        }
        return answer;
    }
}