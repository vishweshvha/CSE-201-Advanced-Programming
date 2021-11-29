import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class calculator{
    private int truth;
    private int num1, num2;
    private String str1, str2;
    public calculator(){
        truth = 0;
    }

    public void int_question(){
        Random rand = new Random();
        num1 = rand.nextInt();
        num2 = rand.nextInt();
        if(num2 == 0) num2 = num2 + 1;
        System.out.println("Calculate the result of "+num1+" divided by "+num2);
    }

    public void str_question(){
        Random rand = new Random();
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        str1 = String.valueOf(alpha.charAt(rand.nextInt(52)))+String.valueOf(alpha.charAt(rand.nextInt(52)))+String.valueOf(alpha.charAt(rand.nextInt(52)))+String.valueOf(alpha.charAt(rand.nextInt(52)));
        str2 = String.valueOf(alpha.charAt(rand.nextInt(52)))+String.valueOf(alpha.charAt(rand.nextInt(52)))+String.valueOf(alpha.charAt(rand.nextInt(52)))+String.valueOf(alpha.charAt(rand.nextInt(52)));
        System.out.println("Calculate the concatenation of strings "+str1+" and "+str2);
    }

    public int check(int num){
        if(num == num1/num2) {
            truth = 1;
            System.out.println("Correct answer");
        }
        else{
            truth = 0;
            System.out.println("Incorrect answer");
        }
        return truth;
    }

    public int check(String str){
        if(str.equals(str1+str2)){
            truth = 1;
            System.out.println("Correct answer");
        }
        else{
            truth = 0;
            System.out.println("Incorrect answer");
        }
        return truth;
    }
}