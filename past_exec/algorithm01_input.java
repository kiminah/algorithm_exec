import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String no;

    public Student(String name, String no) {
        super();
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}

public class algorithm01_input {

    public static void main(String[] args) {
        Student st1 = new Student("손오공","1534");
        Student st2 = new Student("저팔계","1684");
        Student st3 = new Student("사오정","1793");

        ArrayList<Student> list = new ArrayList<Student>();
        list.add(st1);
        list.add(st2);
        list.add(st3);

        for (Student stu :list){
            System.out.println(stu.getName()+' '+stu.getNo());
        }
        
        Scanner sc = new Scanner(System.in);        

        while(true){
            System.out.println("계속 검색하고 싶으면 y, 종료하고 싶으면 n: ");
            String input = sc.next();

            if(input.equals("y")){
                System.out.println("검색을 시작합니다: ");
                String name = sc.next();
                boolean flag = false;

                for(Student stu:list){
                    System.out.println(stu.getName()+"/"+name);
                    if(stu.getName().equals(name)){
                        System.out.println("해당 학생의 학번은: "+stu.getNo());
                        flag = true;
                    }
                }
                if(!flag){
                    System.out.println("해당하는 학생 이름이 없습니다.");
                }


            }
            else if (input.equals("n")){
                break;
            }
        }

        System.out.println("프로그램이 종료되었습니다.");
        
    }
}
