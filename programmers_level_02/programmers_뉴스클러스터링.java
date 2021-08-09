import java.util.*;
class Solution {
    ArrayList<String> multiSet1;
    ArrayList<String> multiSet2;
    ArrayList<String> union;
    ArrayList<String> intersection;
    public int solution(String str1, String str2) {
        
        multiSet1 = new ArrayList<>();
        multiSet2 = new ArrayList<>();
        union = new ArrayList<>();
        intersection = new ArrayList<>();
        
        // 1. 대소문자 차이 무시
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        // 2. 다중집합 생성
        multiSet(str1, 1);
        multiSet(str2, 2);
        
        // 3. 정렬
        Collections.sort(multiSet1);
        Collections.sort(multiSet2);
        
        // 4. 교집합과 합집합 생성
        for(String str : multiSet1){
            // 4-1. 동일한 문자이면 교집합에 추가
            //      다중집합 B에서 삭제
            if(multiSet2.remove(str)){
                intersection.add(str);
            }
            // 4-2. 합집합에는 모든 문자 추가
            union.add(str);
        }
        // 5. 교집합이 제거된 다중집합 B의 나머지 요소 합집합에 추가
        for(String str : multiSet2){
            union.add(str);
        }
        
        double answer = 0;
        if(union.size() == 0) 
            answer = 1;
        else 
            answer = (double)intersection.size()/(double)union.size();
        
        return  (int)(answer * 65536);
    }
    
    public void multiSet(String str, int num){
        for(int i=0; i<str.length()-1; i++){
            char first = str.charAt(i);
            char second = str.charAt(i+1);
            
            if(first >= 'A' && first <= 'Z' &&
               second >= 'A' && second <= 'Z'){
                if(num==1)
                    multiSet1.add(first+""+second);
                else
                    multiSet2.add(first+""+second);
            }
        }
    }
}