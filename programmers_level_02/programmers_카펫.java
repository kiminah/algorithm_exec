class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int w = 3;
        int h = 3;
        while(true){
            int cnt = 2*w + 2*h - 4;
            if(cnt == brown){
                if((w-2)*(h-2)==yellow) break;
                w++;
            }
            else if(cnt > brown){h++;w=h;}
            else w++;
        }
        answer = new int[] {w,h};
        return answer;
    }
}