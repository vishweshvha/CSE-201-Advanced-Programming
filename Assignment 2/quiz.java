import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public class quiz implements assessment{
    private String question;
    private String student;
    private int id;
    private String data;
    private String grader;
    public int open = 1;
    public int grade = 0;
    public int sub = 0;

    public quiz (String question1, int id1, String student1){
        question = question1;
        id = id1;
        student = student1;
    }

    public assessment clone(String student1){
        assessment A = new quiz(question, id, student1);
        return A;
    }

    public void viewAssessment(){
        if(open == 1){
            System.out.println("ID: "+id+" Question: "+question);
            System.out.println("----------------");
        }
    }

    public void gradeAssessment(String name){
        grade = 1;
        System.out.println("Submission: "+data);
        grader = name;
    }

    public void closeAssessment(int id1){
        if(id1 == id) open = 0;
    }

    public int getId(){
        return id;
    }

    public String getStudent(){
        return student;
    }

    public String getData(){
        return data;
    }

    public int getGrade(){
        return grade;
    }

    public int getSub(){
        return sub;
    }

    public void submission(){
        Scanner scan = new Scanner(System.in);
        System.out.println(question);
        data = scan.nextLine();
        sub = 1;
    }

    public void printGraded(){
        if(open == 1){
            if((grade == 1) && (sub == 1)){
                System.out.println("Submission: "+data);
                System.out.println("Graded by: "+grader);
                System.out.println("-----------------");
            }
        }
    }

    public void printUngraded(){
        if(open == 1){
            if((grade == 0) && (sub == 1)){
                System.out.println("Submission:"+data);
                System.out.println("-----------------");
            }
        }
    }
}