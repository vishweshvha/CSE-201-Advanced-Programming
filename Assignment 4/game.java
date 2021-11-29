import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class game{
    public static int tile_number(){
        Random rand = new Random();
        int value = rand.nextInt(20) + 1;
        return value;
    }
    public static int hop(){
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        int value = tile_number();
        int ans_num = 0;
        String ans_str;
        System.out.println("You landed on tile "+value);
        if(value%2 == 1){
            System.out.println("Question answer round. Integer or String?");
            String input = scan.nextLine();
            input = input.toLowerCase();
            calculator cal = new calculator();
            if(input.equals("integer")){
                cal.int_question();
                try{
                    ans_num = scan.nextInt();
                }
                catch(InputMismatchException e){
                    scan.nextLine();
                    System.out.println("Invalid Input! Please Enter an Integer.");
                    ans_num = scan.nextInt();
                }
                if(cal.check(ans_num) == 0) value = 0;
                return value;
            }
            if(input.equals("string")){
                cal.str_question();
                ans_str = scan.nextLine();
                if(cal.check(ans_str) == 0) value = 0;
                return value;
            }
            else value = 0;
        }
        return value;
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        carpet c = new carpet();
        bucket b = new bucket();
        int value;

        System.out.println("Hit enter to initialize the game");
        System.out.println("Game is ready");
        System.out.println("--------------------------");
        System.out.println("Hit enter for your first hop");
        value = hop();
        if(value == 0) System.out.println("You did not win any soft toy");
        else b.append(c.getSoftToy(value));
        System.out.println("--------------------------");
        System.out.println("Hit enter for your second hop");
        value = hop();
        if(value == 0) System.out.println("You did not win any soft toy");
        else b.append(c.getSoftToy(value));
        System.out.println("--------------------------");
        System.out.println("Hit enter for your three hop");
        value = hop();
        if(value == 0) System.out.println("You did not win any soft toy");
        else b.append(c.getSoftToy(value));
        System.out.println("--------------------------");
        System.out.println("Hit enter for your fourth hop");
        value = hop();
        if(value == 0) System.out.println("You did not win any soft toy");
        else b.append(c.getSoftToy(value));
        System.out.println("--------------------------");
        System.out.println("Hit enter for your fifth hop");
        value = hop();
        if(value == 0) System.out.println("You did not win any soft toy");
        else b.append(c.getSoftToy(value));
        System.out.println("--------------------------");
        System.out.println("Game Over");
        b.printBucket();
    }
}