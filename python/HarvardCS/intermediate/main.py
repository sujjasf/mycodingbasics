# names = []
# count = int(input("How many names will you enter? "))
# for _ in range(count):
#     names.append(input("Enter a name: "))
# # open("names.txt", "w").write("\n".join(names))
# file = open("names.txt", "a")
# for name in sorted(names):
#     file.write(f"{name}" + "\n")
#     print(f"Hello, {name}")
# file.close()

# name = input("Enter a name: ")
# with open("names.txt", "a") as file:
#     file.write(f"{name}\n")
# with open("names.txt", "r") as file:
#     lines = file.readlines()
# for line in lines:
#     print("Hello, ", line.strip())
#     # print("Hello, ", line, end="")

## sorting
# with open("names.txt", "r") as file:
#     for line in sorted(file):
#         print("hello,", line.strip())

## sorting
# names = []
# with open("names.txt") as file:
#     for line in file:
#         names.append(line.rstrip())
# for name in sorted(names):
#     print(f"Hello, {name}")


## reading csv
# with open("names.csv") as file:
#     for line in file:
#         name, age = line.rstrip().split(",")
#         print(f"Hello, {name}. You are {age} years old.")

# with open("Students.csv") as file:
#     for line in file:
#         row = line.rstrip().split(",")
#         print(f"{row[1]} age is {row[1]}")

# students = []
# with open("Students.csv") as file:
#     for line in file:
#         name, age = line.rstrip().split(",")
#         # student = {"name": name, "age": age}
#         # students.append(student)
#         student = {}
#         student["name"] = name
#         student["age"] = age
#         students.append(student)
# for student in students:
#     print(f"{student['name']} is {student['age']} years old. Traford!!!")


# email = input("What' your email? ").strip()
# # if "@" in email and "." in email:
# #     print("Valid")
# # else:
# #     print("Invalid")
# username, domain = email.split("@")
# if usernameand domain.endswith(".edu"):
#     print("Valid")
# else:
#     print("Invalid")

# import re
# email = input("What's your email? ").strip()
# if re.search("@", email):
#     print("Valid")
# else:
#     print("Invalid")

# def main():
#     name, house = get_student()
#     print(f"{name} from {house}")

# def get_student():
#     name = get_name()
#     house = get_house()
#     return name, house

# def get_name():
#     return input("Name:") 
# def get_house():
#     return input("House:")

# if __name__ == "__main__":
#     main()


# class Student:
#     def __init__(self, name, house):
#         if not name:
#             raise ValueError("Missing name")
#         self.name = name
#         self.house = house
# def main():
#     student = get_student()
#     print(f"{student.name} from {student.house}")
# def get_student():
#     name = get_name()
#     house = get_house()
#     try:
#         student = Student(name, house)
#     except ValueError:
#         print("Invalid student")
#         return get_student()
#     return student
# def get_name():
#     return input("Name:") 
# def get_house():
#     return input("House:")
# if __name__ == "__main__":
#     main()

# import random
# class Hat:
#     houses = ["Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"]
#     @classmethod
#     def sort(cls, name):
#         print(f"{name} goes to {random.choice(cls.houses)}")
# # hat = Hat()
# Hat.sort("Ron")

# class Account:
#     def __init__(self):
#         self.balance = 0
#     @property
#     def balance(self):
#         return self.balance
#     def deposit(self, n):
#         self._balance += n
#     def withdraw(self, n):
#         self._balance -= n

# def main():
#     account = Account()


print("""
        Choose one number from 1 to 5,
        1. Add
        2. Subtract
        3. Multiply
        4. Divide
        5. Exit
        """)