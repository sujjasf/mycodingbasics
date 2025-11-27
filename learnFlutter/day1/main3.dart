void main() {
    Cow c1 = Cow("Moti");

    c1.walk();
    c1.eat();

}

class Animal {
    String name;
    Animal(this.name);
    
    void eat() {
        print("$name can eat")
    }
}

class Cow extends Animal {
    Cow(super.name);

    void walk() {
        print("${super.name} can walk");
    }
}
