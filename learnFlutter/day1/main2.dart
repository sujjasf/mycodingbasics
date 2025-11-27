void main() {
    Student s1 = Student(name: "hari", rollNo: 11);
    // print("Student name is: ${s1.name} and roll no is ${s1.rollNo}");
    
    // Student s2 = Student("Ram", 14);
    // print("Student name is: ${s2.name} and roll no is ${s2.rollNo}");

    s1.display();
}

class Student {
    String name;
    int rollNo;
    String address;

    // Student(this.name, this.rollNo);
    Student({required this.name,required this.rollNo, this.address="itahari"});

    void display() {
        print("Student name is $name and roll number is $rollNo, address is ${address} ");
    }
}