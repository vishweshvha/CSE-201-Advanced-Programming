import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class dice{
    private final int number_faces = 2;
    private int face_value = 0;
    public dice(int _number_faces) {
        number_faces = _number_faces;
        roll();
    }

    public int roll() {
        int current_face_value = 1 + rand.nextInt(number_faces);
        setFaceValue(current_face_value);
        return face_value;
    }

    private void setFaceValue (int value) {
        if ((value <= number_faces) && (value > 0)) faceValue = value;
    }
}