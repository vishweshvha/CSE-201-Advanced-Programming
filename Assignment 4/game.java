import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class game{
    public int tile_number(){
        Random rand = new Random();
        int value = rand.nextInt(20) + 1;
        return value;
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        carpet c = new carpet();
        calculator i = new integer();
        calculator s = new string();
        bucket b = new bucket();

        System.out.println("Hit enter to initialize the game");
        System.out.println("Game is ready");
        System.out.println("--------------------------");
        System.out.println("Hit enter for your first hop");
        System.out.println("--------------------------");
        System.out.println("Hit enter for your second hop");
        System.out.println("--------------------------");
        System.out.println("Hit enter for your three hop");
        System.out.println("--------------------------");
        System.out.println("Hit enter for your fourth hop");
        System.out.println("--------------------------");
        System.out.println("Hit enter for your fifth hop");
        System.out.println("--------------------------");
        System.out.println("Game Over");
        System.out.println("Soft toys won by you are:");
    }
}