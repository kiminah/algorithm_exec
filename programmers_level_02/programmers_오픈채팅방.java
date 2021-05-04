import java.util.*;
class Solution {
    static ArrayList<String> log;
    static HashMap<String, String> user;
    
    public String[] solution(String[] record) {
        log = new ArrayList<>();
        user = new HashMap<>();

        for(String r : record){
            String[] tmp = r.split(" ");
            String stat = tmp[0]; // 상태
            String uid = tmp[1]; // 유저 아이디
            String nick = ""; // 닉네임
            
            // 떠나는 record는 닉네임이 없기 때문에
            // 닉네임 저장 따로 수행
            if(!stat.equals("Leave")){
                nick = tmp[2];
            }

            // 상태에 따른 유저정보 및 로그 저장
            switch(stat){
                case "Enter":
                    user.put(uid,nick);
                    log.add(uid+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    log.add(uid+"님이 나갔습니다.");
                    break;
                case "Change":
                    user.put(uid, nick);
                    break;
            }
        }
        
        String[] answer = new String[log.size()];
        int idx = 0;
        for(String chatlog : log){
            // 로그에서 유저아이디만 추출
            String uid = chatlog.split("님")[0];
            // 로그에 저장되어있는 유저아이디를 유저정보에 저장되어있는 닉네임으로 변경
            answer[idx++] = chatlog.replace(uid, user.get(uid));
        }
        return answer;
    }
}