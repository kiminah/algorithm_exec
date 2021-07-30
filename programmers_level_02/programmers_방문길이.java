import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        Set<String> set = new HashSet<>();
        
        int x=0, y=0; // 이전 좌표
        for(int i=0;i<dirs.length(); i++){
            int x2=x, y2=y; // 이동 좌표
            char c = dirs.charAt(i);
            // 1. 좌표 이동
            switch(c){
                case 'U':
                    y2=y+1;
                    break;
                case 'D':
                    y2=y-1;
                    break;
                case 'R':
                    x2=x+1;
                    break;
                case 'L':
                    x2=x-1;
                    break;
            }
            // 2. 좌표 범위 확인
            if(range(x2,y2)){
                // 2-1. 이전좌표->이동좌표 , 이동좌표->이전좌표 저장
                if(set.add(Integer.toString(x)+Integer.toString(y)+Integer.toString(x2)+Integer.toString(y2)) 
                && set.add(Integer.toString(x2)+Integer.toString(y2)+Integer.toString(x)+Integer.toString(y))){
                    answer++;
                }
                // 2-2. 이동좌표로 변경
                x = x2;
                y = y2;
            }
        }
        
        return answer;
    }
    
    public boolean range(int x, int y){
        return (x>=-5 && x<=5 && y>=-5 && y<=5);
    }
}