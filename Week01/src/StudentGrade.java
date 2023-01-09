

import java.util.Scanner;

class Student{
    /**
     * 학생 객체 
     * 필드 : 이름, 국어점수, 영어점수, 수학점수, 총점, 평균
     * method : 총점 및 평균 계산 , 출력
     **/
    private String name;
    private int kor;
    private int eng;
    private int mat;

    private int total;
    private double avg;



    //생성자
    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        
        scoreCalculation();// 객체 생성 후 매개변수로 입력 받은값들의 평균과 총점을 계산
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }


    // 총점, 평균 함수
    public void scoreCalculation() {
        total = getKor() + getEng() + getMat();
        avg = ((getKor()+getEng()+getMat())/3);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", mat=" + mat +
                ", total=" + total +
                ", avg=" + avg +
                '}';
    }
}

class Teacher{
    
    /**
     * 관리자 객체
     * 필드 : 입력 받을 학생수, 여러명일 경우 배열로 관리 
     * method : 학생 추가 기능, 출력
     **/

    private int peopleCount; // 입력 받을 학생의 수

    private Student[] group; // 여러명의 학생을 배열로 관리

    public void addStudent(){
        Scanner scan = new Scanner(System.in);

        System.out.println("몇 명의 학생 정보를 입력 하시겠습니까?");
        peopleCount = scan.nextInt();

        group = new Student[peopleCount];

        infoWrite();
    }

    public void infoWrite() {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < group.length; i++){
            System.out.println("학생의 이름을 입력 하세요");
            String name = scan.next();
            System.out.println("국어-영어-수학 점수를 입력 하세요");
            int kor = scan.nextInt();
            int eng = scan.nextInt();
            int mat = scan.nextInt();
            Student student = new Student(name, kor, eng, mat);

            group[i] = student;
//            System.out.println("student = " + student.getName());
//            System.out.println(group[i].getName());
        }
            print();
    }
    public void print(){
        for (int i = 0; i < peopleCount; i++){
            Student stu = group[i];
            System.out.println(stu.toString());
//            System.out.println("["+stu.getName()+"국어 : ,"+stu.getKor()+" ,"+stu.getEng()+" ,"+stu.getMat()+" ,"+stu.getAvg()+" ,"+stu.getTotal()+"]");
        }
    }

}






public class StudentGrade {
    public static void main(String[] args) {

    Teacher teacher = new Teacher();

    teacher.addStudent();

    }
}