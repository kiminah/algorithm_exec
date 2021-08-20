import java.util.*;
class Solution {
    ArrayList<Character> menu;
    ArrayList<String> newMenu;
    ArrayList<String> result;
    int max;
    public String[] solution(String[] orders, int[] course) {
        
        menu = new ArrayList<>();
        result = new ArrayList<>();
        
        // 1. 메뉴 종류
        for(String str : orders){
            char[] arr = str.toCharArray();
            for(char c : arr){
                if(!menu.contains(c)) menu.add(c);
            }
        }
        Collections.sort(menu);
        // 2. 메뉴 구성
        for(int cnt : course){
            newMenu = new ArrayList<>();
            max = Integer.MIN_VALUE; // 동일메뉴 주문한 횟수
            for(int i=0; i<=menu.size()-cnt;i++){
                // new_course(orders, 단품메뉴 갯수, 시작메뉴 index, 메뉴 구성)
                new_course(orders, cnt, i, menu.get(i)+"");
            }
            // 2-1. 새로운 메뉴 추가
            for(String str : newMenu){
                result.add(str);
            }
        }
        // 3. 오름차순으로 정렬
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    public void new_course(String[] orders, int cnt, int start, String str){
        // 1. 코스 길이만큼 메뉴 조합이 완성된 경우
        //    몇명이 주문했는지 확인
        if(str.length() == cnt){
            check(str, orders);
            return;
        }
        
        // 2. 메뉴 조합
        for(int i=start+1; i<menu.size(); i++)
            new_course(orders, cnt, i, str+menu.get(i));
    }
    
    public void check(String str, String[] orders){
        int cnt = 0; // 주문한 인원수
        for(String m : orders){
            boolean flag = false;
            for(int i=0; i<str.length(); i++){
                if(m.contains(str.charAt(i)+"")) flag = true;
                else{flag = false; break;}
            }
            if(flag) cnt++;
        }
        // 주문한 인원수가 최소 2명 이면서,
        // 동일주문 최대 횟수보다 많으면 새로운 리스트에 메뉴 추가
        // 동일주문 최대 횟수가 같은 경우 메뉴 추가
        if(cnt >= 2 && max <= cnt){
            if(max != cnt){
                newMenu = new ArrayList<>();
                max = cnt;
            }
            newMenu.add(str);
            
        } 
    }
}