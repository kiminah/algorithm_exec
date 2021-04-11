class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            String s = cut(skill, skill_trees[i]);
            // s의 길이만큼 skill 자르기
            // 무조건 skiil의 가장 첫번째 알파벳이 나와야 다음 스킬이 가능하므로 0부터 시작
            String result = skill.substring(0, s.length());
            // 자른 값이 같으면 가능한 스킬트리
            if(result.equals(s)) answer++;
        }
        
        
        return answer;
    }
    
    public String cut(String skill, String tree){
        // skill과 겹치는 스킬만 추출
        String result = "";
        for(int i=0; i<tree.length(); i++){
            for(int j=0; j<skill.length(); j++){
                if(tree.charAt(i)==skill.charAt(j)){
                    result += tree.charAt(i);
                }
            }
        }
        return result;
    }
}