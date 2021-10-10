import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Hospital{
    String name;
    int pincode;
    private static int count;
    int id;

    public LinkedList<Slot> hospital_slots = new LinkedList<Slot>();

    public Hospital(String _name, int _pincode){
        name = _name;
        pincode = _pincode;
        id = 100000 + count;
        count = count + 1;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getPincode(){
        return pincode;
    }

    public void printd(){
        System.out.println(hospital_slots);
    }
}

class Citizen{
    String name;
    String id;
    int age ;
    Vaccine vax;
    int dose;
    int due_date;
    String status;

    public Citizen(String _name,String _id, int _age){
        name = _name;
        id = _id ;
        age = _age;
        dose = 0;
        status = "REGISTERED";
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public int getAge(){
        return age;
    }

    public Vaccine getVax(){
        return vax;
    }

    public int getDose(){
        return dose;
    }

    public int getDueDate(){
        return due_date;
    }

    public void setVax(Vaccine vaccine){
        vax = vaccine;
    }

    public void setDose(int x){
        dose = x;
    }

    public void setDueDate(int x){
        due_date = x;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(){
        if(dose == 0){
            status = "REGISTERED";
        }
        else if (0<dose && dose < vax.getDoses()){
            status = "PARTIALLY VACCINATED";
        }
        else{
            status = "FULLY VACCINATED";
        }
    }
}

class Vaccine{
    String name ;
    int doses;
    int gap;

    public LinkedList<Hospital> hospital_vax = new LinkedList<Hospital>();

    public Vaccine(String _name, int _doses, int _gap){
        name = _name;
        doses = _doses;
        gap = _gap;
    }

    public String getName(){
        return name;
    }

    public int getDoses(){
        return doses;
    }

    public int getGap(){
        return gap;
    }
}

class Slot{
    int day_number;
    int quantity;
    Vaccine vaccine;

    public Slot(int _day_number, int _quantity, Vaccine _vaccine){
        day_number = _day_number;
        quantity = _quantity;
        vaccine = _vaccine;
    }

    public int getDayNumber(){
        return day_number;
    }

    public int getQuantity(){
        return quantity;
    }

    public Vaccine getVaccine(){
        return vaccine;
    }

    public void ResetQuantity(){
        if(quantity < 0) quantity = 0;
    }

    public void DecreaseQuantity(int x){
        quantity = quantity - x;
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
        int choice = 0;

        //Vaccine Variables
        String vaccine_name = new String();
        int dose = 0;
        int gap = 0;
        LinkedList<Vaccine> vaccine_list = new LinkedList<Vaccine>();

        //Hospital Variables
        String hospital_name = new String();
        int hospital_id;
        int pincode;
        LinkedList<Hospital> hospital_list = new LinkedList<Hospital>();

        //Citizen Variables
        String citizen_name = new String();
        String citizen_id = new String();
        int age;
        LinkedList<Citizen> citizen_list = new LinkedList<Citizen>();

        //Slot Variables
        int day_number;
        int quantity;
        int slots;
        int vaccine_choice;

        String patient_id = new String();
        int booking_choice;
        int booking_pincode;
        int booking_hospital_id = 0;
        int slotchoose;
        LinkedList<Slot> available_slots = new LinkedList<Slot>();

        String vax_name = new String();
        int slotchooseagain;
        int slotchooseagainagain;
        LinkedList<Hospital> hospitals = new LinkedList<Hospital>();

        String pat_id = new String();


        int hos_id;

        Scanner scan = new Scanner(System.in);
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
                    System.out.print("Gap between Doses: ");
                    gap = scan.nextInt();

                    Vaccine v = new Vaccine(vaccine_name, dose, gap);
                    vaccine_list.add(v);

                    System.out.println("Vaccine Name: " + v.getName() + ", Number of Doses: " + v.getDoses() +", Gap between Doses: "+ v.getGap());

                    continue;

                case 2:
                    System.out.println("Hospital Name: ");
                    scan.nextLine();
                    hospital_name = scan.nextLine();
                    System.out.print("Pincode: ");
                    pincode = scan.nextInt();

                    Hospital h = new Hospital(hospital_name, pincode);
                    hospital_list.add(h);

                    System.out.println("Hospital Name: "+ h.getName() +", Pincode: "+ h.getPincode()+", Unique Id: " + h.getId());

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
                            System.out.println("Citizen Name: "+ c.getName() +", Citizen Age: "+ c.getAge() + ", Citizen Id: " + c.getId());
                        }

                        else System.out.println("Only citizens 18 or older are allowed!");
                    }

                    else System.out.println("ID should have 12 digits");

                    continue;

                case 4:
                    System.out.print("Enter Hospital ID: ");
                    hospital_id = scan.nextInt();
                    Hospital hos = hospital_list.get(0);

                    for(int i=0; i<hospital_list.size();i++){
                        hos = hospital_list.get(i);
                        if (hos.getId() == hospital_id) break;
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
                            System.out.println(j + ". " + v.getName());
                        }
                        vaccine_choice = scan.nextInt();

                        Vaccine vslot = vaccine_list.get(vaccine_choice);
                        Slot s = new Slot(day_number, quantity, vslot);
                        hos.hospital_slots.add(s);
                        if(vslot.hospital_vax.isEmpty() || !vslot.hospital_vax.contains(hos)) vslot.hospital_vax.add(hos);
                        System.out.println("Slot Added by Hospital "+ hos.getId() + " for Day: " + s.getDayNumber() + " , Quantity Available: " + s.getQuantity() + " of Vaccine " + vslot.getName());
                    }

                    continue;

                case 5:
                    System.out.print("Enter patient Unique Id:");
                    scan.nextLine();
                    patient_id = scan.nextLine();
                    Citizen cbook = citizen_list.get(0);

                    for (int i=0;i<citizen_list.size();i++){
                        cbook = citizen_list.get(i);
                        if(cbook.getId().equals(patient_id)) break;
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
                                    if (H.getPincode() == booking_pincode) hospitals.add(H);
                                }

                                if (hospitals.isEmpty()) System.out.println("No hospitals in your area");

                                else{
                                    for (int i=0;i<hospitals.size();i++){
                                        System.out.println(hospitals.get(i).getId() + " " + hospitals.get(i).getName());
                                    }

                                    System.out.print("Enter hospital id: ");
                                    booking_hospital_id = scan.nextInt();
                                    Hospital booking_hospital = hospital_list.get(0);

                                    for (int i=0; i<hospitals.size();i++){
                                        booking_hospital = hospitals.get(i);
                                        if (booking_hospital.getPincode() == booking_pincode && booking_hospital.getId() == booking_hospital_id) break;
                                    }

                                    hospitals.clear();

                                    if (booking_hospital.getId() != booking_hospital_id) System.out.println("Invalid Hospital ID");

                                    else {

                                        if (cbook.getDose() == 0){

                                            Slot s = booking_hospital.hospital_slots.get(0);

                                            for (int i=0;i<booking_hospital.hospital_slots.size();i++){
                                                s = booking_hospital.hospital_slots.get(i);
                                                s.ResetQuantity();
                                                System.out.println(i+"->"+"Day:"+s.getDayNumber()+", Available Quantity: "+s.getQuantity()+", Vaccine: "+ s.getVaccine().getName());
                                            }

                                            System.out.print("Choose slot: ");
                                            slotchoose = scan.nextInt();
                                            System.out.println(" ");
                                            Slot ChosenSlot = booking_hospital.hospital_slots.get(slotchoose);
                                            if(ChosenSlot.getQuantity()>0){
                                                System.out.println("Slot Booked");
                                                ChosenSlot.DecreaseQuantity(1);
                                                cbook.setDose(cbook.getDose()+1);
                                                cbook.setVax(ChosenSlot.getVaccine());

                                                if (cbook.getDose()<cbook.getVax().getDoses()) cbook.setDueDate(ChosenSlot.getDayNumber()+ChosenSlot.getVaccine().getGap());

                                                cbook.setStatus();
                                            }

                                            else System.out.println("Slot Unavailable");
                                        }

                                        else if (0<cbook.getDose() && cbook.getDose()<cbook.getVax().getDoses()){

                                            Slot sbook = booking_hospital.hospital_slots.get(0);
                                            System.out.println(available_slots);

                                            for (int i=0;i<booking_hospital.hospital_slots.size();i++){
                                                sbook = booking_hospital.hospital_slots.get(i);
                                                sbook.ResetQuantity();
                                                if (sbook.getDayNumber()>=cbook.getDueDate() && sbook.getVaccine().getName().equals(cbook.getVax().getName()) && sbook.getQuantity()>0){
                                                    available_slots.add(sbook);
                                                }
                                            }
                                            System.out.println(available_slots);
                                            if (!available_slots.isEmpty()){
                                                Slot slottoprint =available_slots.get(0);
                                                for (int i=0;i<available_slots.size();i++){
                                                    slottoprint = available_slots.get(i);
                                                    System.out.println(i+"-> Day: "+slottoprint.getDayNumber()+", Available Quantity: "+slottoprint.getQuantity()+", Vaccine Name: "+slottoprint.getVaccine().getName());

                                                }

                                                System.out.print("Enter Slot: ");
                                                slotchoose = scan.nextInt();
                                                Slot SlotChosen = available_slots.get(slotchoose);
                                                System.out.println("Slot Booked");
                                                SlotChosen.DecreaseQuantity(1);

                                                cbook.setDose(cbook.getDose()+1);
                                                if (cbook.getDose()<cbook.getVax().getDoses()) cbook.setDueDate(SlotChosen.getDayNumber()+cbook.getVax().getGap());

                                                cbook.setStatus();
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
                                    if(vac.getName().equals(vax_name)) break;
                                }

                                if (!vac.getName().equals(vax_name)) System.out.println("Invalid Vaccine Name");

                                else {
                                   for (int i=0;i<vac.hospital_vax.size();i++){
                                       System.out.println(vac.hospital_vax.get(i).getId() + " " + vac.hospital_vax.get(i).getName());
                                   }

                                   System.out.print("Enter Hospital Id: ");
                                   booking_hospital_id = scan.nextInt();
                                   Hospital hbook = vac.hospital_vax.get(0);

                                   for (int i=0 ;i<vac.hospital_vax.size();i++){
                                       hbook = vac.hospital_vax.get(i);
                                       if(hbook.getId() == booking_hospital_id) break;
                                   }

                                   if(hbook.getId() != booking_hospital_id) System.out.println("Invalid ID");

                                   else{
                                       if (cbook.getDose() == 0){

                                           for(int i=0;i<hbook.hospital_slots.size();i++){
                                               hbook.hospital_slots.get(i).ResetQuantity();
                                               if (hbook.hospital_slots.get(i).getQuantity()>0 && hbook.hospital_slots.get(i).getVaccine().getName().equals(vac.getName())) System.out.println(i + "->" + "Day: " + hbook.hospital_slots.get(i).getDayNumber() + ", Available Quantity: " + hbook.hospital_slots.get(i).getQuantity() + ", Vaccine: " + vac.getName());
                                           }

                                           System.out.print("Enter slot: ");
                                           slotchooseagain = scan.nextInt();
                                           System.out.println(" ");
                                           Slot chosen = hbook.hospital_slots.get(slotchooseagain);

                                           if (chosen.getQuantity()>0 ){
                                               System.out.println("Slot Booked");
                                               chosen.DecreaseQuantity(1);
                                               cbook.setDose(cbook.getDose()+1);
                                               cbook.setVax(chosen.getVaccine());

                                               if (cbook.getDose()<cbook.getVax().getDoses()) cbook.setDueDate(chosen.getDayNumber()+chosen.getVaccine().getGap());

                                               cbook.setStatus();
                                           }

                                           else System.out.println("Slot Unavailable");
                                       }

                                       else if (0<cbook.getDose() && cbook.getDose()<cbook.getVax().getDoses()){
                                           Slot sbook = hbook.hospital_slots.get(0);
                                           for (int i=0; i<hbook.hospital_slots.size();i++){
                                               sbook = hbook.hospital_slots.get(i);
                                               sbook.ResetQuantity();
                                               System.out.println(sbook.getDayNumber() + " "+ sbook.getVaccine().getName()+ " " + sbook.getQuantity());
                                               if (sbook.getDayNumber()>=cbook.getDueDate() && sbook.getVaccine().getName().equals(cbook.getVax().getName()) && sbook.getQuantity()>0){
                                                   available_slots.add(sbook);
                                               }
                                           }

                                           System.out.println(available_slots);
                                           if (!available_slots.isEmpty()){
                                               Slot S = available_slots.get(0);
                                               for (int i=0;i<available_slots.size();i++){
                                                   S = available_slots.get(i);
                                                   S.ResetQuantity();
                                                   System.out.println(i+"->"+", Day: "+S.getDayNumber()+", Available Quantity"+S.getQuantity()+", Vaccine:"+S.getVaccine().getName());
                                               }

                                               System.out.print("Enter Slot: ");
                                               slotchooseagainagain = scan.nextInt();
                                               Slot ChosenOne = available_slots.get(slotchooseagainagain);
                                               ChosenOne.DecreaseQuantity(1);
                                               cbook.setDose(cbook.getDose()+1);

                                               if (cbook.getDose()<cbook.getVax().getDoses()) cbook.setDueDate(ChosenOne.getDayNumber()+cbook.getVax().getGap());

                                               cbook.setStatus();
                                               available_slots.clear();
                                               System.out.println("Slot Booked");
                                            }

                                           else System.out.println("Slot Unavailable");
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
                    System.out.print("Enter Hospital id: ");
                    hos_id = scan.nextInt();
                    Hospital hosp = hospital_list.get(0);

                    for (int i=0; i<hospital_list.size();i++){
                        hosp = hospital_list.get(i);
                        if (hosp.getId() == hos_id) break;
                    }

                    if (hosp.getId() == hos_id){
                        for (int i=0;i<hosp.hospital_slots.size();i++){
                            Slot hslot = hosp.hospital_slots.get(i);
                            hslot.ResetQuantity();
                            System.out.println("Day: "+ hslot.getDayNumber() + ", Vaccine: " + hslot.getVaccine().getName() + ", Available Quantity: " + hslot.getQuantity());
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
                        if (c_check.getId().equals(pat_id)) break;
                    }

                    if(!c_check.getId().equals(pat_id)) System.out.println("Invalid ID");

                    else if(c_check.getId().equals(pat_id)){
                        System.out.println(c_check.getStatus());

                        if(c_check.getStatus().equals("FULLY VACCINATED")){
                            System.out.println("Vaccine given: "+ c_check.getVax().getName());
                            System.out.println("Number of doses applied: "+ c_check.getDose());
                        }

                        else if(c_check.getStatus().equals("PARTIALLY VACCINATED")){
                            System.out.println("Vaccine given: " + c_check.getVax().getName());
                            System.out.println("Number of doses applied: " + c_check.getDose());
                            System.out.println("Due date for next dose: " + c_check.getDueDate());
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