import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public class lectureVideo implements lectureMaterial{
    private String topic = new String();
    private String uploader;
    private Date date = new Date();
    private String filename;

    public lectureVideo(String topic1, String uploader1, Date date1, String filename1){
        topic = topic1;
        uploader = uploader1;
        date = date1;
        filename = filename1;
    }

    public void viewMaterial(){
        System.out.println("Title of file: "+topic);
        System.out.println("Video file: "+filename);
        System.out.println("Date of upload: "+date);
        System.out.println("Uploaded by: "+uploader+"\n");
    }
}