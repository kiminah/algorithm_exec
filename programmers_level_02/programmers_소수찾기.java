import java.util.*;
class Solution {
    boolean[] visit;
    ArrayList<Integer> al;
    
    public int solution(String numbers) {
        int answer = 0;
        al = new ArrayList<>();
        
        // 숫자 조합
        for(int i=0; i<numbers.length(); i++){
            visit = new boolean[numbers.length()];
            if(!visit[i]){
                visit[i] = true;
                make_num(numbers, numbers.charAt(i)+"", 1);
            }
        }
        
        // 소수 확인
        for(int n=0; n<al.size(); n++){
            boolean flag = false;
            int num = al.get(n);
            for(int i = 2; i*i <= num; i++) {
                if(num % i == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        
        return answer;
    }
    
    public void make_num(String numbers, String str, int depth){
        // 깊이가 numbers 길이보다 작거나 같은 경우
        // 숫자가 생성되었다고 판단
        if(depth <= numbers.length()){
            int num = Integer.parseInt(str);
            // 0,1 은 제외
            if(num == 0 || num == 1){}
            // 포함된 적이 없으면 추가
            else if(!al.contains(num)){
                al.add(num);
            }
        }
        
        for(int i=0; i<numbers.length(); i++){
            // 새로운 숫자 만들기
            String crr_str = str + numbers.charAt(i);
            // 조합 한 적이 없는 경우
            if(!visit[i]){
                visit[i]=true;
                make_num(numbers, crr_str, ++depth);   
                visit[i] = false;
            }
        }
    }
}