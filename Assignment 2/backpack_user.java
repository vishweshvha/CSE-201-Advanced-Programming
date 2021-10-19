import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public interface backpack_user{
    public String getName();
    public void setAssessment(assessment A);
    public void closeAssessment(int close);
    public void viewOpen();
    public void grades(assessment submission);
    public assessment submission(int id);
}