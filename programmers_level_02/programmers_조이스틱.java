import java.util.*;
class Solution {
    Map<Character, Integer> map;
    int[] arr;
    public int solution(String name) {
        int answer = 0;
        arr = new int[name.length()];
        map = new HashMap<>();
        int idx = 0;
        
        // 1. 알파벳 배열
        for(char c='A'; c<='Y'; c++)
            map.put(c,idx++);
        map.put('Z',1);
        
        // 2. 조이스틱 이동
        arr[0] = map.get(name.charAt(0));
        char prev = name.charAt(0);
        for(int i=1; i<name.length(); i++){
            char next = name.charAt(i);
            if(prev != next){
                if(map.get(prev) > map.get(next)){
                    arr[i] = arr[i-1]+map.get(next)+1;
                }
                else{
                    arr[i] = arr[i-1] + map.get(next)-map.get(prev);
                }
            }
            prev = next;
        }
        answer = arr[name.length()-1];
       
        return answer;
    }
   
}