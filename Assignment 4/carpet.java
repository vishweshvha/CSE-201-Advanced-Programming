import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class carpet{
    private ArrayList<tile> tile_list = new ArrayList<tile>();
    public carpet(){
        soft_toy s1 = new soft_toy("Tom");
        soft_toy s2 = new soft_toy("Jerry");
        soft_toy s3 = new soft_toy("Mickey");
        soft_toy s4 = new soft_toy("Minnie");
        soft_toy s5 = new soft_toy("Donald");
        soft_toy s6 = new soft_toy("Ralph");
        soft_toy s7 = new soft_toy("Scooby");
        soft_toy s8 = new soft_toy("Kowalski");
        soft_toy s9 = new soft_toy("Minion");
        soft_toy s10 = new soft_toy("Doraemon");
        soft_toy s11 = new soft_toy("Nobita");
        soft_toy s12 = new soft_toy("Shinchan");
        soft_toy s13 = new soft_toy("Pikachu");
        soft_toy s14 = new soft_toy("Teddy");
        soft_toy s15 = new soft_toy("Black Widow");
        soft_toy s16 = new soft_toy("Thor");
        soft_toy s17 = new soft_toy("Spider-Man");
        soft_toy s18 = new soft_toy("Iron Man");
        soft_toy s19 = new soft_toy("Hulk");
        soft_toy s20 = new soft_toy("Hawkeye");

        tile t1 = new tile(1, s1);
        tile t2 = new tile(2, s2);
        tile t3 = new tile(3, s3);
        tile t4 = new tile(4, s4);
        tile t5 = new tile(5, s5);
        tile t6 = new tile(6, s6);
        tile t7 = new tile(7, s7);
        tile t8 = new tile(8, s8);
        tile t9 = new tile(9, s9);
        tile t10 = new tile(10, s10);
        tile t11 = new tile(11, s11);
        tile t12 = new tile(12, s12);
        tile t13 = new tile(13, s13);
        tile t14 = new tile(14, s14);
        tile t15 = new tile(15, s15);
        tile t16 = new tile(16, s16);
        tile t17 = new tile(17, s17);
        tile t18 = new tile(18, s18);
        tile t19 = new tile(19, s19);
        tile t20 = new tile(20, s20);

        tile_list.add(t1);
        tile_list.add(t2);
        tile_list.add(t3);
        tile_list.add(t4);
        tile_list.add(t5);
        tile_list.add(t6);
        tile_list.add(t7);
        tile_list.add(t8);
        tile_list.add(t9);
        tile_list.add(t10);
        tile_list.add(t11);
        tile_list.add(t12);
        tile_list.add(t13);
        tile_list.add(t14);
        tile_list.add(t15);
        tile_list.add(t16);
        tile_list.add(t17);
        tile_list.add(t18);
        tile_list.add(t19);
        tile_list.add(t20);
    }

    public soft_toy getSoftToy(int id){
        tile t = tile_list.get(id-1);
        return t.getSoftToy();
    }
}