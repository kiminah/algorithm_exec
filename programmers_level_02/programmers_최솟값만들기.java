
class Solution
{
    boolean[] visit;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[] A, int[] B)
    {
        int len = A.length;
        
        visit = new boolean[len*2];
        solve(A, B, len, 0, 0);
        
        return answer;
    }
    
    public void solve(int[] A, int[] B, int len, int sum, int depth){
        
        if(depth==len && answer > sum){
            answer = sum;             
            return;
        }
        
        for(int i=0; i<len; i++){
            if(!visit[i]){
                visit[i] = true;
                for(int j=0; j<len; j++){
                    if(!visit[j+len]){
                        visit[j+len] = true;
                        solve(A, B, len, sum+(A[i]*B[j]), depth+1);
                        visit[j+len] = false;
                    }
                }
                visit[i] = false;
            }
        }
    }
}