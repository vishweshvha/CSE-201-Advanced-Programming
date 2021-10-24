import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class dice{
    private int number_faces;
    private int face_value = 0;
    private static Random rand = new Random();
    public dice(){
        number_faces = 2;
    }

    public int roll() {
        int value = 1 + rand.nextInt(number_faces);
        if ((value <= number_faces) && (value > 0)) face_value = value;
        System.out.println("Dice gave " + face_value);
        return face_value;
    }
}