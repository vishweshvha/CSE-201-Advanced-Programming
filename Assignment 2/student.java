import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public class student implements backpack_user{
    private String name;
    private ArrayList<assessment> assessment_list = new ArrayList<assessment>();

    public student(String name1){
        name = name1;
    }

    public String getName(){
        return name;
    }

    public void setAssessment(assessment A){
        assessment_list.add(A);
    }

    public void closeAssessment(int close){
        for(int i=0; i<assessment_list.size(); i++){
            assessment A = assessment_list.get(i);
            A.closeAssessment(close);
        }
    }

    public void viewOpen(){
        System.out.println("Pending assessments: ");
        for(int i=0; i<assessment_list.size(); i++){
            assessment A = assessment_list.get(i);
            if(A.getSub() == 0) A.viewAssessment();
        }
    }

    public void grades(assessment submissions){
        System.out.println("Graded submissions: ");
        for(int i=0; i<assessment_list.size(); i++){
            assessment A = assessment_list.get(i);
            A.printGraded();
        }

        System.out.println("Ungraded submissions: ");
        for(int i=0; i<assessment_list.size(); i++){
            assessment A = assessment_list.get(i);
            A.printUngraded();
        }
    }

    public assessment submission(int id){
        assessment As = assessment_list.get(0);
        for(int i=0; i<assessment_list.size(); i++){
            assessment A = assessment_list.get(i);
            if(id == A.getId()){
                A.submission();
                return A;
            }
        }
        return As;
    }
}