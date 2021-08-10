import java.util.*;
class Solution {
    Queue<String> cache;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        cache = new LinkedList<>();
        
        for(String city : cities){
            city = city.toUpperCase();
            
            if(!cache.contains(city)){
                if(cache.size()==cacheSize) cache.poll();
                answer += 5;
            }else{
                String element = cache.poll();
                if(!element.equals(city)){
                    while(element.equals(city)){
                        cache.add(element);
                        element = cache.poll();
                    }
                }
                answer += 1;
            }
            cache.add(city);
        }
        
        return answer;
    }
}