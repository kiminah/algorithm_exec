import java.util.*;
class Solution {
    ArrayList<Integer> tuple;
    Set<String> set;
    ArrayList<String> unique = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int len = relation[0].length;
        
        // 조합 개수
        for(int i=0; i<len; i++){
            // 시작 컬럼
            for(int j=0; j<len; j++){
                tuple = new ArrayList<>();
                combination(relation, i+1, j);
            }
        }
        
        Collections.sort(unique, (a,b)->{
            return a.length()-b.length();
        });
        
        for(int i=0; i<unique.size(); i++){
            for(int j=i+1; j<unique.size();){
                if(unique.get(j).contains(unique.get(i))){
                    unique.remove(j);
                }else j++;
            }
        }
        
        return unique.size();
    }
    
    public void combination(String[][] relation, int size, int start){
        tuple.add(start);
        if(tuple.size()==size){
            if(check_unique(relation)){
                String tmp = "";
                for(Integer num : tuple){
                    tmp += String.valueOf(num);
                }
                unique.add(tmp);
            }
            return;
        }
        
        for(int i=start+1; i<relation[0].length; i++){
            combination(relation, size, i);
            tuple.remove(tuple.size()-1);
        }
    }
    
    public boolean check_unique(String[][] relation){
        set = new HashSet<>();
        
        for(int i=0; i<relation.length; i++){
            String tmp = "";
            for(Integer num : tuple)
                tmp += relation[i][num];
            if(!set.add(tmp)) return false;
        }
        return true;
    }
}