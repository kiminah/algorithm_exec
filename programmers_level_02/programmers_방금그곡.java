class Solution {
    int max_time = -1;
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        // '#'붙은 음 변경
        m = replace_m(m);
        
        for(String str : musicinfos){
            String[] music = str.split(",");
            String title = music[2];
            // 1. '#'붙은 음 변경
            String code = replace_m(music[3]);
            
            // 2. 재생시간 추출 (hour * 60 + minute)
            String[] time = music[0].split(":");
            int start = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            
            time = music[1].split(":");
            int end = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            
            int play = end - start;
            
            StringBuilder new_code = new StringBuilder();
            
            // 3. 재생시간 만큼의 음악 코드 생성
            for(int i=0; i< play / code.length(); i++)
                new_code.append(code);
            new_code.append(code.substring(0, play % code.length()));
            
            code = new_code.toString();
            
            // 4. 코드에 멜로디 존재유무 확인
            //    조건이 일치하는 음악이 여러 개 일때, 재생시간이 가장 긴 음악 반환
            //    재생시간도 같은 경우 먼저 입력된 음악 반환
            if(code.contains(m) && play > max_time){
                answer = title;
                max_time = play;
            }
        }
        
        return answer;
    }
    
    public String replace_m(String melody){
        
        melody = melody.replaceAll("C#", "H");
        melody = melody.replaceAll("D#", "I");
        melody = melody.replaceAll("F#", "K");
        melody = melody.replaceAll("G#", "L");
        melody = melody.replaceAll("A#", "M");
        
        return melody;
    }
}