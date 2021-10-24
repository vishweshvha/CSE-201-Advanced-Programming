import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class game{

    private static ArrayList<floor> floor_list = new ArrayList<floor>();
    private static int start = 0;
    private static int end = 0;

    public static void setup(){
        floor f0 = new empty(0);
        floor f1 = new empty(1);
        floor f2 = new ladder("the Elevator Floor", 2, 8, 4);
        floor f3 = new cheat(3);
        floor f4 = new empty(4);
        floor f5 = new snake("the Snake Floor", 5, 4, 2);
        floor f6 = new empty(6);
        floor f7 = new empty(7);
        floor f8 = new ladder("the Ladder Floor", 8, 4, 2);
        floor f9 = new empty(9);
        floor f10 = new empty(10);
        floor f11 = new snake("the King Cobra Floor", 11, 8, 4);
        floor f12 = new empty(12);
        floor f13 = new empty(13);

        floor_list.add(f0);
        floor_list.add(f1);
        floor_list.add(f2);
        floor_list.add(f3);
        floor_list.add(f4);
        floor_list.add(f5);
        floor_list.add(f6);
        floor_list.add(f7);
        floor_list.add(f8);
        floor_list.add(f9);
        floor_list.add(f10);
        floor_list.add(f11);
        floor_list.add(f12);
        floor_list.add(f13);
        System.out.println("The game setup is ready");
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the player name and hit enter");
        String name = scan.nextLine();
        setup();
        floor f = floor_list.get(0);
        player p = new player(name, f.getId());
        dice d = new dice();

        while(end!=1){
            System.out.println("--------------------------");
            System.out.println("Hit enter to roll the dice");
            scan.nextLine();
            int dice_value = d.roll();
            if((dice_value == 2) && (start == 0)){
                System.out.println("Game cannot start until you get 1");
                continue;
            }

            if((dice_value == 1) && (start == 0)) start = 1;

            if((dice_value == 2) && (p.getPosition() == 12)){
                System.out.println("Player cannot move");
                continue;
            }

            p.setPosition(dice_value);
            if(p.printPosition() == 13) end = 1;
            f = floor_list.get(p.getPosition());
            f.printStatus(p.getName());
            p.setPoints(f.getPoints());
            p.setPosition(f.getPosition());
            p.printPoints();
            if(p.getPosition() == 13) break;
        }

        System.out.println("--------------------------");
        System.out.println("Game Over");
        p.printFinal();
    }
}