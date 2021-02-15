class Solution {
    public String solution(String[] seoul) {
        String answer = "";

        for(int i=0; i<seoul.length; i++){ // seoul 길이 반복
            String name = seoul[i]; // 해당 위치의 이름
            if(name.length() != 3) continue; // Kim의 길이와 다르면 다음 이름
            else{ // 길이가 같다면 글자 비교
                if(name.equals("Kim")){
                    answer="김서방은 " + i +"에 있다";
                    return answer;
                }
            }
        }
        return answer;
    }
}