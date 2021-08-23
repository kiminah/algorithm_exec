import java.util.*;
class Solution {
    Map<String, Integer> dic;
    ArrayList<Integer> out;
    public int[] solution(String msg) {
        int[] answer;
        
        dic = new HashMap<>();
        out = new ArrayList<>();
        
        // 1. 사전 생성
        for(int i=0; i<msg.length(); i++)
            dic.put(msg.charAt(i)+"",msg.charAt(i)-'A'+1);
        
        int index = 'Z'-'A' + 2; // 'Z' 다음 색인 번호
        LZW(msg, 0, index);
        
        answer = new int[out.size()];
        for(int i=0; i<out.size(); i++){
            answer[i] = out.get(i);
        }
        return answer;
    }
    
    public void LZW(String msg, int start, int index){
        String w = ""; // 현재 입력
        String c = ""; // 다음글자
        
        // 1. 사전에서 현재 입력과 일치하는 가장 긴 문자열 찾기
        for(int i=start; i<msg.length(); i++){
            
            c += msg.charAt(i); // 다음글자 갱신
            
            // 1-1. 사전에 등록된 문자면 현재 입력 갱신
            if(dic.containsKey(c)){
                w = c; // 현재 입력 갱신
                start++; // 다음 LZW에서 사용될 다음글자의 위치 증가
                
            // 1-2. 사전에 등록된 문자가 아니면 반복문 종료
            }else
                break;
            
        }
        
        // 2. 출력 리스트에 추가 (w)
        out.add(dic.get(w));

        // 3. 새로운 글자 사전에 추가 (w+c)
        dic.put(c, index++);
        
        // 4. 마지막 글자가 아니면 압축 계속 진행
        if(start < msg.length())
            LZW(msg, start, index);
    }
}