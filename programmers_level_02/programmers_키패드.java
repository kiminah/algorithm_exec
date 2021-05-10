class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] spot = {{3,1},{0,0},{0,1},{0,2},
                      {1,0},{1,1},{1,2},
                      {2,0},{2,1},{2,2}};
                      
        int[] l_loc = {3,0};
        int[] r_loc = {3,2};
       
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            int x = spot[num][0];
            int y = spot[num][1];
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                l_loc = new int[] {x,y};
            }else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                r_loc = new int[] {x,y};
            }else{
                // 거리계산
                int l_dist = Math.abs(l_loc[0]-x) + Math.abs(l_loc[1]-y);
                int r_dist = Math.abs(r_loc[0]-x) + Math.abs(r_loc[1]-y);
                
                if(l_dist < r_dist){
                    answer += "L";
                    l_loc = new int[] {x,y};
                }else if(l_dist > r_dist){
                    answer += "R";
                    r_loc = new int[] {x,y};
                }else{
                    if(hand.equals("left")){
                        answer += "L";
                        l_loc = new int[] {x,y};
                    }
                    else{
                        answer += "R";
                        r_loc = new int[] {x,y};
                    }
                }
            }
        }
        
        return answer;
    }
}