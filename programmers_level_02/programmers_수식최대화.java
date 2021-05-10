import java.lang.reflect.Array;
import java.util.*;

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Output;
public class programmers_수식최대화 {
    static ArrayList<Long> numList;
    static ArrayList<String> opList;
    static String[] oper = {"+","-","*"};
    static String[] output = new String[3];
    static boolean visit[] = new boolean[3];
    static long answer = 0;
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        numList = new ArrayList<>();
        opList = new ArrayList<>();

        // 배열 생성
        String n = "";
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+'|| c == '-' || c == '*'){
                opList.add(c+"");
                numList.add(Long.parseLong(n));
                n = "";
            }else{
                n += c;
            }
        }
        numList.add(Long.parseLong(n));

        // 우선순위 만들기
        prior(0, oper.length);
        System.out.println(answer);


    }

    public static void prior(int depth, int l){
        if(depth == l){
            System.out.println(Arrays.toString(output));
            solve();
            return;
        }
        for(int i=0; i<oper.length; i++){
            if(!visit[i]){
                visit[i]=true;
                output[depth] = oper[i];
                prior(depth+1, l);
                visit[i]=false;
            }
        }
    }

    public static void solve(){
        
        ArrayList<String> op = new ArrayList<>();
        op.addAll(opList);

        ArrayList<Long> num = new ArrayList<>();
        num.addAll(numList);

        for(int i=0; i<output.length; i++){
            String curop = output[i];

            for(int j=0; j<op.size(); j++){
                if(op.get(j).equals(curop)){
                    long n1 = num.get(j);
                    long n2 = num.get(j+1);
                    long res = calc(n1,n2,curop);

                    num.remove(j+1);
                    num.remove(j);
                    op.remove(j);

                    num.add(j, res);

                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(num.get(0)));

    }

    public static long calc(long n1, long n2, String op){
        long res = 0;
        switch(op){
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
        }

        return res;
    }
}

