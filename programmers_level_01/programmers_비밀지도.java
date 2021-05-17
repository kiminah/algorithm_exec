class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            // 주어진 숫자를 이진수로 변환
            // OR를 통해 arr1과 arr2을 합쳐줌
            // 이때 자릿수를 맞춰줘야함
            answer[i] = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr1[i] | arr2[i])));
            
            // 지도를 만들기 위해 부호화된 문자들을 암호화 시킴
            answer[i] = answer[i].replaceAll("1","#");
            answer[i] = answer[i].replaceAll("0"," ");
        }
        
        return answer;
    }
}