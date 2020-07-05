import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Register {
    private static int ID_student = 1000; //it it static becaus unique
    private static String password;
    private static String name;
    private String surname;
    private String Address;
    private String gender;
    private String membership_type;
    private int Membership_date;
    private int date_of_birth;

    public Register() throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter students first name");
        this.name = in.nextLine();
        System.out.println("Enter students lastname");
        this.surname = in.nextLine();
        System.out.println("1-Female\n2-Male\nEnter students gender!");
        this.gender = in.nextLine();

        System.out.println("Please enter an password for you");

        this.password = in.nextLine();
        register_student();
        ID_student++;
        setID();
        System.out.println(this.name + " " + surname + " " + gender + " " + ID_student);


        System.out.println("********************************");
        System.out.println("You have succesfully registered");
        System.out.println("********************************");


        String menus = "Please Login First After Registiration(Please enter 'L' to login)";

        System.out.println(menus);
        String islem = in.nextLine();


        if (islem.equals("L")) {
            System.out.println("Already an user ..?Please log in!");
            new Login();
        }
    }
public void setID(){
    ID_student++;
}
    public void register_student() {

        try {
            FileWriter writer = new FileWriter("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Registered_Student_Info", true);
            writer.write(" Student Name:/ " + name + "/" + " Student Surname: /" + surname + "/" +
                    " Gender Of A Student:/ " + gender + "/" + " Setted ID For a Student: /" + ID_student + "/" + "Secret Password For User / " + Login.md5(password) + "\n");
            FileWriter writer1 = new FileWriter("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/For_Login", true);
            writer1.write(name + " " + Login.md5(password) + "\n");
            writer.close();
            writer1.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }
}
