import java.util.*;
class Solution
{
    public int solution(int[] A, int[] B)
    {
        int answer = 0;

        ArrayList<Integer> a_q = new ArrayList<>();
        ArrayList<Integer> b_q = new ArrayList<>();

        // 1. A와 B를 정렬 (A의 최소값과 B의 최대값을 곱한 값 = 두 수 곱의 합 최소값)
        for(int i=0; i<A.length; i++){
            a_q.add(A[i]);
            b_q.add(B[i]);
        }
        Collections.sort(a_q);
        Collections.sort(b_q, Collections.reverseOrder());
        
        // 2. 두 수의 곱을 합산
        for(int i=0; i<a_q.size(); i++){
            answer += a_q.get(i) * b_q.get(i);
        }
        
        return answer;
    }
    
}