import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int studentId;
    private String studentName;
    private int grade;

    public Student(int studentId, String studentName, int grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = grade;
    }
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getgrade(){
        return grade;
    }
}

class College {
    private int collegeId;
    private String collegeName;
    private int minRequirement;

    public College(int collegeId, String collegeName, int minRequirement) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.minRequirement= minRequirement;
    }
    public int getCollegeId() {
        return collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public int getminRequirement(){
         return minRequirement;
    }
}

class Admission {
   
    private Student student;
    private College college;

    public Admission(Student student, College college) {
        this.student = student;
        this.college = college;
    }

}

class AdmissionProcess {
    private List<College> colleges;
    private List<Student> students;
    private List<Admission> admissions;

    public AdmissionProcess() {
        colleges = new ArrayList<>();
        students = new ArrayList<>();
        admissions = new ArrayList<>();
    }

    public void addCollege(College college) {
        colleges.add(college);
    }

    public void addStudent(Student student) {
        students.add(student);
    }


     public void menu(){
          
            System.out.println("Program Started!");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Your Name:");
            String studentName=scanner.nextLine();

            System.out.println("Enter Your Grade");
            int studentGrade=scanner.nextInt();

            Student student = new Student(students.size()+1 , studentName, studentGrade);

            students.add(student);

            // System.out.println("Select College ID");

            for(College college: colleges){
                  System.out.println("Id:"+college.getCollegeId() + " "+ "College:" + college.getCollegeName());
            }
             
            int selectCollegeId= scanner.nextInt();
            System.out.println(selectCollegeId);

            College selectedCollege= null;
            Admission admission= null;

            for(College college: colleges){
                  if(college.getCollegeId() == selectCollegeId){
                          selectedCollege=college;
                          break;
                  }
            }


            if(selectedCollege.getminRequirement() <= studentGrade){
                      admission=new Admission(student, selectedCollege);
                      admissions.add(admission);
                      System.out.println("Congrats!");
            }else{
                       System.out.println("Sorry!,You are not met with college mingradeRequirement.");
            }


     }
 
}


public class Main{
    public static void main(String[] args) {
        AdmissionProcess AdmissionProcess = new AdmissionProcess();

        College college1 = new College(1, "MANIT",85);
        College college2 = new College(2, "VNIT",90);
       
        AdmissionProcess.addCollege(college1);
        AdmissionProcess.addCollege(college2);

        AdmissionProcess.menu();
    }
}
