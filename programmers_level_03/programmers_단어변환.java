import java.util.*;
class Solution {
    int result;
    public int solution(String begin, String target, String[] words) {
        int answer = words.length+1;
        boolean[] visited = new boolean[words.length]; // 방문 여부
        result = answer; // 전역변수로 사용
        
        // 깊이우선 탐색 사용 (시작단어, 타겟, words, 방문, depth)
        dfs(begin, target, words, visited, 0);
        answer = result;
        
        // answer가 words의 최대길이보다 길면 targe이 없다는 의미로 0 반환
        if(answer > words.length) return 0; 
        return answer;
    }
    
    
    // 깊이우선탐색
    public void dfs(String begin, String target, String[] words, boolean[] visited,int depth){
        
        for(int i=0; i<words.length; i++){
            int s_cnt = 0; // 일치하지 않는 단어의 횟수
            for(int j=0; j<words[i].length(); j++){
                if(!visited[i] && begin.charAt(j) != words[i].charAt(j)) s_cnt++;
            }
            // 일치하지 않는 단어가 1개 뿐이면 dfs 실행
            if(s_cnt == 1){
                if(words[i].equals(target) && result > depth+1){
                    result = depth+1;
                    return;
                }
                visited[i] = true; // 방문함
                dfs(words[i], target, words, visited, depth+1);
                visited[i] = false; // dfs 빠져나오면서 방문표시 지우기
            }
        }
    }
}