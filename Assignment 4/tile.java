import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class tile{
    private int tile_id;
    private soft_toy s;
    public tile(int _tile_id, soft_toy _s){
        tile_id = _tile_id;
        s = _s;
    }

    public int getId(){
        return tile_id;
    }

    public soft_toy getSoftToy(){
        return s.clone();
    }
}