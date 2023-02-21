import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {
    public static void main(String[] args) throws IOException {
        System.out.println("\nWelcome to Student Management \n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("PRESS 1 to ADD student\nPRESS 2 to DELETE student\nPRESS 3 to " +
                    "DISPLAY student\nPRESS 4 to EXIT app");
            System.out.print("\nEnter your choice : ");
            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                // add student...
                System.out.print("\nEnter user name : ");
                String name = br.readLine();

                System.out.print("Enter user phone : ");
                String phone = br.readLine();

                System.out.print("Enter user city : ");
                String city = br.readLine();

                // create student object to store student
                Student st = new Student(name, phone, city);
                boolean ans = StudentDao.insertStudentToDB(st);
                if (ans) {
                    System.out.println("Student is added successfully...");
                } else {
                    System.out.println("Something went wrong try again...");
                }
                System.out.println(st.toString());

            } else if (c == 2) {
                // delete student...
                System.out.print("\nEnter student id to be deleted : ");
                int userId = Integer.parseInt(br.readLine());
                boolean ans = StudentDao.deleteStudent(userId);
                if(ans){
                    System.out.format("Student with id %d deleted successfully...", userId);
                } else{
                    System.out.format("Student with id %d does not exist...", userId);
                }

            } else if (c == 3) {
                // display students...
                System.out.println();
                StudentDao.showAllStudents();
            } else if (c == 4) {
                // exit
                break;
            } else {
                System.out.println("Please enter a valid choice");
            }
            System.out.println("-----------------------------------------------------------");
        }
        System.out.println("\nThank-you for using my application...");
        System.out.println("See you soon...bye bye");
    }
}