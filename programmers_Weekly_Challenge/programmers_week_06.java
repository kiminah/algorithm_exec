import java.util.*;
class Solution {
    
    public int[] solution(int[] weights, String[] head2head) {
        int len = weights.length;
        int[] answer = new int[len];
        
        List<info> list = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            String arr = head2head[i];
            int total = len-1;
            int total_win_cnt = 0;
            int win_cnt = 0;
            for(int j=0; j<len; j++){
                if(i==j) continue;
                if(arr.charAt(j)=='W'){
                    if(weights[i]<weights[j]) win_cnt++;
                    total_win_cnt++;
                }
                else if(arr.charAt(j) == 'N') total--;
            }
            double rate = (total == 0) ? 0 : (double)total_win_cnt*100/(double)total;
            list.add(new info(rate, win_cnt, weights[i], i+1));
        }
        
        Collections.sort(list, (a,b)-> {
            if(a.rate > b.rate) return -1;
            if(a.cnt != b.cnt) return b.cnt-a.cnt;
            return (a.kg == b.kg) ? a.num - b.num : b.kg - a.kg;
        });

        for(int i=0; i<len; i++){
            answer[i] = list.get(i).num;
        }
        
        return answer;
        
    }
    
    private static class info{
        double rate;
        int cnt, kg, num;
        info(double rate, int cnt, int kg, int num){
            this.rate = rate;
            this.cnt = cnt;
            this.kg = kg;
            this.num = num;
        }
    }
}


/**
import java.util.*;
class Solution {
    
    public int[] solution(int[] weights, String[] head2head) {
        int len = weights.length;
        int[] answer = new int[len];
        
        Map<Double, info> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            String arr = head2head[i];
            int l_cnt = 0;
            int w_cnt = 0;
            int big_cnt = 0;
            for(int j=0; j<len; j++){
                if(arr.charAt(j)=='W'){
                    if(weights[i]<weights[j]) big_cnt++;
                    w_cnt++;
                }
                else if(arr.charAt(j) == 'L') l_cnt++;
            }
            double rate = (double)w_cnt/(w_cnt+l_cnt);
            map.put(rate, new info(i+1, big_cnt));
        }
        List<Double> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());
        Collections.sort(list, (a,b)-> {
            info o1 = map.get(a);
            info o2 = map.get(b);
            if((a-b)==0){
                if(o1.cnt != o2.cnt) return o2.cnt - o1.cnt;
                return (weights[o2.num] == weights[o1.num]) ? 0 : weights[o2.num] - weights[o1.num];
            }
        });

        System.out.println(list);
        for(int i=0; i<len; i++){
            // answer[i] = map.get(list.get(i));
        }
        
        return answer;
        
    }
    
    private static class info{
        int num, cnt;
        info(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
}
*/