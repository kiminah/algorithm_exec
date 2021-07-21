class Solution {
    public boolean solution(int x) {
        
        // 1. 숫자 분해
        String num = Integer.toString(x);
        // String[] temp = String.valueOf(x).split("");
        
        // 2. 자릿수 합
        int sum = 0;
        for(int i=0; i<num.length(); i++){
            sum += Integer.parseInt(num.charAt(i)+"");
        }

        // 3. 하샤드 수 확인
        if(x%sum == 0) return true;
        return false;
    }
}