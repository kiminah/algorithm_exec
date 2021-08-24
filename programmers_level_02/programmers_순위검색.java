import java.util.*;
class Solution {
    Map<String, List<Integer>> candi;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        candi = new HashMap<>();
        
        // 1. info 모든 경우의 수 map에 저장
        for(int i=0; i<info.length; i++){
            dfs(info[i].split(" "), "", 0);
        }
        
        // 2. map에 저장된 점수list 오름차순으로 정렬(이진탐색을 위한 작업)
        List<String> list = new ArrayList<>(candi.keySet());
        for(int i=0; i<list.size(); i++){
            List<Integer> scoreList = candi.get(list.get(i));
            Collections.sort(scoreList); // 점수 정렬(얕은복사 : 간접적)
        }
        
        // 3. 이진 탐색
        for(int i=0; i<query.length; i++){
            String[] str = query[i].replaceAll(" and ", "").split(" "); // 지원자 정보와 점수 두가지로 구분
            int score = Integer.valueOf(str[1]);
            answer[i] = search(str[0], score);
        }
        
        
        return answer;
    }
    
    public int search(String q, int score){
        // 1. map에 없는 query인 경우 0 반환
        if(!candi.containsKey(q)) return 0;
        
        // 2. 이진 탐색
        List<Integer> scoreList = candi.get(q); // query에 일치하는 점수list
        int start=0, end=scoreList.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(scoreList.get(mid) < score){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        return scoreList.size()-start;
    }
    
    public void dfs(String[] info, String str, int depth){
        // 1. 4개의 원소가 모인경우 지원자 table 'candi'에 점수 추가 
        if(depth == 4){
            if(!candi.containsKey(str)){
                List<Integer> ls = new ArrayList<>();
                ls.add(Integer.valueOf(info[4]));
                candi.put(str, ls);
            }else{
                candi.get(str).add(Integer.valueOf(info[4]));
            }
            return;
        }
        
        // 2. 원소가 모이지 않은 경우 '-'인 경우 또는 지원자 정보값을 str에 추가하여 진행
        dfs(info, str+"-", depth+1);
        dfs(info, str+info[depth], depth+1);
    }
}