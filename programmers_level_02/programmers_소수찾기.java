import java.util.*;
class Solution {
    boolean[] visit;
    ArrayList<Integer> al;
    public int solution(String numbers) {
        
        int answer = 0;
        al = new ArrayList<>();

        // 1. 숫자 조합하기
        for(int i=0; i<numbers.length(); i++){
            visit = new boolean[numbers.length()];
            if(!visit[i]){
                visit[i] = true;
                make_num(numbers, numbers.charAt(i)+"", 1);
            }
        }
        
        // 2. 소수 확인
        for(int n=0; n<al.size(); n++){
            
            int num = al.get(n);
            boolean flag = false;
            
            for(int i = 2; i*i <= num; i++) 
                
                if(num % i == 0) 
                    flag = true;
            
            if(!flag) ++answer; 
        }
        
        return answer;
    }
    
    public void make_num(String numbers, String str, int depth){
        
        // 1. 깊이가 numbers 길이보다 작거나 같은 경우
        //    숫자가 생성되었다고 판단
        if(depth <= numbers.length()){
            
            int num = Integer.parseInt(str);
            
            // 1-1. 0,1은 제외하고 포함된적 없는 숫자인 경우 추가
            if(num != 0 && num != 1 && !al.contains(num))
                al.add(num);
        }
        
        // 2. 숫자 만들기
        for(int i=0; i<numbers.length(); i++){
            
            // 2-1. 새로운 조합
            String crr_str = str + numbers.charAt(i);
            
            // 2-2. 조합 한 적이 없는 경우
            if(!visit[i]){
                
                visit[i]=true;
                make_num(numbers, crr_str, depth+1);   
                visit[i] = false;
                
            }
        }
    }
}