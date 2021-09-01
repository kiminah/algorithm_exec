import java.util.*;
class Solution {
    ArrayList<HashSet<Integer>> candidateKey;
    public int solution(String[][] relation) {
        candidateKey = new ArrayList<>();
        int len = relation[0].length;
        
        for(int i=1; i<=len; i++){
            // makeKeySet(시작 idx, relation 크기, 포함된 키의 개수, 생성할 키의 개수, 예비 후보키, relation)
            makeKeySet(-1, len-1, 0, i, new HashSet<>(), relation);
        }
        return candidateKey.size();
    }
    
    public void makeKeySet(int start, int len, int cnt, int size, HashSet<Integer> keySet, String[][] relation){
        // 1. 정한 후보키의 개수만큼 예비 후보키가 채워진 경우
        if(cnt == size){
            // 1-1. 최소성 확인
            for(HashSet<Integer> key : candidateKey){
                if(keySet.containsAll(key)){
                    return;
                }
            }
            // 1-2. 유일성 확인
            if(isUnique(keySet, relation)){
                candidateKey.add(keySet);
            }
            
            return;
        }
        
        // 2. 예비 후보키 생성
        for(int i=start+1; i<=len; i++){
            HashSet<Integer> newKeySet = new HashSet<>(keySet);
            newKeySet.add(i);
            makeKeySet(i, len, cnt+1, size, newKeySet, relation);
        }
    }
    
    public boolean isUnique(HashSet<Integer> keySet, String[][] relation){
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<relation.length; i++){
            String key = "";
            for(int num : keySet)
                key += relation[i][num];
            if(!set.add(key)) return false;
        }
        return true;
    }
}