void main() {
//   dynamic name = "namuna";
//   name = 10;
//   print(name.runtimeType);


    // List<String> names = ['hari', 'ram'];
    // names.add("sujjal");
    // names.remove("ram");
    // names[0] = "shyam";
    // print(names);

    // Map<String, dynamic> map = {
    //     "book": "mahabharat",
    //     "published": 2017,
    // };
    // map['book'] = "modern";
    // map['somethingNew'] = "New map";
    // print(map);

    // List<String> names = ['hari', 'ram'];
    // for ( int i = 0; i < names.length; i++) {
    //     print("Name: ${names[i]}");
    // }
    // for (string name in names) {
    //     print("Name: ${names[i]}");
    // }
    // names.forEach((name) {
    //     print("Name: $name");
    // });

    greet();
    greetWithName("sujjal");
    print(greetWithReturnableType());
    print(greetWithReturnParamType(3, 4));
}

// No return type function no parameter
void greet() {
    print("Hello, students");
}

// No return type with parameter
void greetWithName(String name) {
    print("Hello $name");
}

// Return type with no parameter
String greetWithReturnableType() {
    //  
    return "Hello owl!!!";
}

// Return type with parameter
int greetWithReturnParamType(int a, int b) {
    return a + b;
}