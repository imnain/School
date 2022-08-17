import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentsData {
    private String firstname="mandeep";
    private String lastname="nain";
    private String fathername="manjeet";
    private String address;
    private String previousSchool;
    private int previousClass;
    private int previousClassPercentage;
    //String[] subjects = new String[3];
    String date;
    Scanner commandInput = new Scanner(System.in);
    public void inputData(){
        System.out.println("Super Public School");
        System.out.println("Please Enter Information");
        System.out.println("Enter your name: ");
        firstname = commandInput.nextLine();
        System.out.println("Enter your lastname: ");
        lastname = commandInput.nextLine();
        System.out.println("Enter your father's name: ");
        fathername = commandInput.nextLine();
        System.out.println("Enter your Address: ");
        address = commandInput.nextLine();
        System.out.println("Enter your previous School Name: ");
        previousSchool = commandInput.nextLine();
        System.out.println("Enter your previous class: ");
        previousClass = commandInput.nextInt();
        System.out.println("Enter your previous class percentage: ");
        previousClassPercentage = commandInput.nextInt();
        //System.out.println("Enter your DOB in dd/mm/yyyy form: ");
        //date = commandInput.nextLine();
    }

    public void mysqlConnection() {
        try {
            Class.forName(URL.url1);
            Connection connection = DriverManager.getConnection(URL.url, URL.user, URL.password);
            System.out.println("Connection is Successful to the database" + URL.url);
            String query = String.format("Insert into StudentsData(firstname,lastname, fathername) values( '%s','%s','%s')", firstname, lastname, fathername);
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        StudentsData student = new StudentsData();
        //student.inputData();
        student.mysqlConnection();
    }
}
