import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    private static String password;
    private final static String salt = "DGE$5SGr@3VsHYUMas2323E4d57vfBfFSTRU@!DSH(*%FDSdfg13sgfsg";

    public Login() throws NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        System.out.println("USERNAME:");
        String user_name_ = scan.nextLine();
        System.out.println("PASSWORD");
        String password_ = scan.nextLine();

        //List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/For_Login"))) {
            String line;
            boolean nameAndPass = false;
            boolean name = false;
            boolean Pass = false;

            while (( line = br.readLine() ) != null) {

                String[] values = line.split(" ");
                //records.add(values[0]);
                //records.add(values[1]);
                String user_name = values[0];
                String password = values[1];


                //  md5(password_);
//                int count=3;
//                while (count<3) {


                if (user_name_.equals(user_name) &&  md5Hash(password_).equals(password)) {
                    nameAndPass = true;

                } else if (!user_name_.equals(user_name) && md5Hash(password_).equals(password)) {
                    Pass = true;
                } else if (user_name_.equals(user_name) && ! md5Hash(password_).equals(password)) {
                    name = true;
                }
            }

            if (nameAndPass) {
                System.out.println("You successfully logged in");

                String menus =
                        "1-Search For Books\n" +
                                "2-See Books List\n" + "3-Rent Book\n" + "4-Hand In Book\n" + "5-Check Book Availability\n" + "6-Quit(press  Q for quit)";
                System.out.println(menus);


                while (true) {
                    System.out.println("Choose operation");
                    String islem = scan.nextLine();

                    if (islem.equals("1")) {
                        Book.SearchForBooks();

                    } else if (islem.equals("2")) {
                        System.out.println("This Is Book List");
                        Book.showBookList();

                    } else if (islem.equals("3")) {
                        System.out.println("Renting Operation");
                        Book.rentBook();
                    } else if (islem.equals("4")) {
                        System.out.println("Hand in Book Operation");
                        Book.HandInBook();

                    } else if (islem.equals("5")) {
                        System.out.println("Check Book Availability");
                        Book.availabilityofBook();
                    }
                    if (islem.equals("Q")) {
                        System.out.println("Logging out for you");
                        System.exit(Integer.parseInt(islem));
                        break;

                    }
                }
            } else if (Pass) {
                System.out.println("You have entered wrong user name please try again");
                new Login();
            } else if (name) {
                System.out.println("Your password is wrong please try again");
                new Login();
            } else {
                System.out.println("Are you sure you registered befeore?");
                new Register();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static String md5(String input) {

        String md5 = null;
        if (null == input) return null;

        try {

            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());

            //Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        }
        return md5;
    }


    private static String md5Hash(String input) {
        String md5 = null;
        if (null == input) return null;

        try {

            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());

            //Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md5;
    }
}