class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1. 소문자로 치환
        new_id=new_id.toLowerCase();
        
        // 2. 소문자, 숫자, -, _, 마침표를 제외한 모든 문자 제거
        new_id=step_02(new_id);
        
        // 3. 마침표 2번 이상 연속된 부분을 하나의 마침표로 치환
        if(new_id.length()>0 && new_id.contains(".."))
            new_id=step_03(new_id);
        
        // 4. 마침표가 처음 또는 끝에 위치하면 제거
        if(new_id.length()>0 && (new_id.charAt(0)=='.' || new_id.charAt(new_id.length()-1)=='.'))
            new_id = step_04(new_id);
        
        // 5. 빈 문자열이라면 a 대입
        if(new_id.length()==0)
            new_id = "a";
        
        // 6. 길이가 16자 이상이면 15개 문자만 남겨두기. 제거 후 마침표가 끝에 위치하면 제거
        if(new_id.length()>15){
            new_id = new_id.substring(0,15);
            new_id = step_04(new_id);
        }
        
        // 7. 길이가 2자 이하면 마지막 문자를 반복 길이 3까지 반복
        if(new_id.length()<=2){
            while(true){
                new_id += new_id.charAt(new_id.length()-1);
                if(new_id.length()==3) break;
            }
        }
        
        answer=new_id;
        return answer;
    }
    
    public String step_02(String new_id){
        for(int i=0; i<new_id.length(); i++){
            char str = new_id.charAt(i);
            if(!(str>='a' && str<='z') && !(str>='0' && str<='9') && !(str =='-' || str =='_' || str =='.')){
                new_id=new_id.substring(0,i)+new_id.substring(i+1,new_id.length());
                i--;
            }
        }
        
        return new_id;
    }
    
    public String step_03(String new_id){
        while(true){
            new_id=new_id.replace("..", ".");
            if(!new_id.contains("..")) break;
        }
        
        return new_id;
    }
    
    public String step_04(String new_id){
        if(new_id.charAt(0)=='.'){
            new_id=new_id.substring(1,new_id.length());
        }
        if(new_id.length()>0 && new_id.charAt(new_id.length()-1)=='.'){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        
        return new_id;
    }
    
}