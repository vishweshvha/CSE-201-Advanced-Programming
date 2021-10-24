import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ladder extends floor{
    public ladder(String name, int floor_id, int pos, int point){
        type = name;
        id = floor_id;
        position_factor = pos;
        point_factor = point;
    }
}