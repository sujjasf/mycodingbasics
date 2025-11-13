# CLI calculator application

def main():
    """Main function to run the calculator CLI."""

    while True:
        print("""
            Choose one number from 1 to 5,
            1. Add
            2. Subtract
            3. Multiply
            4. Divide
            5. Exit
        """)
        choice = int(input("Enter your operation choice: "))
        if choice == 1:
            add()
        elif choice == 2:
            sub()
        elif choice == 3:
            mul()
        elif choice == 4:
            div()
        elif choice == 5:
            print("👋 Goodbye!")
            break
        else:
            print("Enter option ranging from 1-5 only!!! ")

def add():
    num1 = int(input("Enter first number: "))
    num2 = int(input("Enter second number: "))
    print(f"The sum of {num1} and {num2} is {num1+num2}. \n")

def sub():
    num1 = int(input("Enter first number: "))
    num2 = int(input("Enter second number: "))
    print(f"The sum of {num1} and {num2} is {num1-num2}. \n")

def mul():
    num1 = int(input("Enter first number: "))
    num2 = int(input("Enter second number: "))
    print(f"The sum of {num1} and {num2} is {num1*num2}. \n")

def div():
    num1 = int(input("Enter first number: "))
    num2 = int(input("Enter second number: "))
    if num2 == 0:
        print("Cannot divide by zero")
    else:
        print(f"The sum of {num1} and {num2} is {num1/num2}. \n")

if __name__ == "__main__":
    main()