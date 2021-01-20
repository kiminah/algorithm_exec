import java.util.Stack;
class Solution {
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;
        int doll;
        int cnt = 0;
        boolean flag;
        Stack<Integer> stack = new Stack<>();
            
        // 크레인 위치 선정    
        for(int i=0; i<moves.length;i++){
            flag = false;
            for(int j=0; j<len;j++){

                int index= moves[i]-1;

                // 인형 집어올리기
                if(board[j][index] != 0){
                    doll = board[j][index];
                    board[j][index] = 0;
                    
                    // 인형 바구니에 담기
                    stack.push(doll);
                    System.out.println(doll);
                    flag = true;
                }

                // 중복된 인형 제거(중복된 값이 없을때까지 반복)
                if(stack.size()>1){
                    while(true){
                        int top = stack.pop();
                        
                        // 최근에 넣은 인형과 바로 전 인형 비교
                        // 같으면 제거 후 cnt 증가
                        if(stack.peek() == top){
                            stack.pop();
                            cnt+=2;
                        }
                        else{ // 다르면 최근 넣은 인형 다시 바구니에 담기
                            stack.push(top);
                            break; 
                        }

                        // 바구나가 비거나 1개 남은 경우 반복문 종료
                        if(stack.isEmpty() || stack.size()<2){ 
                            break;
                        }
                    }
                }
                
                // 인형 집어서 바구니에 넣었으면 크레인 이동
                if(flag){
                    break;
                }
            }  
        }
        answer = cnt;
        return answer;
    }
}