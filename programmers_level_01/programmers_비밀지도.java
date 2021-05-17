class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            // arr1 과 arr2를 OR로 결합해서 이진수로 변환
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            // 주어진 값이 n보다 짧으면 0을 앞부분에 추가
            if(answer[i].length() < n){
                String tmp = "";
                for(int j=0; j<n-answer[i].length(); j++){
                    tmp += "0";
                }
                answer[i] = tmp + answer[i];
            }
            
            // 부호화된 숫자를 암호화 시키기
            String tmp = "";
            for(int j=0; j<n; j++){
                
                if(answer[i].charAt(j) == '1'){
                    tmp += "#";
                }else{
                    tmp += " ";
                }
            }
            answer[i] = tmp;
        }
        
        return answer;
    }
}