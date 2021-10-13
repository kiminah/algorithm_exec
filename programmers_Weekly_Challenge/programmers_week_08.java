import java.util.*;
class Solution {
    PriorityQueue<Integer> firstMax;
    PriorityQueue<Integer> secondMax;
    public int solution(int[][] sizes) {
        
        // 가로,세로 우선순위 큐
        firstMax = new PriorityQueue<>((x,y)->y-x);
        secondMax = new PriorityQueue<>((x,y)->y-x);
        
        // 각 명함마다 가로 최대값, 세로 최대값 저장
        // 명함을 가로로 눕히는 망법도 있기 때문에 
        // 세로, 가로 지정 안 하고 최대값으로 판단
        for(int i=0; i<sizes.length; i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            firstMax.add(Math.max(w,h));
            secondMax.add(Math.min(w,h));
        }
        
        return firstMax.peek() * secondMax.peek();
    }
}