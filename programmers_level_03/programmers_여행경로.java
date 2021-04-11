import java.util.*;
class Solution {
    List<String> ls = new ArrayList<>();
    String route = "";
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
      
        for(int i=0; i<tickets.length; i++){
            // 새로운 방문여부 확인
            visited = new boolean[tickets.length];
            
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            // 항상 ICN 공항에서 출발
            if(start.equals("ICN")){
                route = start + ",";
                visited[i] = true;
                dfs(tickets, end, 1);
            }
        }
        
        // 모든 경로의 경우의 수가 배열별로 담겨있음
        // ICN에서 출발하는 모든 경로의 경우의 수
        // [[1번 ICN의 경우],[2번 ICN의 경우],[3번 ICN의 경우]]
        Collections.sort(ls);
        answer = ls.get(0).split(",");
        
        return answer;
    }
        
    public void dfs(String[][] tickets, String end, int depth){
        // 목적지 추가
        route += end + ",";
        
        // 모든 도시 방문한 경우 배열 반환
        if(depth == tickets.length){
            ls.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            String s = tickets[i][0];
            String e = tickets[i][1];
            
            // 출발 공항이 현재 도착 공항과 같은 경우
            if(s.equals(end) && !visited[i]){
                visited[i] = true;
                dfs(tickets, e, depth+1);
                visited[i] = false;
                
                // 모든 공항은 알파벳 대문자 3글자로 이루어져 있으므로
                // 방문하지 않은 경우로 되돌아가야 하므로
                // route 길이 - 4
                route = route.substring(0, route.length()-4);
            }
        }
            
    }
}