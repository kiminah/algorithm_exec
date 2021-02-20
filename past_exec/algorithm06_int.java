public class algorithm06_int {
    // 입력 받은 수 뒤집었을 때 큰 수 비교연산
    public static void main(String[] args) {
        int a = 734;
        int b = 893;

        int arrA[] = new int[3];
        int arrB[] = new int[3];

        int len = 0;
        // 배열에 입력받은 수 한자리씩 뒤집어 저장
        do{
            arrA[len] = a%10;
            a /= 10;

            arrB[len] = b%10;
            b /= 10;

            len++;
        }while(b>0);

        // 뒤집어 저장한 배열 정수로 만들기
        int tranA = 0;
        int tranB = 0;
        int mux = 1;
        for(int i=arrA.length-1; i>=0; i--){
            tranA += arrA[i]*mux;
            tranB += arrB[i]*mux;

            mux *= 10;
        }

        System.out.println("tranA: "+tranA+", tranB: "+tranB);

        // 비교연산
        if(tranA>tranB){
            System.out.println(tranA);
        }else{
            System.out.println(tranB);
        }

    }
}
