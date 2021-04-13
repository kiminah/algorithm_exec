import java.util.Arrays;
public class SW_Expert_Academy_Gravity {
    /** 상자들이 쌓여있는 방이 있다.
     *  방이 오른쪽으로 90도 회전하여 상자들이 중력의 영향을 받아 낙하한다.
     *  낙차가 가장 큰 상자를 구하여 그 낙차를 출력하여 보자
     */
    public static void main(String[] args) {
        int T = 1; // 테스트 케이스 개수
        int N = 9, M = 8; // 방의 가로, 세로 길이 
        int[] H = new int[]{7,4,2,0,0,6,0,7,0}; // 상자들이 쌓여있는 높이
        int answer = 0;

        int start =0, end=1;
        int cnt = 0; // 낙차가 가장 큰 값

        while(start < H.length-1){

            if(end == H.length-1){
                start++;
                end=start;
                // 이전에 구한 낙차보다 현재 낙차가 크면 업데이트
                if(answer < cnt) {
                    answer = cnt;
                    cnt = 0;
                }
            }

            if(H[start]>H[end]) cnt++;
            end++;
        }

        System.out.println(answer);
    }
}
