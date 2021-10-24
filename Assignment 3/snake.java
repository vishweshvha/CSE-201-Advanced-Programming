import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class snake extends floor{
    public snake(String name, int floor_id, int pos, int point){
        type = name;
        id = floor_id;
        position_factor = -pos;
        point_factor = -point;
    }
}