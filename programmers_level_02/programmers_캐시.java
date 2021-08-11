import java.util.*;
class Solution {
    ArrayList<String> cache;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // 1. 캐시크기가 0인 경우 예외처리
        if(cacheSize == 0) return 5 * cities.length;
        
        cache = new ArrayList<>();
        
        // 2. LRU 사용
        for(String city : cities){
            city = city.toUpperCase(); // 대소문자 구분 안함
            
            // 2-1. 캐시에 포함된지 않은 도시인 경우
            //      최근에 사용한적 없는 도시를 제거 후 새로운 도시 추가
            if(!cache.contains(city)){
                if(cache.size()==cacheSize) cache.remove(0);
                answer += 5;
            // 2-2. 캐시에 포함된 도시인 경우
            //      최근 사용기록 갱신
            }else{
                cache.remove(city);
                answer += 1;
            }
            cache.add(city);
        }
        
        return answer;
    }
}