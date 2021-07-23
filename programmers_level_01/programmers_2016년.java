class Solution {
    public String solution(int a, int b) {
        // 각 월의 일수와 요일
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        // 1월 1일부터 a월 b일 까지의 일수
        int t_day = b;
        for(int i=0; i<a-1; i++){
            t_day += month[i];
        }
        // 전체 일수에서 7로 나누 나머지의 요일
        return day[t_day%7];
    }
}