class Solution {
    boolean visited[];
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int cnt=0;
        
        visited = new boolean[reserve.length];
        
        for(int i=0; i<lost.length; i++){
            boolean flag=false;
            int pre=lost[i]-1; // 앞번호
            int post=lost[i]+1; // 뒷번호
            for(int j=0; j<reserve.length; j++){
                System.out.println("pre/post: "+pre+"/"+post);
                if((reserve[j]==pre || reserve[j]==post)&& !visited[j]){
                    visited[j]=true;
                    cnt++;
                    System.out.println(cnt);
                }
                if(flag) break;
            }
        }
        answer = n-lost.length+cnt;
        return answer;
    }
}