import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Book {
    public static void SearchForBooks() throws IOException, NullPointerException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the book name or author name you want to see");
        String word = scan.nextLine(); // the word you want to find
        String line;


        try (BufferedReader br = new BufferedReader(new FileReader("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Book_List"))) { // open file foobar.txt

            while (( line = br.readLine() ) != null) { //read file line by line in a loop
                if (( line.contains(word) )) { // check if line contain that word then prints the line
                    System.out.println(line);

                }
            }
        }
    }


    public static void rentBook() throws IOException, NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the book name you want to rent");
        String word = scan.nextLine(); // the word you want to find
        String line;


        try (BufferedReader br = new BufferedReader(new FileReader("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Book_List"))) { // open file foobar.txt

            while (( line = br.readLine() ) != null) { //read file line by line in a loop
                if (( line.contains(word) )) { // check if line contain that word then prints the line
                    System.out.println(line);
                    FileWriter writer = new FileWriter("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Rented_Books", true);
                    writer.write(line + ",--nonavailable--" + "\n");
                    writer.close();
                    FileWriter writer1 = new FileWriter("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Availability", true);

                    writer1.write(line + ",--nonavailable--" + "\n");

                    writer1.close();

                }
                    String press = "You have successfully rented If You change mind press\n 1-Hand in\n 2- return menu";
                    System.out.println(press);
                    String islem = scan.nextLine();

                    if (islem.equals("1")) {
                        HandInBook();

                    } else if (islem.equals("2")) {
                        new Login();
                    }
                }
            }

        }


    public static void availabilityofBook() throws IOException, NoSuchAlgorithmException {
        try {
            InputStream is = new FileInputStream("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Availability");
            int size = is.available();
            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "");
            }
            is.close();

        } catch (IOException e) {
            System.out.print("Exception");

        }

    }

    public static void HandInBook() throws IOException, NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the book name you want to hand in");
        String word = scan.nextLine();
        String line;


        try (BufferedReader br1 = new BufferedReader(new FileReader("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Book_List"))) { // open file foobar.txt

            while (( line = br1.readLine() ) != null) { //read file line by line in a loop
                if (( line.contains(word) )) { // check if line contain that word then prints the line
                    System.out.println(line);

                    FileWriter writer = new FileWriter("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Handed_In", true);
                    writer.write(line + ",--available--" + "\n");
                    writer.close();
                    FileWriter writer1 = new FileWriter("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Availability", true);

                    writer1.write(line + ",--available--" + "\n");
                    writer1.close();
                    String press = "You have succesfully handed in your book.\n Do you want new Book?\n" +
                            "1-Search For Books\n" + "2-See Books List\n" + "3-Rent Book\n" + "4-Hand In Book\n" + "5-Check Book Availability\n" + "6-Quit(press  Q for quit";
                    System.out.println(press);
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

                }
            }
        }

    }


    public static void showBookList() {
        try {
            InputStream is = new FileInputStream("/Users/nisasarac/iCloud Drive (Archive)/Desktop/projeler/HalimeAblaciim/src/Book_List");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "");
            }
            is.close();

        } catch (IOException e) {
            System.out.print("Exception");

        }
    }
}
