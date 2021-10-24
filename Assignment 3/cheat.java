import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class cheat extends floor{
    public cheat(int floor_id){
        type = "the Cheat Floor";
        id = floor_id;
        position_factor = 0;
        point_factor = 2;
    }

    @Override
    public int getPoints(){
        String choice;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Would you like to cheat? (y/n)");
        choice = scan.nextLine();
        if(choice.equals("y")){
            int value = 1 + rand.nextInt(2);
            if(value == 1){
                System.out.println("You got lucky! Here's 10 points extra for you!");
                position_factor = 10;
                point_factor = 10;
            }

            else{
                System.out.println("Oops! You got caught cheating! That's a -10 points!");
                position_factor = -3;
                point_factor = -10;
            }
        }
        else System.out.println("That's fair! Here's an extra point for you anyway!");
        return point_factor;
    }
}