import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    
    public String[] solution(String[] files) {
        List<FileName> file = new ArrayList<>();
        String head, number, tail;
        
        // 1. 파일명 head, number, tail 세부분으로 구분 (정규 표현식 사용)
        for(int i=0; i<files.length; i++){

            String s = files[i];
            // 1-1. [0-9] : 숫자, '+' : 앞 문자가 하나 이상
            Pattern p = Pattern.compile("[0-9]+");
            // 1-2. 대상 문자열이 패턴과 일치하는 경우
            Matcher m = p.matcher(s);
            // 1-3. 대상 문자열과 패턴이 일치하는 경우 true 반환하고, 그 위치로 이동

            if(m.find()){

                // 1-3-1. number 추출 (매칭된 부분 반환)
                number = m.group();
                int numStartIdx = s.indexOf(number); // number 시작하는 위치
                // 1-3-2. head 추출
                head = s.substring(0,numStartIdx);
                int numEndIdx = numStartIdx +  number.length()-1; // number 끝나는 위치
                // 1-3-3. tail 추출
                //        number 다음 위치가 문자열 길이를 넘어가는 경우 tail은 null
                //        number 다음 위치가 문자열 길이를 넘어가지 않는 경우 tail 추출
                
                if(numEndIdx + 1 > s.length()-1){
                    tail = "";
                }else{
                    tail = s.substring(numEndIdx+1);
                }

                // 1-3-4. file list에 추가
                file.add(new FileName(head, number, tail));
            }
        }

        // 2. 세 부분으로 나눈 파일명을 기준에 따라 정렬
        //    1) head 기준으로 사전 순으로 정렬(대소문자 무시)
        //    2) number의 숫자 순으로 정렬
        //    3) head, number 모두 같을 경우 원래 입력에 주어진 순서 유지
        file.sort(Comparator.comparing(FileName::getHead).thenComparing(Comparator.naturalOrder()));
        
        String[] answer = new String[file.size()];
        
        for(int i=0; i<file.size(); i++){
            answer[i] = file.get(i).toString();
        }
        
        return answer;
    }
    
    public static class FileName implements Comparable<FileName>{
        String head, number, tail;

        public FileName(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getHead(){
            return head.toLowerCase();
        }

        @Override
        public String toString(){
            return head + number + tail;
        }

        @Override
        public int compareTo(FileName f){
            int o1 = Integer.valueOf(this.number);
            int o2 = Integer.valueOf(f.number);
            return o1 - o2;
        }
    }
}