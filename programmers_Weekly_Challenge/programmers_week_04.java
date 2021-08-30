import java.util.*;
class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        int max = 0;
        for(int i=0; i<table.length; i++){
            String[] row = table[i].split(" ");
            String tname = row[0]; // 직업군 이름
            int score = 0;
            for(int j=0; j<languages.length; j++){
                // 1. 해당 개발자가 선호하는 언어 점수 추출
                int index = Arrays.asList(row).indexOf(languages[j]);
                // 2. 언어가 순위에 존재하는 경우에만 진행
                if(index > 0){
                    // 언어 선호도 x 직업군 언어 점수
                    score += preference[j] * (table.length-index+1);
                }

                // 3. 점수 총합이 가장 높은 직업군 갱신
                //    사전 순으로 먼저 오는 직업군 추출
                if(score == max && answer.compareTo(tname)>0) answer = tname;
                if(max<score){
                    max = score;
                    answer = tname;
                }
            }
        }
        
        return answer;
    }
}