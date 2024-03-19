package java.classwork;


// Define the Student class
class Student {
    String name;    // String variable to store the name
    int roll_no;    // Integer variable to store the roll number
}
public class object1 {
    public static void main(String[] args) {
        // Create first object of Student class
        Student student1 = new Student();
        student1.name = "john";  // Assigning name "john"
        student1.roll_no = 2;    // Assigning roll number 2
        
        // Create second object of Student class
        Student student2 = new Student();
        student2.name = "jane";  // Assigning name "jane"
        student2.roll_no = 3;    // Assigning roll number 3
        
        // Printing details of first student
        System.out.println("Details of student1:");
        System.out.println("Name: " + student1.name);
        System.out.println("Roll Number: " + student1.roll_no);
        
        // Printing details of second student
        System.out.println("\nDetails of student2:");
        System.out.println("Name: " + student2.name);
        System.out.println("Roll Number: " + student2.roll_no);
    }
}
