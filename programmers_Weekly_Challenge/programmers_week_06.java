import java.util.*;
class Solution {

    public int[] solution(int[] weights, String[] head2head) {
        int len = weights.length;
        int[] answer = new int[len];

        // (승률, 자기보다 무거운 복서 이긴 횟수, 몸무게, 선수 번호)
        long[][] candi = new long[len][4];


        // 1. 선수들의 정보 저장
        for(int i=0; i<len; i++){
            String arr = head2head[i];
            int l_cnt = 0; // 진 횟수
            int w_cnt = 0; // 이긴 횟수
            for(int j=0; j<len; j++){
                if(arr.charAt(j)=='W'){
                    // 자기보다 무거운 복서를 이긴 경우
                    if(weights[i]<weights[j]) candi[i][1]++;
                    w_cnt++;
                }
                else if(arr.charAt(j) == 'L') l_cnt++;
            }
            // 승률
            double rate = (w_cnt+l_cnt == 0) ? 0 : (double)w_cnt/(double)(w_cnt+l_cnt);
            candi[i][0] = (long)(rate*1000000);
            candi[i][2] = weights[i];
            candi[i][3] = i+1;
        }

        // 2. 정렬
        Arrays.sort(candi, (a,b)-> {
            
            // 2-1. 승률 내림차순 정렬
            if(a[0] != b[0]) return Long.compare(b[0],a[0]);
            
            // 2-2. 자기보다 무거운 복서를 이긴 횟수 내림차순 정렬
            if(a[1] != b[1]) return Long.compare(b[1],a[1]);
            
            // 2-3. 몸무게 내림차순 정렬
            //      몸무게가 같은 경우 선수 번호로 오름차순 정렬
            return (a[2] == b[2]) ? Long.compare(a[3], b[3]) : Long.compare(b[2],a[2]);

        });

        for(int i=0; i<len; i++){
            answer[i] = (int)candi[i][3];
        }

        return answer;

    }
}