import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Hospital{
    String name;
    int pincode;
    int id;

    private static int count;

    public Hospital(String name1, int pincode1){
        name = name1;
        pincode = pincode1;
        id = 100000 + count;
        count = count + 1;
    }

    public int findId(){
        return id;
    }

    public String findName(){
        return name;
    }

    public int findPincode(){
        return pincode;
    }

    public void printd(){
        System.out.println(hospital_slots);
    }

    public LinkedList<Slot> hospital_slots = new LinkedList<Slot>();
}

class Citizen{
    String name;
    String id;
    String status;
    int age ;
    int dose;
    int due_date;
    Vaccine vax;

    public Citizen(String name1,String id1, int age1){
        name = name1;
        id = id1;
        age = age1;
        dose = 0;
        status = "REGISTERED";
    }

    public void updateVax(Vaccine vaccine){
        vax = vaccine;
    }

    public void updateDose(int d){
        dose = d;
    }

    public void updateDueDate(int date){
        due_date = date;
    }

    public String findStatus(){
        return status;
    }

    public String findName(){
        return name;
    }

    public Vaccine findVax(){
        return vax;
    }

    public int findDose(){
        return dose;
    }

    public int findDueDate(){
        return due_date;
    }

    public String findId(){
        return id;
    }

    public int findAge(){
        return age;
    }

    public void updateStatus(){
        if(dose == 0) status = "REGISTERED";
        else if (dose < vax.findDoses() && 0 < dose ) status = "PARTIALLY VACCINATED";
        else status = "FULLY VACCINATED";
    }
}

class Vaccine{
    String name ;
    int doses;
    int gap;

    public Vaccine(String name1, int doses1, int gap1){
        name = name1;
        doses = doses1;
        gap = gap1;
    }

    public String findName(){
        return name;
    }

    public int findDoses(){
        return doses;
    }

    public int findGap(){
        return gap;
    }

    public LinkedList<Hospital> hospital_vax = new LinkedList<Hospital>();
}

class Slot{
    int day_number;
    int quantity;
    Vaccine vaccine;

    public Slot(Vaccine vaccine1, int day_number1, int quantity1){
        day_number = day_number1;
        quantity = quantity1;
        vaccine = vaccine1;
    }

    public void changeQuantity(){
        if(quantity < 0) quantity = 0;
    }

    public void decreaseQuantity(int q){
        quantity = quantity - q;
    }

    public void increaseQuantity(int q){
        quantity = quantity + q;
    }

    public int findDayNumber(){
        return day_number;
    }

    public int findQuantity(){
        return quantity;
    }

    public Vaccine findVaccine(){
        return vaccine;
    }

}

