import java.util.InputMismatchException;
import java.util.Scanner;

public class w2053201_PlaneManagement {
    public static int[][] seat = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},  //Creating an array for seat details
                                  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    public static Ticket[][] tickets=new Ticket[4][14];  //Creating array for store ticket details
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application");
        int option ;
            do {   //Add do while for loop until select option 0
                getOption();    // Display menu options
                try {
                    System.out.print("Please select an option : ");
                    option = input.nextInt();  //getting user choice
                }catch (InputMismatchException e){
                    option=-1;      // If input is not an integer, set option to -1
                    input.nextLine();
                }

                switch (option) {
                    case 1:
                        buySeat();      //but seat
                        break;
                    case 2:
                        cancelSeat();       // Cancel a seat
                        break;
                    case 3:
                        findFirstAvailable();       // Find first available seat
                        break;
                    case 4:
                        showSeatingAvailable();     // Show seating plan
                        break;
                    case 5:
                        printTicketsInfo();     // Print tickets information and total sales
                        break;
                    case 6:
                        searchTicket();     // Search for a ticket
                        break;
                    case 0:
                        exit();         // Exit the program
                        break;
                    case -1:
                        System.out.println("Enter valid integer ");
                        break;
                    default:
                        System.out.println("ERROR!! /nEnter only number between 1-7");
                }
            } while (option !=0);

    }

    // Method to display menu options
    public static void getOption() {
        System.out.println("*************************************************");
        System.out.println("*                   Main Menu                   *");
        System.out.println("*************************************************");
        System.out.println("1) Buy a seat");
        System.out.println("2) Cancel a seat");
        System.out.println("3) Find first available seat");
        System.out.println("4) Show seating plan");
        System.out.println("5) Print tickets information and total sales");
        System.out.println("6) Search tickets");
        System.out.println("0) Quit");
    }

    // Method to buy a seat
    public static void buySeat() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter raw character : ");     //getting  rowletter
                String seatRow = input.next().toUpperCase();
                int seatRow1 = 0;
                switch (seatRow) {
                    case "A":
                        seatRow1 = 0;
                        break;
                    case "B":
                        seatRow1 = 1;
                        break;
                    case "C":
                        seatRow1 = 2;
                        break;
                    case "D":
                        seatRow1 = 3;
                        break;
                    default:
                        System.out.println("Invalid row. Please enter a valid row (A-D).");
                        continue;
                }

                System.out.print("Enter seat number : ");       //getting seat number
                int seatNum = input.nextInt();

                //set seat prices according to seat numbers and get name , surname,and email

                if (seatNum >= 1 && seatNum <= seat[seatRow1].length) {
                    validInput = true;
                    double seatPrice =0;
                    if (0 <= seatNum - 1 && seatNum - 1 <= 4) {
                        seatPrice = 200;
                    } else if (5 <= seatNum - 1 && seatNum - 1 <= 8) {
                        seatPrice = 150;
                    } else if (8 <= seatNum - 1 && seatNum - 1 <= 13) {
                        seatPrice = 180;
                    }
                    if (seat[seatRow1][seatNum - 1] == 0) {
                        System.out.print("Enter your name : ");
                        String name = input.next();
                        System.out.print("Enter your surname : ");
                        String surname = input.next();
                        System.out.print("Enter your email : ");
                        String email = input.next();
                        seat[seatRow1][seatNum - 1] = 1;
                        Person person = new Person(name, surname, email);
                        tickets[seatRow1][seatNum - 1] = new Ticket(seatRow1, seatNum, seatPrice, person);  //adding ticket information to ticket array
                        tickets[seatRow1][seatNum - 1].infoTicket();    //display ticket infomation
                        System.out.println("successfully booked your seat");
                        tickets[seatRow1][seatNum - 1].saveFile();  //save file to text file
                    } else {
                        System.out.print("This seat already booked");
                    }
                } else {
                    System.out.println("Invalid seat number. Please enter a valid seat number.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid input.");
                input.nextLine();
            }
        }
    }

    // Method to cancel a seat

    public static void cancelSeat() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter raw character : ");
                String seatRow = input.next().toUpperCase();
                int seatRow1 = 0;
                switch (seatRow) {
                    case "A":
                        seatRow1 = 0;
                        break;
                    case "B":
                        seatRow1 = 1;
                        break;
                    case "C":
                        seatRow1 = 2;
                        break;
                    case "D":
                        seatRow1 = 3;
                        break;
                    default:
                        System.out.println("Invalid row. Please enter a valid row (A-D).");
                        continue;
                }

                System.out.print("Enter seat number : ");
                int seatNum = input.nextInt();

                if (seatNum >= 1 && seatNum <= seat[seatRow1].length) {
                    validInput = true;
                    if (seat[seatRow1][seatNum - 1] == 1) {
                        seat[seatRow1][seatNum - 1] = 0;    //remove seat details from seat array
                        tickets[seatRow1][seatNum - 1] = null;      //remove ticket deatils from tickets array
                        System.out.println("successfully canceled your booked seat");
                    } else {
                        System.out.println("This seat already available");
                    }
                } else {
                    System.out.println("Invalid seat number. Please enter a valid seat number.");
                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid input.");
                input.nextLine();
            }
        }
    }

    // Method to find first available seat
    public static void findFirstAvailable() {
        boolean seatFound = false;
        // Loop through the seating plan to find the first available seat
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (seat[i][j] == 0) {
                    String seatLetter="0";
                    switch (i){
                        case 0:
                            seatLetter="A";
                            break;
                        case 1:
                            seatLetter="B";
                            break;
                        case 2:
                            seatLetter="C";
                            break;
                        case 3:
                            seatLetter="D";
                            break;
                    }

                    System.out.println("First available seat found at Row " + seatLetter + ", Seat " + (j+1));
                    seatFound = true;
                    break;
                }else {
                    System.out.println("All seats are booked");
                }
            }
            if (seatFound) {
                break;
            }
        }
    }

    // Method to show seating plan
    public static void showSeatingAvailable(){
        for (int[] temp : seat) {
            for (int temp1 : temp) {
                if (temp1==1){
                    System.out.print(" x ");
                }else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }

    // Method to print ticket information
    public static void printTicketsInfo(){
        double total=0;
        for (int i=0;i< tickets.length;i++){
            for (int j=0;j<tickets[i].length;j++){
                if (tickets[i][j]!=null){
                    tickets[i][j].infoTicket();     //printing ticket information
                    total+=tickets[i][j].getPrice();//adding ticket prices
                }
            }
        }
        System.out.println("Toatal price = "+total);
    }

    // Method to search ticket

    public static void searchTicket(){
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter raw character : ");//getting rowletter
                String seatRow = input.next().toUpperCase();
                int seatRow1 = 0;
                switch (seatRow) {
                    case "A":
                        seatRow1 = 0;
                        break;
                    case "B":
                        seatRow1 = 1;
                        break;
                    case "C":
                        seatRow1 = 2;
                        break;
                    case "D":
                        seatRow1 = 3;
                        break;
                    default:
                        System.out.println("Invalid row. Please enter a valid row (A-D).");
                        continue;
                }

                System.out.print("Enter seat number : ");//getting seat number
                int seatNum = input.nextInt();

                if (seatNum >= 1 && seatNum <= seat[seatRow1].length) {
                    validInput = true;
                    if (tickets[seatRow1][seatNum - 1] != null) {
                        tickets[seatRow1][seatNum - 1].infoTicket();//printing ticket information according to searched ticket
                    } else {
                        System.out.println("Seat not booked yet");
                    }
                } else {
                    System.out.println("Invalid seat number. Please enter a valid seat number.");
                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid input.");
                input.nextLine();
            }
        }
    }

    //Exiting from the programme
    public static void exit(){
        System.out.println("Exiting Programme... \nGoodbye!");
        System.exit(0);
    }
}