import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class soft_toy implements Cloneable{
    private String name;
    public soft_toy(String _name){
        name = _name;
    }

    public soft_toy clone(){
        try{
            soft_toy S = (soft_toy) super.clone();
            return S;
        } catch (CloneNotSupportedException e){
            return null;
        }
    }

    public String getName(){
        return name;
    }
}