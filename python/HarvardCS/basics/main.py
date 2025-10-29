# students = ["Sujjal", "Sushant", "Ram"]

# for student in students:
#     print(student)

# for i in range(len(students)):
#     print(i+1, students[i])


# stdDict = {
#     "Sujjal": 23,
#     "Sushant": 22,
#     "Ram": 24
# }
# for student in stdDict:
#     print(student, stdDict[student])

# stdsData = [
#     {"name": "Sujjal", "age": 23, "city": "Bangalore"},
#     {"name": "Sushant", "age": 22, "city": "Mysore"},
#     {"name": "Ram", "age": 24, "city": "Delhi"},
#     {"name": "Shyam", "age": 21, "city": None},
# ]
# for student in stdsData:
#     print(student["name"], student["age"], student["city"], sep=", ")

try:
    x = int(input("Enter a value for x: "))
except ValueError:
    print("X is not an integer")
else:
    print(f"x is {x}")




