import java.util.*;
class Solution {
    ArrayList<Integer> list;
    Set<String> set;
    ArrayList<String> al = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int len = relation[0].length;
        
        // 조합 개수
        for(int i=0; i<len; i++){
            // 시작 컬럼
            for(int j=0; j<len; j++){
                list = new ArrayList<>();
                // 조합
                con(relation, i+1, j);
            }
        }

        boolean[] visit = new boolean[al.size()];
        // 길이순으로 정렬
        Collections.sort(al, (a,b)->{return a.length()-b.length();});
        // 최소성
        for(int i=0; i<al.size(); i++){
            for(int j=i+1; j<al.size();){
                if(al.get(j).contains(al.get(i))){
                    al.remove(j);
                }else j++;
            }
            
        }
        
        return al.size();
    }
    
    public void con(String[][] relation, int size, int start){
        list.add(start);
        if(list.size()==size){
            // 유일성 확인
            check_unique(relation);
            return;
        }
        
        for(int i=start+1; i<relation[0].length; i++){
            con(relation, size, i);
            list.remove(list.size()-1);
        }
    }
    
    public void check_unique(String[][] relation){
        set = new HashSet<>();
        
        for(int i=0; i<relation.length; i++){
            
            String tmp = "";
            
            for(Integer num : list)
                tmp += relation[i][num];
            if(!set.add(tmp)) return;
        }
        
        String tmp = "";
        for(Integer num : list){
            tmp += String.valueOf(num);
        }

        al.add(tmp);
    }
    
}