class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 1. 공백 제거후 배열로 생성
        String[] arr = s.split(" ");
        int min, max;
        
        // 2. min, max 초기화
        min = max = Integer.parseInt(arr[0]);
        
        // 3. min, max 검사
        for(int i=1; i<arr.length; i++){
            
            int num = Integer.parseInt(arr[i]);
            if(min > num) min = num;
            if(max < num) max = num;
            
        }
        
        return min + " " + max;
    }
}