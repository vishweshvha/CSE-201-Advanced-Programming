import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public class lectureSlide implements lectureMaterial{
    private String topic = new String();
    private String uploader;
    private Date date = new Date();
    private int no_slides;
    private ArrayList<String> content = new ArrayList<String>();

    public lectureSlide(String topic1, String uploader1, Date date1, int no_slides1, ArrayList<String> content1){
        topic = topic1;
        uploader = uploader1;
        date = date1;
        no_slides = no_slides1;
        content = content1;
    }

    public void viewMaterial(){
        System.out.println("Title: "+topic);
        for(int i=0;i<no_slides;i++){
            System.out.println("Slide "+(i+1)+": "+content.get(i));
        }
        System.out.println("Number of slides: "+no_slides);
        System.out.println("Date of upload: "+date);
        System.out.println("Uploaded by: "+uploader+"\n");
    }
}