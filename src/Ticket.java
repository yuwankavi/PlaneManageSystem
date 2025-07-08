import java.io.FileWriter;
import java.io.IOException;


public class Ticket {

    //creating variables
    private int row;
    private int seat;
    private double price;
    private Person Person;

    //creating constructor
    public Ticket(int row,int seat,double price,Person Person){
        this.row=row;
        this.seat=seat;
        this.price=price;
        this.Person=Person;
    }

    //getting getters and setters
    public int getRow() {
        return row;
    }

    public void setRow(int raw) {
        this.row = raw;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person person) {
        this.Person = Person;
    }

    //method for print ticket information

    public void infoTicket(){
        String rowChar ="";
        switch (row){
            case 0:
                rowChar="A";
                break;
            case 1:
                rowChar="B";
                break;
            case 2:
                rowChar="C";
                break;
            case 3:
                rowChar="D";
                break;
        }
        System.out.println("Row number : "+rowChar);
        System.out.println("Seat number : "+seat);
        System.out.println("Ticket price £: "+price);
        Person.infoPrint();
    }

    //method for creat text file to add ticket information
    public void saveFile(){
        String rowChar ="";
        switch (row){
            case 0:
                rowChar="A";
                break;
            case 1:
                rowChar="B";
                break;
            case 2:
                rowChar="C";
                break;
            case 3:
                rowChar="D";
                break;
        }
        String fileName=rowChar + seat+".txt";
        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write("Ticket Information\n");
            writer.write("Row : "+rowChar+"\n");
            writer.write("Seat : "+seat+"\n");
            writer.write("Price : £"+price+"\n");
            writer.write("Person Information : ");
            writer.write("Name : "+ Person.getName()+"\n");
            writer.write("Surname : "+Person.getSureName()+"\n");
            writer.write("Email : "+Person.getEmail()+"\n");
            writer.close();

        }catch (IOException e){
            System.out.println("ERROR!!!!");
            e.printStackTrace();
        }
    }
}
