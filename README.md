Key Features ✨
Automated Seat Allocation: Automatically assigns seats to students based on a user-specified number of rows and columns.
Multi-Classroom Support: Efficiently handles seat allocation across multiple classrooms when needed.
CSV File Integration: Reads student details (Name, USN, Branch) from a CSV file.
Interactive GUI: Built with Java Swing, providing an easy-to-use graphical interface to display seating arrangements in table format.
Error Handling: Validates inputs and handles errors like insufficient seats or incorrect file formats.
How It Works 🚀
Users specify the number of rows and columns for seating arrangements.
The application loads student data from a students.csv file.
Seats are allocated dynamically, with unoccupied seats marked for additional use.
The seating arrangement for each classroom is displayed in a professional table format.
Benefits 🌟
Reduces manual effort in managing large-scale seating arrangements.
Ensures systematic and error-free seat assignments.
User-friendly interface makes it accessible to non-technical users.
Technologies Used 💻
Java for core logic.
Swing for GUI development.
File I/O for CSV data handling.
Setup & Usage 🛠️
Clone the repository and place your students.csv file (format: Name,USN,Branch) in the project directory.
Compile and run the program using:
javac FinalSeatAllocation.java
java FinalSeatAllocation
