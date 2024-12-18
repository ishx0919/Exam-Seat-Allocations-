import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for Seat Allocation
interface SeatAllocator {
    List<FinalSeatAllocation.Student> readStudentsFromCSV(String fileName);
    String[][] allocateSeats(int rows, int columns, List<FinalSeatAllocation.Student> students);
}

public class FinalSeatAllocation implements SeatAllocator {

    // Class to represent a Student
    static class Student {
        String name;
        String usn;
        String branch;

        Student(String name, String usn, String branch) {
            this.name = name;
            this.usn = usn;
            this.branch = branch;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input number of rows and columns for seating arrangement
        System.out.print("Enter the number of rows in the exam hall: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns in the exam hall: ");
        int columns = scanner.nextInt();

        int totalSeats = rows * columns;

        // File path for the CSV file
        String filePath = "C:\\Users\\shata\\AppData\\Local\\Packages\\5319275A.WhatsAppDesktop_cv1g1gvanyjgm\\TempState\\2D0773FD1353E5BCC2BACA60EFF83A98\\students.csv";

        // Step 2: Read student data from CSV file using the interface
        FinalSeatAllocation seatAllocator = new FinalSeatAllocation();
        List<Student> students = seatAllocator.readStudentsFromCSV(filePath);

        // Step 3: Check if enough seats are available
        if (students.size() > totalSeats) {
            System.out.println("Not enough seats for all students!");
            scanner.close();
            return;
        }

        // Step 4: Allocate seats row by row
        String[][] seats = seatAllocator.allocateSeats(rows, columns, students);

        // Step 5: Display the seating arrangement in a professional format
        displaySeatingArrangement(seats);

        scanner.close();
    }

    // Function to read student details from a CSV file
    @Override
    public List<Student> readStudentsFromCSV(String fileName) {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) { // Ensure valid data
                    studentList.add(new Student(details[0], details[1], details[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
        return studentList;
    }

    // Function to allocate seats with seat numbers
    @Override
    public String[][] allocateSeats(int rows, int columns, List<Student> students) {
        String[][] seats = new String[rows][columns];
        int studentIndex = 0;
        int seatNumber = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (studentIndex < students.size()) {
                    Student student = students.get(studentIndex);
                    seats[i][j] = student.name + " (" + student.usn + ")";
                    studentIndex++;
                } else {
                    seats[i][j] = "Seat No " + seatNumber;
                }
                seatNumber++;
            }
        }
        return seats;
    }

    // Function to display the seating arrangement professionally
    private static void displaySeatingArrangement(String[][] seats) {
        System.out.println("\n------------------- Final Seat Allocation -------------------\n");
        
        // Print column headers
        System.out.printf("%-10s", "Row/Col");
        for (int col = 1; col <= seats[0].length; col++) {
            System.out.printf("| %-20s", "Column " + col);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");

        // Print each row with its row header
        for (int i = 0; i < seats.length; i++) {
            System.out.printf("%-10s", "Row " + (i + 1)); // Row header
            for (int j = 0; j < seats[i].length; j++) {
                System.out.printf("| %-20s", seats[i][j]);
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
        }
    }
}
