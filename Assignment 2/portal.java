import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public class portal{

    static ArrayList<backpack_user> backpack_user_list = new ArrayList<backpack_user>();
    static ArrayList<lectureMaterial> lecture_material_list = new ArrayList<lectureMaterial>();
    static ArrayList<assessment> assessment_list = new ArrayList<assessment>();
    static ArrayList<assessment> submissions_list = new ArrayList<assessment>();
    static ArrayList<comment> comment_list = new ArrayList<comment>();
    static int count = -1;


    public static void menu(){
        System.out.println("Welcome to Backpack");
        System.out.println("MENU");
        System.out.println("1. Enter as instructor");
        System.out.println("2. Enter as student");
        System.out.println("3. Exit");
    }

    public static void instructorMenu(backpack_user I){
        Scanner scan = new Scanner(System.in);
        int instructor_choice = 0;
        int material_choice = 0;
        int assessment_choice = 0;
        int id_choice =  0;
        int sub_choice =  0;

        String topic;
        int no_slides;
        String temp;
        String filename;
        String data;
        String problem;
        int max;
        int close;

        while(instructor_choice!=9){
            System.out.println("Welcome "+I.getName());
            System.out.println("INSTRUCTOR MENU");
            System.out.println("1. Add class material");
            System.out.println("2. Add assessments");
            System.out.println("3. View lecture materials");
            System.out.println("4. View assessments");
            System.out.println("5. Grade assessments");
            System.out.println("6. Close assessment");
            System.out.println("7. View comments");
            System.out.println("8. Add comments");
            System.out.println("9. Logout");

            instructor_choice = scan.nextInt();
            switch(instructor_choice){
                case 1:
                    System.out.println("1. Add Lecture Slide");
                    System.out.println("2. Add Lecture Video");
                    material_choice = scan.nextInt();
                    ArrayList<String> content = new ArrayList<String>();
                    switch(material_choice){
                        case 1:
                            System.out.println("Enter topic of slides: ");
                            scan.nextLine();
                            topic = scan.nextLine();
                            System.out.println("Enter number of slides: ");
                            no_slides = scan.nextInt();
                            System.out.println("Enter content of slides: ");
                            scan.nextLine();
                            for (int i=0;i<no_slides;i++){
                                System.out.print("Content for slide " + (i+1) + ": ");
                                temp = scan.nextLine();
                                content.add(temp);
                            }
                            lectureMaterial Ls = new lectureSlide(topic, I.getName(), java.util.Calendar.getInstance().getTime(), no_slides, content);
                            lecture_material_list.add(Ls);
                            continue;
                        case 2:
                            System.out.println("Enter topic of video: ");
                            scan.nextLine();
                            topic = scan.nextLine();
                            System.out.println("Enter filename of video: ");
                            filename = scan.nextLine();
                            if(filename.endsWith(".mp4")){
                                lectureMaterial Lv = new lectureVideo(topic, I.getName(), java.util.Calendar.getInstance().getTime(), filename);
                                lecture_material_list.add(Lv);
                            }
                            else System.out.println("Invalid Filename");
                            continue;
                    }
                    continue;
                case 2:
                    System.out.println("1. Add Assignment");
                    System.out.println("2. Add Quiz");
                    assessment_choice = scan.nextInt();
                    switch(assessment_choice){
                        case 1:
                            System.out.println("Enter problem statement: ");
                            scan.nextLine();
                            problem = scan.nextLine();
                            System.out.println("Enter max marks: ");
                            max = scan.nextInt();
                            count++;
                            assessment A = new assignment(problem, max, count, I.getName());
                            assessment_list.add(A);
                            for(int i=0; i<backpack_user_list.size(); i++){
                                backpack_user Bu = backpack_user_list.get(i);
                                Bu.setAssessment(A.clone(Bu.getName()));
                            }
                            continue;
                        case 2:
                            System.out.println("Enter quiz question: ");
                            scan.nextLine();
                            problem = scan.nextLine();
                            count++;
                            assessment Q = new quiz(problem, count, I.getName());
                            assessment_list.add(Q);
                            for(int i=0; i<backpack_user_list.size(); i++){
                                backpack_user Bq = backpack_user_list.get(i);
                                Bq.setAssessment(Q.clone(Bq.getName()));
                            }
                            continue;
                    }
                    continue;
                case 3:
                    for(int i=0; i<lecture_material_list.size(); i++){
                        lectureMaterial L = lecture_material_list.get(i);
                        L.viewMaterial();
                    }
                    continue;
                case 4:
                    System.out.println("List of Assessments: ");
                    for(int i=0; i<assessment_list.size(); i++){
                        assessment As = assessment_list.get(i);
                        As.viewAssessment();
                    }
                    continue;
                case 5:
                    System.out.println("List of Assessments: ");
                    for(int i=0; i<assessment_list.size(); i++){
                        assessment As = assessment_list.get(i);
                        As.viewAssessment();
                    }
                    System.out.println("Enter ID of assessment to view submissions: ");
                    id_choice = scan.nextInt();
                    System.out.println("Choose ID from these ungraded submissions: ");
                    for(int i=0; i<submissions_list.size(); i++){
                        assessment Ss = submissions_list.get(i);
                        if(Ss.getId() == id_choice) System.out.println(i+" - "+Ss.getStudent());
                    }
                    sub_choice = scan.nextInt();
                    assessment Al = submissions_list.get(sub_choice);
                    I.grades(Al);
                    continue;
                case 6:
                    I.viewOpen();
                    System.out.println("Enter id of assignment to close: ");
                    close = scan.nextInt();
                    for(int i=0; i<assessment_list.size(); i++){
                        assessment Ac = assessment_list.get(i);
                        Ac.closeAssessment(close);
                    }

                    for(int i=0; i<backpack_user_list.size(); i++){
                        backpack_user Bc = backpack_user_list.get(i);
                        Bc.closeAssessment(close);
                    }
                    continue;
                case 7:
                    for(int i=0; i<comment_list.size(); i++){
                        comment Cs = comment_list.get(i);
                        Cs.viewComment();
                    }
                    continue;
                case 8:
                    System.out.println("Enter comment: ");
                    scan.nextLine();
                    data = scan.nextLine();
                    comment C = new comment(data, java.util.Calendar.getInstance().getTime(), I.getName());
                    comment_list.add(C);
                    continue;
                case 9:
                    break;
            }
        }
    }

    public static void studentMenu(backpack_user S){
        Scanner scan = new Scanner(System.in);
        int student_choice = 0;
        String data;
        int a_id;
        while(student_choice!=7){
            System.out.println("Welcome "+S.getName());
            System.out.println("STUDENT MENU");
            System.out.println("1. View lecture materials");
            System.out.println("2. View assessments");
            System.out.println("3. Submit assessment");
            System.out.println("4. View grades");
            System.out.println("5. View comments");
            System.out.println("6. Add comments");
            System.out.println("7. Logout");

            student_choice = scan.nextInt();
            switch(student_choice){
                case 1:
                    for(int i=0; i<lecture_material_list.size(); i++){
                        lectureMaterial L = lecture_material_list.get(i);
                        L.viewMaterial();
                    }
                    continue;
                case 2:
                    S.viewOpen();
                    continue;
                case 3:
                    S.viewOpen();
                    System.out.println("Enter ID of assessment:");
                    a_id = scan.nextInt();
                    assessment Asub = S.submission(a_id);
                    submissions_list.add(Asub);
                    continue;
                case 4:
                    assessment Ag = assessment_list.get(0);
                    S.grades(Ag);
                    continue;
                case 5:
                    for(int i=0; i<comment_list.size(); i++){
                        comment Cs = comment_list.get(i);
                        Cs.viewComment();
                    }
                    continue;
                case 6:
                    System.out.println("Enter comment: ");
                    scan.nextLine();
                    data = scan.nextLine();
                    comment C = new comment(data, java.util.Calendar.getInstance().getTime(), S.getName());
                    comment_list.add(C);
                    continue;
                case 7:
                    break;
            }
        }
    }

    public static void createUsers(){
        backpack_user I0 = new instructor("I0");
        backpack_user I1 = new instructor("I1");
        backpack_user S0 = new student("S0");
        backpack_user S1 = new student("S1");
        backpack_user S2 = new student("S2");

        backpack_user_list.add(I0);
        backpack_user_list.add(I1);
        backpack_user_list.add(S0);
        backpack_user_list.add(S1);
        backpack_user_list.add(S2);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        createUsers();
        int choice = 0;
        while(choice!=3){
            menu();
            choice = scan.nextInt();
            switch(choice){
                case 1:
                    int ins_ch;
                    System.out.println("Instructors:");
                    System.out.println("0-I0");
                    System.out.println("1-I1");
                    System.out.print("Choose id:");
                    ins_ch = scan.nextInt();
                    backpack_user I = backpack_user_list.get(ins_ch);
                    instructorMenu(I);
                    continue;

                case 2:
                    int stu_ch;
                    System.out.println("Students:");
                    System.out.println("0-S0");
                    System.out.println("1-S1");
                    System.out.println("2-S2");
                    System.out.print("Choose id:");
                    stu_ch = scan.nextInt();
                    backpack_user S = backpack_user_list.get(stu_ch+2);
                    studentMenu(S);
                    continue;

                case 3:
                    break;
            }
        }
    }
}