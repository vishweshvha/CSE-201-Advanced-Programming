import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public class assignment implements assessment{
    private String problem;
    private String student;
    private int max;
    private int mark;
    private int id;
    private String data;
    private String grader;
    public int open = 1;
    public int grade = 0;
    public int sub = 0;

    public assignment(String problem1, int max1, int id1, String student1){
        problem = problem1;
        max = max1;
        id = id1;
        student = student1;
    }

    public assessment clone(String student1){
        assessment A = new assignment(problem, max, id, student1);
        return A;
    }

    public String getStudent(){
        return student;
    }

    public void viewAssessment(){
        if(open == 1){
            System.out.println("ID: "+id+" Assignment: "+problem+" Max Marks: "+max);
            System.out.println("----------------");
        }
    }

    public void gradeAssessment(String name){
        Scanner scan = new Scanner(System.in);
        grade = 1;
        System.out.println("Submission: "+data);
        System.out.println("Max Marks: "+max);
        System.out.println("Max scored: ");
        mark = scan.nextInt();
        grader = name;
    }

    public void closeAssessment(int id1){
        if(id1 == id) open = 0;
    }

    public int getId(){
        return id;
    }

    public String getData(){
        return data;
    }

    public int getMark(){
        return mark;
    }

    public int getGrade(){
        return grade;
    }

    public int getSub(){
        return sub;
    }

    public void submission(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter filename of assignment:");
        data = scan.nextLine();
        if(data.endsWith(".zip")){
            data = data;
            sub = 1;
        }
        else{
            System.out.println("Invalid Filename");
            data = "null";
        }
    }

    public void printGraded(){
        if(open == 1){
            if((grade == 1) && (sub == 1)){
                System.out.println("Submission: "+data);
                System.out.println("Marks scored: "+mark);
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