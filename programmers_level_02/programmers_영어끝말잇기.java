import java.util.*;
class Solution {
    boolean[] visit;
    Queue<String> q;
    ArrayList<String> al;
    int[] answer = new int[2];
    
    public int[] solution(int n, String[] words) {
        
        visit = new boolean[words.length];
        q = new LinkedList<>();
        al = new ArrayList<>();
        
        solve(n,words);
        
        return find_fail(n);
    }
    
    public void solve(int n, String[] words){
        q.add(words[0]);
        
        while(!q.isEmpty()){
            String w = q.poll();
            boolean flag = false;
            
            for(int i=0; i<words.length; i++){
                if(w.charAt(w.length()-1)==words[i].charAt(0)){
                    flag = true;
                    q.add(words[i]);
                    al.add(words[i]);
                }
            }
        }
    }
    public int[] find_fail(int n){
        int stage=1;
        for(int i=1; i<al.size(); i++){
            if(i%3==0) stage++;
            if(al.get(i-1).charAt(al.get(i-1).length()-1) != al.get(i).charAt(0)){
                int person = i%n;
                if(person==0) person = n;
                return new int[] {person, stage};
            }
        }
        return new int[] {0,0};
        
    }
    
}