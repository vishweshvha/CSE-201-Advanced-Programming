import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class player{
    private String player_name;
    private int points;
    private int player_position;
    public player(String name, int position){
        player_name = name;
        player_position = position;
        points = 0;
    }

    public String getName(){
        return player_name;
    }

    public int getPosition(){
        return player_position;
    }

    public void setPoints(int new_points){
        points = points + new_points;
    }

    public void setPosition(int position){
        player_position = player_position + position;
    }

    public int printPosition(){
        System.out.println("Player Position: Floor " + player_position);
        return player_position;
    }

    public void printPoints(){
        System.out.println("Total Points: " + points);
    }

    public void printFinal(){
        System.out.println(player_name + " accumulated " + points + " points");
    }
}