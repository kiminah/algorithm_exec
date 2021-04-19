import java.util.*;
class Solution {
    Queue<Integer> q;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.add(priorities[i]);
        }
        
        int loc = 0;
        int cnt = 0;
        int result = -1;
        while(result != location){
            int first = q.poll();
            
            int index = 1;
            boolean flag = false;
            if(q.size()>1){
                while(index < priorities.length){
                    int tmp = q.poll();
                    if(first < tmp){
                        flag = true;
                    }
                    q.add(tmp);
                    index++;
                }
            }
            
            if(flag) q.add(first);
            else{
                ++cnt;
                if(loc == location) result = loc;
            }
            loc++;
            if(loc == q.size()) loc = 0;

        }
        
        answer = cnt;
        
        return answer;
    }
}