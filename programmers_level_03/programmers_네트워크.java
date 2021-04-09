class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 방문 여부
        
        for(int i=0; i<n; i++){
            // 노드 순서대로 방문
            // 방문하지 않았다면 dfs 실행
            if(!visited[i]){
                answer++;
                // i : 방문할 노드
                dfs(computers, i,visited);
            }
        }
        
        return answer;
    }
    public void dfs(int[][] computers, int node, boolean[] visited){
        // 방문했다고 표시
        visited[node] = true;
        
        // 다시 처음부터 방문할 노트 찾기
        for(int i=0; i<computers.length; i++){
            // 현노드와 연결된 방문할 노드를 찾기
            // 그 노드가 방문했던 노드인지 아닌지 확인
            if(computers[node][i] == 1 && !visited[i]){
                dfs(computers, i, visited);
            }
        }
        
    }
}