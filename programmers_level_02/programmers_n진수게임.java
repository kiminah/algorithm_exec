import java.util.*;
class Solution {
    int num;
    int start;
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        num = 0; // 시작 숫자
        start = 1; // 말하는 사람의 순서

        // 튜브가 말할 숫자의 개수만큼 반복
        while(answer.length() != t){
            // 1. 숫자에 해당하는 n진수 구해서 한자리씩 끊어주기
            char[] convert = conversion(num, n).toCharArray();
            
            for(char c : convert){
                
                // 2. 지금말할 사람의 순서와 튜브의 순서가 일치하면 튜브가 말할 숫자에 추가 
                if(start == p){
                    answer += c;
                }
                
                // 3. 말하는 사람의 순서 다음사람으로 지정(+1) 
                //    또는, 말하는 사람의 순서가 게임에 참가하는 인원수와 같아지면
                //    다시 1번 순서의 사람으로 돌아가기
                if(start == m){
                    start = 1;
                }else{
                    start++;
                }

                // 4. 반복문 진행중 미리 t 만큼 말했다면 반복문 종료
                if(answer.length() == t) break;
            }
            
            // 5. 다음에 말할 숫자 증가
            num++;
        }
        
        return answer;
    }
    public String conversion(int num, int n){
        StringBuilder sb = new StringBuilder();
        // 1. 0 인 경우 0 반환
        if(num == 0) return "0";
        else{
            while(num > 0){

                // 10 미만의 숫자인 경우 1~9 그대로 감
                if(num%n < 10){

                    sb.append(num%n);
                
                // 10 이상의 숫자인 경우 A~F로 나타낸다
                }else{

                    // ex) num%n = 11, 11-10 = 1, 'A'+1 = 'B' 
                    sb.append((char)(num % n - 10 + 'A'));
                }

                // 진수 n으로 나눠서 이어서 구할 숫자 갱신
                num /= n;
            }
        }
        // 일의자리수부터 구했으므로 뒤집어준다.
        return sb.reverse().toString();
    }
}