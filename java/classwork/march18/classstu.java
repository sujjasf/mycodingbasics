

// 1.  create a class name 'students' with string variable 'name' and inteager variable 'roll_no'; assign the value of roll_no as '2' and that name as 'john' by creating tow obects of class 'student' .


class Student {
    String name;
    int rollNo;
    
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
}
public class classstu {
    public static void main(String [] args) {
        // Creating two objects of class Student
        Student student1 = new Student("John", 2);
        Student student2 = new Student("Jane", 3);
        
        // Accessing object properties
        System.out.println("Student 1 - Name: " + student1.name + ", Roll No: " + student1.rollNo);
        System.out.println("Student 2 - Name: " + student2.name + ", Roll No: " + student2.rollNo);
    }
}
