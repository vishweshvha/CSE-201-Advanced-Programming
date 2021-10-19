import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public class instructor implements backpack_user{
    private String name;
    private ArrayList<assessment> assessment_list = new ArrayList<assessment>();

    public instructor(String name1){
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
        System.out.println("List of Open Assessements: ");
        for(int i=0; i<assessment_list.size(); i++){
            assessment A = assessment_list.get(i);
            A.viewAssessment();
        }
    }

    public void grades(assessment submission){
        submission.gradeAssessment(name);
    }

    public assessment submission(int id){
        assessment A = assessment_list.get(0);
        return A;
    }
}