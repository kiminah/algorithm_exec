import java.util.*;
class Solution {
    ArrayList<filename> file;
    public String[] solution(String[] files) {
        file = new ArrayList<>();
        
        // 1. 파일명 head, number, tail 세부분으로 구분
        for(String f : files){
            String head = "", number = "", tail = "";
            int index = 0;
            boolean flag = false;
            char[] name = f.toCharArray();
            for(char c : name){
                if(c>='0' && c<='9'){
                    number += c;
                    flag = true;
                }
                else{
                    if(flag) break;
                    head += c;
                }
                index++;
            }
            tail = f.substring(index);
            file.add(new filename(head, number, tail));
        }

        // 2. 세 부분으로 나눈 파일명을 기준에 따라 정렬
        //    1) head 기준으로 사전 순으로 정렬(대소문자 무시)
        //    2) number의 숫자 순으로 정렬(0은 무시)
        //    3) head, number 모두 같을 경우 원래 입력에 주어진 순서 유지
        Collections.sort(file, (a,b)->{
            // 1) head 기준 정렬
            String as = a.head.toLowerCase();
            String bs = b.head.toLowerCase();
            
            if(!as.equals(bs))
                return as.compareTo(bs);
            
            // 2) number 기준 정렬
            int an=Integer.valueOf(a.number),bn=Integer.valueOf(b.number);
            if(an != bn) return an-bn;

            // 3) 원래 입력 순
            return 0;
        });
        
        String[] answer = new String[file.size()];
        
        for(int i=0; i<file.size(); i++){
            filename f = file.get(i);
            answer[i] = f.head + f.number + f.tail;
        }
        
        return answer;
    }
}

class filename{
    String head, number, tail;
    filename(String head, String number, String tail){
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
}