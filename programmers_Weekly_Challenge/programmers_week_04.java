import java.util.*;
class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int[] score = new int[table.length]; // 직업군 언어 점수
        
        List<String> highScore = new ArrayList<>(); // 언어 선호도 x 직업군 언어 점수의 총합이 가장 높은 직업군
        
        int max = 0;
        for(int i=0; i<table.length; i++){
            String[] row = table[i].split(" ");
            for(int j=0; j<languages.length; j++){
                // 1. 해당 개발자가 선호하는 언어 점수 추출
                int index = Arrays.asList(row).indexOf(languages[j]);
                // 2. 언어가 순위에 존재하는 경우에만 진행
                if(index > 0){
                    // 언어 선호도 x 직업군 언어 점수
                    score[i] += preference[j] * (table.length-index+1);
                }

                // 3. 점수 총합이 가장 높은 직업군 갱신
                //    최고 점수가 같은 경우 list에 추가
                if(max<score[i]){
                    max = score[i];
                    highScore = new ArrayList<>();
                    highScore.add(row[0]);
                }else if(max == score[i]){
                    highScore.add(row[0]);
                }
            }
        }

        // 4. 사전 순으로 먼저 오는 직업군 추출
        Collections.sort(highScore);
        answer = highScore.get(0);
        
        return answer;
    }
}