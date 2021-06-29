import java.util.*;
class Solution {
    ArrayList<String> al;
    public int[] solution(int n, String[] words) {
        int[] answer = new int[n];
        
        // 1. 지금까지 언급된 단어들 저장 
        //    첫 번째 단어 미리 저장
        al = new ArrayList<>();
        al.add(words[0]);
        
        // 2. 두 번째 단어부터 끝말잇기 검토
        int stage = 1;
        for(int i=1; i<words.length; i++){
            
            // 2-1. n으로 나눈 나머지로 몇 번째 사람인지 파악
            //      i가 0부터 시작하기 때문에 i+1
            //      순서가 첫 번째 사람으로 돌아오면 stage 증가
            //      0인 경우, n으로 나눠진 경우이기 때문에 n번째 사람으로 인식
            int person = (i+1)%n; 
            if(person == 1) stage++;
            else if(person == 0) person = n;
            
            // 2-2. 지금까지 언급된 단어가 있는지 확인
            //      언급된 적 있으면 리턴
            //      언급된 적 없으면 배열에 추가
            if(al.contains(words[i])) return new int[] {person, stage};
            else al.add(words[i]);
            
            // 2-3. 단어와 끝과 처음의 알파벳 비교
            //      다르면 리턴
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                return new int[] {person,stage};
            }
        }
        
        // 3. 탈라자 발생하지 않은 경우
        return new int[] {0,0};
    }
}