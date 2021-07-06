class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 1. 기본적으로 모두 소문자로 변경
        s = s.toLowerCase();
        
        String[] arr = s.split("");
        boolean flag = true;
        
        // 2. 첫번째 문자인지 아닌지 판별후 대문자로 변경
        for(String word : arr){
            
            // 2-1. 공백인 경우 
            if(word.equals(" ")){
                answer += word;
                flag = true;
            }
            
            // 2-2. 문자인 경우
            else{
                // 2-2-1. 바로 앞에 공백이 있는 경우 -> 첫 문자
                if(flag) answer += word.toUpperCase();
                else answer += word;
                flag = false;
            }
            
        }
        
        /** 다른 사람의 간단한 풀이 **
        for(String word : arr){
            answer += flag ? word.toUpperCase():word;
            flag = word.equals(" ") ? true:false;
        }
        */
        
        return answer;
    }
}