public class main{
    public static void menu(){
        System.out.println("---------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("---------------------------------");
    }

    public static void main(String args[]){

        String hospital_name = new String();
        int hospital_id;
        int pincode;

        String citizen_name = new String();
        String citizen_id = new String();
        int age;

        String patient_id = new String();
        int booking_choice;
        int booking_pincode;
        int booking_hospital_id = 0;
        int slot_choice;
        String vax_name = new String();
        String pat_id = new String();
        int hos_id;
        int choice = 0;

        int day_number;
        int quantity;
        int slots;
        int vaccine_choice;

        String vaccine_name = new String();
        int dose = 0;
        int gap = 0;

        LinkedList<Hospital> hospital_list = new LinkedList<Hospital>();
        LinkedList<Vaccine> vaccine_list = new LinkedList<Vaccine>();
        LinkedList<Citizen> citizen_list = new LinkedList<Citizen>();
        LinkedList<Hospital> hospitals = new LinkedList<Hospital>();
        LinkedList<Slot> available_slots = new LinkedList<Slot>();

        Scanner scan = new Scanner(System.in);
        System.out.println("CoWin Portal initialized....");
        while(choice!=8){
            menu();
            System.out.print("Enter choice: ");
            choice = scan.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Vaccine Name: ");
                    scan.nextLine();
                    vaccine_name = scan.nextLine();
                    System.out.print("Number of Doses: ");
                    dose = scan.nextInt();
                    if (dose == 1) gap = 0;

                    else{
                        System.out.print("Gap between Doses: ");
                        gap = scan.nextInt();
                    }

                    Vaccine v = new Vaccine(vaccine_name, dose, gap);
                    vaccine_list.add(v);

                    System.out.println("Vaccine Name: " + v.findName() + ", Number of Doses: " + v.findDoses() +", Gap between Doses: "+ v.findGap());

                    continue;

                case 2:
                    System.out.println("Hospital Name: ");
                    scan.nextLine();
                    hospital_name = scan.nextLine();
                    System.out.print("Pincode: ");
                    pincode = scan.nextInt();

                    Hospital h = new Hospital(hospital_name, pincode);
                    hospital_list.add(h);

                    System.out.println("Hospital Name: "+ h.findName() +", Pincode: "+ h.findPincode()+", Unique Id: " + h.findId());

                    continue;

                case 3:
                    System.out.println("Citizen Name: ");
                    scan.nextLine();
                    citizen_name = scan.nextLine();
                    System.out.print("Citizen Age: ");
                    age = scan.nextInt();
                    System.out.print("Citizen Unique Id: ");
                    scan.nextLine();
                    citizen_id = scan.nextLine();

                    if (citizen_id.length() == 12){

                        if(age >= 18){
                            Citizen c = new Citizen(citizen_name, citizen_id, age);
                            citizen_list.add(c);
                            System.out.println("Citizen Name: "+ c.findName() +", Citizen Age: "+ c.findAge() + ", Citizen Id: " + c.findId());
                        }

                        else System.out.println("Only above 18 are allowed");
                    }

                    else System.out.println("ID should have 12 digits");

                    continue;

                case 4:
                    System.out.print("Enter Hospital ID: ");
                    hospital_id = scan.nextInt();
                    Hospital hos = hospital_list.get(0);

                    for(int i=0; i<hospital_list.size();i++){
                        hos = hospital_list.get(i);
                        if (hos.findId() == hospital_id) break;
                    }

                    System.out.print("Enter number of Slots to be added: ");
                    slots = scan.nextInt() ;

                    for (int i=0;i<slots;i++){
                        System.out.print("Enter Day Number: ");
                        day_number = scan.nextInt();
                        System.out.print("Enter Quantity: ");
                        quantity = scan.nextInt();
                        System.out.println("Select Vaccine");
                        for (int j=0 ; j<vaccine_list.size();j++){
                            v = vaccine_list.get(j);
                            System.out.println(j + ". " + v.findName());
                        }
                        vaccine_choice = scan.nextInt();

                        Vaccine vslot = vaccine_list.get(vaccine_choice);

                        int slot_c = 0;

                        if (!hos.hospital_slots.isEmpty()){
                            Slot s = hos.hospital_slots.get(0);
                            for (int k=0;k<hos.hospital_slots.size();k++){
                                s = hos.hospital_slots.get(k);
                                if (day_number == s.findDayNumber() && vslot == s.findVaccine()){
                                    s.increaseQuantity(quantity);
                                    System.out.println("Slot Updated by Hospital "+ hos.findId() + " for Day: " + s.findDayNumber() + " , Quantity Available: " + s.findQuantity() + " of Vaccine " + vslot.findName());
                                    slot_c = 1;
                                    break;
                                }
                            }
                        }

                        if (slot_c == 0){
                            Slot s = new Slot(vslot, day_number, quantity);
                            hos.hospital_slots.add(s);
                            if(!vslot.hospital_vax.contains(hos) || vslot.hospital_vax.isEmpty()) vslot.hospital_vax.add(hos);
                            System.out.println("Slot Added by Hospital "+ hos.findId() + " for Day: " + s.findDayNumber() + " , Quantity Available: " + s.findQuantity() + " of Vaccine " + vslot.findName());
                        }
                    }

                    continue;

                case 5:
                    System.out.print("Enter patient Unique Id:");
                    scan.nextLine();
                    patient_id = scan.nextLine();
                    Citizen cbook = citizen_list.get(0);

                    for (int i=0;i<citizen_list.size();i++){
                        cbook = citizen_list.get(i);
                        if(cbook.findId().equals(patient_id)) break;
                    }

                    if(patient_id.length() != 12) System.out.println("ID should have 12 digits");

                    else{
                        System.out.println("1. Search by area");
                        System.out.println("2. Seach by vaccine");
                        System.out.println("3. Exit");
                        System.out.println("Enter option: ");
                        booking_choice = scan.nextInt();
                        switch(booking_choice){
                            case 1:
                                System.out.print("Enter pincode: ");
                                booking_pincode = scan.nextInt();
                                Hospital H = hospital_list.get(0);

                                for(int i=0;i<hospital_list.size();i++){
                                    H=hospital_list.get(i);
                                    if (H.findPincode() == booking_pincode) hospitals.add(H);
                                }

                                if (hospitals.isEmpty()) System.out.println("No hospitals in your area");

                                else{
                                    for (int i=0;i<hospitals.size();i++){
                                        System.out.println(hospitals.get(i).findId() + " " + hospitals.get(i).findName());
                                    }

                                    System.out.print("Enter hospital id: ");
                                    booking_hospital_id = scan.nextInt();
                                    Hospital booking_hospital = hospital_list.get(0);

                                    for (int i=0; i<hospitals.size();i++){
                                        booking_hospital = hospitals.get(i);
                                        if (booking_hospital.findPincode() == booking_pincode && booking_hospital.findId() == booking_hospital_id) break;
                                    }

                                    hospitals.clear();

                                    if (booking_hospital.findId() != booking_hospital_id) System.out.println("Invalid Hospital ID");

                                    else {

                                        if (cbook.findDose() == 0){

                                            Slot s = booking_hospital.hospital_slots.get(0);

                                            for (int i=0;i<booking_hospital.hospital_slots.size();i++){
                                                s = booking_hospital.hospital_slots.get(i);
                                                s.changeQuantity();
                                                System.out.println(i+"->"+"Day:"+s.findDayNumber()+", Available Quantity: "+s.findQuantity()+", Vaccine: "+ s.findVaccine().findName());
                                            }

                                            System.out.print("Choose slot: ");
                                            slot_choice = scan.nextInt();
                                            Slot picked_slot = booking_hospital.hospital_slots.get(slot_choice);
                                            if(picked_slot.findQuantity()>0){
                                                picked_slot.decreaseQuantity(1);
                                                cbook.updateDose(cbook.findDose()+1);
                                                cbook.updateVax(picked_slot.findVaccine());

                                                if (cbook.findDose()<cbook.findVax().findDoses()) cbook.updateDueDate(picked_slot.findDayNumber()+picked_slot.findVaccine().findGap());

                                                cbook.updateStatus();
                                                System.out.println(cbook.findName() + " vaccinated with " + cbook.findVax().findName());
                                            }

                                            else System.out.println("No slots available");
                                        }

                                        else if (cbook.findDose() < cbook.findVax().findDoses() && cbook.findDose() > 0){

                                            Slot sbook = booking_hospital.hospital_slots.get(0);

                                            for (int i=0;i<booking_hospital.hospital_slots.size();i++){
                                                sbook = booking_hospital.hospital_slots.get(i);
                                                sbook.changeQuantity();
                                                if (sbook.findDayNumber() >= cbook.findDueDate() && sbook.findVaccine().findName().equals(cbook.findVax().findName()) && sbook.findQuantity()>0){
                                                    available_slots.add(sbook);
                                                }
                                            }

                                            if (!available_slots.isEmpty()){
                                                Slot new_slot = available_slots.get(0);
                                                for (int i=0;i<available_slots.size();i++){
                                                    new_slot = available_slots.get(i);
                                                    System.out.println(i+"-> Day: " + new_slot.findDayNumber()+ ", Available Quantity: " + new_slot.findQuantity() + ", Vaccine Name: " + new_slot.findVaccine().findName());

                                                }

                                                System.out.print("Choose slot: ");
                                                slot_choice = scan.nextInt();
                                                Slot picked_slot = available_slots.get(slot_choice);

                                                cbook.updateDose(cbook.findDose()+1);
                                                if (cbook.findDose()<cbook.findVax().findDoses()) cbook.updateDueDate(picked_slot.findDayNumber()+cbook.findVax().findGap());

                                                cbook.updateStatus();
                                                System.out.println(cbook.findName() + " vaccinated with " + cbook.findVax().findName());
                                                picked_slot.decreaseQuantity(1);
                                                available_slots.clear();

                                            }

                                            else System.out.println("No slots available");
                                        }
                                    }
                                }

                                continue;

                            case 2:

                                System.out.print("Enter Vaccine Name: ");
                                scan.nextLine();
                                vax_name = scan.nextLine();
                                Vaccine vac = vaccine_list.get(0);
                                for (int i=0;i<vaccine_list.size();i++){
                                    vac = vaccine_list.get(i);
                                    if(vac.findName().equals(vax_name)) break;
                                }

                                if (!vac.findName().equals(vax_name)) System.out.println("Invalid Vaccine Name");

                                else {
                                   for (int i=0;i<vac.hospital_vax.size();i++){
                                       System.out.println(vac.hospital_vax.get(i).findId() + " " + vac.hospital_vax.get(i).findName());
                                   }

                                   System.out.print("Enter Hospital Id: ");
                                   booking_hospital_id = scan.nextInt();
                                   Hospital hbook = vac.hospital_vax.get(0);

                                   for (int i=0 ;i<vac.hospital_vax.size();i++){
                                       hbook = vac.hospital_vax.get(i);
                                       if(hbook.findId() == booking_hospital_id) break;
                                   }

                                   if(hbook.findId() != booking_hospital_id) System.out.println("Invalid ID");

                                   else{
                                       if (cbook.findDose() == 0){

                                           for(int i=0;i<hbook.hospital_slots.size();i++){
                                               hbook.hospital_slots.get(i).changeQuantity();
                                               if (hbook.hospital_slots.get(i).findQuantity()>0 && hbook.hospital_slots.get(i).findVaccine().findName().equals(vac.findName())) System.out.println(i + "->" + "Day: " + hbook.hospital_slots.get(i).findDayNumber() + ", Available Quantity: " + hbook.hospital_slots.get(i).findQuantity() + ", Vaccine: " + vac.findName());
                                           }

                                           System.out.print("Choose slot: ");
                                           slot_choice = scan.nextInt();
                                           Slot chosen = hbook.hospital_slots.get(slot_choice);

                                           if (chosen.findQuantity()>0 ){
                                               chosen.decreaseQuantity(1);
                                               cbook.updateDose(cbook.findDose()+1);
                                               cbook.updateVax(chosen.findVaccine());

                                               if (cbook.findVax().findDoses() > cbook.findDose()) cbook.updateDueDate(chosen.findDayNumber()+chosen.findVaccine().findGap());

                                               cbook.updateStatus();
                                               System.out.println(cbook.findName() + " vaccinated with " + cbook.findVax().findName());
                                           }

                                           else System.out.println("No slots available");
                                       }

                                       else if (cbook.findDose() < cbook.findVax().findDoses() && cbook.findDose() > 0){
                                           Slot sbook = hbook.hospital_slots.get(0);
                                           for (int i=0; i<hbook.hospital_slots.size();i++){
                                               sbook = hbook.hospital_slots.get(i);
                                               sbook.changeQuantity();
                                               if (cbook.findDueDate() <= sbook.findDayNumber() && sbook.findVaccine().findName().equals(cbook.findVax().findName()) && sbook.findQuantity()>0){
                                                   available_slots.add(sbook);
                                               }
                                           }

                                           if (!available_slots.isEmpty()){
                                               Slot S = available_slots.get(0);
                                               for (int i=0;i<available_slots.size();i++){
                                                   S = available_slots.get(i);
                                                   S.changeQuantity();
                                                   System.out.println(i+"->"+" Day: "+S.findDayNumber()+", Available Quantity"+S.findQuantity()+", Vaccine:"+S.findVaccine().findName());
                                               }

                                               System.out.print("Choose slot: ");
                                               slot_choice = scan.nextInt();
                                               Slot picked_slot = available_slots.get(slot_choice);
                                               picked_slot.decreaseQuantity(1);
                                               cbook.updateDose(cbook.findDose()+1);

                                               if (cbook.findDose()<cbook.findVax().findDoses()) cbook.updateDueDate(picked_slot.findDayNumber()+cbook.findVax().findGap());

                                               cbook.updateStatus();
                                               available_slots.clear();
                                               System.out.println(cbook.findName() + " vaccinated with " + cbook.findVax().findName());
                                            }

                                           else System.out.println("No slots available");
                                        }
                                    }
                                }

                                continue;

                            case 3:
                                continue;
                        }
                    }

                    continue;

                case 6:
                    Hospital hosp = hospital_list.get(0);

                    System.out.print("Enter Hospital id: ");
                    hos_id = scan.nextInt();

                    for (int i=0; i<hospital_list.size();i++){
                        hosp = hospital_list.get(i);
                        if (hosp.findId() == hos_id) break;
                    }

                    if (hosp.findId() == hos_id){
                        for (int i=0;i<hosp.hospital_slots.size();i++){
                            Slot hslot = hosp.hospital_slots.get(i);
                            hslot.changeQuantity();
                            System.out.println("Day: "+ hslot.findDayNumber() + ", Vaccine: " + hslot.findVaccine().findName() + ", Available Quantity: " + hslot.findQuantity());
                        }
                    }

                    else System.out.println("Invalid ID");
                    continue;

                case 7:
                    System.out.print("Enter Patient Id: ");
                    scan.nextLine();
                    pat_id = scan.nextLine();
                    Citizen c_check = citizen_list.get(0);

                    for (int i=0;i<citizen_list.size();i++){
                        c_check = citizen_list.get(i);
                        if (c_check.findId().equals(pat_id)) break;
                    }

                    if(!c_check.findId().equals(pat_id)) System.out.println("Invalid ID");

                    else if(c_check.findId().equals(pat_id)){
                        System.out.println(c_check.findStatus());

                        if(c_check.findStatus().equals("FULLY VACCINATED")){
                            System.out.println("Vaccine given: "+ c_check.findVax().findName());
                            System.out.println("Number of doses applied: "+ c_check.findDose());
                        }

                        else if(c_check.findStatus().equals("PARTIALLY VACCINATED")){
                            System.out.println("Vaccine given: " + c_check.findVax().findName());
                            System.out.println("Number of doses applied: " + c_check.findDose());
                            System.out.println("Due date for next dose: " + c_check.findDueDate());
                        }
                    }

                    else System.out.println("Invalid Id");
                    continue;

                case 8:
                    break;
            }

            available_slots.clear();
            hospitals.clear();
        }
    }
}