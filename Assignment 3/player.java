import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class player(){
    private String player_name;
    private int points;
    public player(String name){
        player_name = name;
        points = 0;
    }

    public string getName(){
        return player_name;
    }

    public void setPoints(int new_points){
        points = points + new_points;
    }

    public void printPoints(){
        System.out.println("Total Points: " + points);
    }

}