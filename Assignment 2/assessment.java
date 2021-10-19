import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public interface assessment{
    public void viewAssessment();
    public void closeAssessment(int id1);
    public int getId();
    public int getSub();
    public int getGrade();
    public void gradeAssessment(String name);
    public void printGraded();
    public void printUngraded();
    public String getData();
    public String getStudent();
    public void submission();
    public assessment clone(String student1);
}