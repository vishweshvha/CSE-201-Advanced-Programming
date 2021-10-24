import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class floor{
    protected String type;
    protected int id;
    protected int position_factor;
    protected int point_factor;

    public int getId(){
        return id;
    }

    public int getPoints(){
        return point_factor;
    }

    public int getPosition(){
        return position_factor;
    }

    public void printStatus(String name){
        System.out.println(name + " has reached " + type);
    }
}