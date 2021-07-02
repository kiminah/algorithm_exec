import java.util.*;
class Solution {
    char[] friend = {'A','C','F','J','M','N','R','T'};
    ArrayList<Person> list;
    boolean[] visit;
    int answer = 0;
    public int solution(int n, String[] data) {

        list = new ArrayList<>();
        
        // 1. 모든 조건 저장
        for(int i=0; i<n; i++){
            list.add(new Person(data[i].charAt(0), 
                                data[i].charAt(2),
                                data[i].charAt(3),
                                Integer.parseInt(data[i].charAt(4)+"")));
        }
        
        // 2. 줄 세우기
        for(int j=0; j<8; j++){
            visit = new boolean[8];
            stand(j, friend[j]+"");
        }

        return answer;
    }
    
    public void stand(int start, String str){
        visit[start] = true;
        
        // 1. 모든 인원을 줄 세운경우, 조건 만족하는지 확인
        if(str.length() == 8){
            if(check_p(str))
                answer++;
            return;
        }
        // 2. 모든 인원이 나란히 설 때까지 진행
        for(int i=0; i<8; i++){
            if(!visit[i]){
                stand(i, str+friend[i]);
                visit[i] = false;
            }
        }
    }
    
    public boolean check_p(String str){
        boolean flag = false;
        
        for(int i=0; i<list.size(); i++){
            // 1. 조건 순서대로 검사
            Person p = list.get(i);
            // 2. 조건에 만족하는 프렌즈의 간격 계산
            int num = Math.abs(str.indexOf(p.a)-str.indexOf(p.b))-1;
            
            // 3. 간격이 조건에 만족하는지 확인
            //    하나의 조건이라도 만족하지 않는 경우 false 리턴
            if(p.op == '='){
                if(num != p.num) return false;
            }
            
            else if(p.op == '>'){
                if(num <= p.num) return false;
            }
            
            else if (p.op == '<'){
                if(num >= p.num) return false;
            }
        }
        return true;
    }
}

class Person{
    char a, b, op; 
    int num;
    Person(char a, char b, char op, int num){
        this.a = a;
        this.b = b;
        this.op = op;
        this.num = num;
    }
}