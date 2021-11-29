import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class bucket{
    private ArrayList<soft_toy> toy_list = new ArrayList<soft_toy>();
    private int empty = 0;
    public bucket(){
        empty = 0;
    }

    public void append(soft_toy s){
        empty = 1;
        toy_list.add(s);
        System.out.println("You won a "+s.getName()+" soft toy");
    }

    public void printBucket(){
        if(empty == 1){
            System.out.print("Soft toys won by you are: ");
            for (int i = 0; i < toy_list.size(); i++){
                soft_toy s = toy_list.get(i);
                System.out.print(s.getName());
                if (i != toy_list.size()-1) System.out.print(", ");
            }
            System.out.print("\n");
        }
        else System.out.println("0 Toys were won :(");
    }
}