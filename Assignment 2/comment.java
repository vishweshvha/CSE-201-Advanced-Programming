import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public class comment{
    private String data;
    private Date date = new Date();
    private String commenter;

    public comment(String data1, Date date1, String commenter1){
        data = data1;
        date = date1;
        commenter = commenter1;
    }

    public void viewComment(){
        System.out.println(data+" - "+commenter);
        System.out.println(date+"\n");
    }
}