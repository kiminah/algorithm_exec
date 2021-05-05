class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            
            int cnt = 1;
            String result = ""; // 압축한 문자
            String pattern = ""; // 단위로 자른 문자
            
            for(int j=0; j<=s.length()+i; j+=i){
                String word;

                // 비교할 문자열 설정
                if(j >= s.length()) // 문자열이 없을 때
                    word = "";
                else if(j > s.length()-i) // 마지막 문자열일 때
                    word = s.substring(j);
                else
                    word = s.substring(j, j+i);

                // 문자열, 패턴과 비교
                if(j != 0){
                    if(word.equals(pattern)){ // 같으면 개수 증가
                        cnt++;
                    }else if(cnt >= 2){ // 다르면서 개수가 2 이상일 경우
                        result += cnt + pattern;
                        cnt = 1;
                    }else{ // 다르고 개수도 1일 경우 그냥 문자만 추가
                        result += pattern;
                    }
                }
                // 패턴 설정
                pattern = word;
            }
            // 최소값 설정
            answer = Math.min(result.length(), answer);
        }
        return answer;
    }
}