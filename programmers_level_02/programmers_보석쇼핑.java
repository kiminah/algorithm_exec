import java.util.*;
public class programmers_보석쇼핑 {
    static HashSet<String> set; // 보석 종류
    static Queue<String> q; // 구매한 보석
    static HashMap<String, Integer> map; // 구매한 보석 빈도수

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = {};

        set = new HashSet<>();
        q = new LinkedList<>();
        map = new HashMap<>();

        int start = 0;
        int end = gems.length;

        for(String g : gems){
            set.add(g);
        }

        int startP = 0;
        for(int i=0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
            q.add(gems[i]);

            while(true){
                String tmp = q.peek();
                if(map.get(tmp)>1){
                    q.poll();
                    start++;
                    map.put(tmp, map.get(tmp)-1);
                }else{
                    break;
                }
            }

            if(map.size() == set.size() && end > q.size()){
                end = q.size();
                startP = start;
            }
        }

        answer = new int[] {startP+1, startP+end};


        System.out.println(Arrays.toString(answer));
    }
}
