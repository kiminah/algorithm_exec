import java.util.*;
class Solution {
    ArrayList<Integer> al;
    int sum;
    public String solution(int[][] scores) {
        String answer = "";
        
        for(int i=0; i<scores.length; i++){
            al = new ArrayList<>(); // j번 학생에게 평가한 점수
            sum = 0; 
            // 1. 각 학생들이 받은 점수 합산
            for(int j=0; j<scores.length; j++){
                if(i==j) continue; // 본인인 경우 pass
                sum += scores[j][i];
                al.add(scores[j][i]);
            }
            Collections.sort(al); // 최고점, 최저점 추출하기 위한 정렬

            // 2. 유일한 최고점 또는 유일한 최저점이 아닌경우 포함
            if(al.get(al.size()-1) >= scores[i][i] && al.get(0) <= scores[i][i]){
                sum += scores[i][i];
                al.add(scores[i][i]);
            }
            // 3. 각 학생들이 받은 점수의 평균 구하여,
            //    기준에 따라 학점 부여
            answer += score((double)sum/(double)al.size());
        }
        
        return answer;
    }
    
    public String score(double avg){
        if(avg >= 90) return "A";
        else if(avg >= 80) return "B";
        else if(avg >= 70) return "C";
        else if(avg >= 50) return "D";
        else return "F";
    }
}