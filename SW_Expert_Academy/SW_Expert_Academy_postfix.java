import java.util.*;
public class SW_Expert_Academy_postfix {
    /** 문자열로 이루어진 계산식이 주어질 때,
     *  이 계산식을 후위 표기법으로 바꾸어 계산하는 프로그램 작성
     *  ex) "3 + (4 + 5) * 6 + 7"
     *      --> "345+6*+7+"
     */
    static Stack<Character> st;
    static Stack<Integer> num;
    public static void main(String[] args) {
        String str = "3+(4+5)∗6+7";
        String answer = "";
        
        // 숫자 아닌 값 담을 스택
        st = new Stack<>();

        // Postfix 함수
        String postfix_str = postfix(str);
        System.out.println(postfix_str);

        // 계산
        num = new Stack<>();

        Integer total = cal(postfix_str);




    }

    // 숫자 이외의 것들 우선순위
    public static int priority(char c){
        if(c=='+') return 2;
        else if(c=='*') return 1;
        else if(c=='(') return 5;

        return 0;
    }

    // 후위표기법
    public static String postfix(String str){
        String result = "";

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            // 숫자인 경우
            if(c >= '0' && c <= '9'){
                result += c;
            }else{

                // 괄호인 경우
                if(c =='('){    // 괄호 시작을 stack에 담기
                    st.push(c);
                }else if(c==')'){ // 괄호의 끝을 만나면 시작 괄호를 만날떄까지 추출
                    char peek = st.peek();
                    while(peek != '('){
                        result += st.pop();
                        peek = st.peek();
                    }
                    st.pop(); // 남은 괄호 빼기
                }
                // 연산자인 경우
                else{
                    if(!st.isEmpty()){ // 스택이 빈 상태가 아니어야 가능
                        char peek = st.peek();
                        while(priority(c) >= priority(peek)){ // 스택 최상단의 연산자와 현재 연산자의 우선순위 파악
                            result += st.pop(); // 들어올 연산자가 우선순위가 낮은(값은 높은) 연산자이면, 최상단 연산자 추출
                            if(st.isEmpty()) break; // 스택이 비면 반복문 종료
                            peek = st.peek();   // 아니라면 최상단 값 변경

                        }
                    }
                    st.push(c); // 현재 연산자 스택에 삽입
                }
            }
        }

        // 남은 연산자들 모두 추출
        while(!st.isEmpty()){
            result += st.pop();
        }

        return result;
    }

    // 후위표기법 계산
    public static int cal(String str){
        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);

            if(c >= '0' && c <= '9'){
                st.push(c);
            }else{
                int a = Integer.parseInt(String.valueOf(st.pop()));
                int b = Integer.parseInt(String.valueOf(st.pop()));
                int sum = 0;
                if(c=='+') sum = a + b;
                else if(c=='*') sum = a*b;

                st.push((char)sum);
            }

        }

        return st.pop();
    }
}
