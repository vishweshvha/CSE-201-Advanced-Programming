import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class empty extends floor{
    public empty(int floor_id){
        type = "an Empty Floor";
        id = floor_id;
        position_factor = 0;
        point_factor = 1;
    }
}