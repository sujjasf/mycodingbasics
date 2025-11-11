# # Write a program to swap two numbers.
# num1 = 1
# num2 = 2
# print(f"Before swap {num1} and {num2}")
# temp = num1
# num1 = num2
# num2 = temp
# print(f"After swap {num1} and {num2}")

# # Take input from user and display the sum of two numbers.
# num1 = int(input("Enter first number: "))
# num2 = int(input("Enter second number: "))
# sum = num1 + num2
# print(f"The sum of {num1} and {num2} is {sum}")

# # Write a program to check if a number is even or odd.
# num1 = 3
# if num1 %2 == 0:
#     print(f"The {num1} is even.")
# else:
#     print(f"Then {num1} is odd.")

# # Find the area of a circle given its radius.
# radius = int(input("Enter the radius of circle in cm: "))
# area = 3.14 * radius * radius
# print(f"The area of circle with radius {radius}cm is {area}cm^2")

# # Count the number of vowels in a string.
# str = "The name is sujjal"
# vowCount = 0
# for letter in str:
#     if letter == 'a' or letter == 'e' or letter == 'i' or letter == 'o' or letter == 'u':
#         vowCount += 1
# print(vowCount)

# # Write a function to find the square of a number.
# def square(num):
#     return num * num
# def main():
#     print(square(3))
# if __name__ == "__main__":
#     main()

# To-Do List CLI App (store tasks in file)
# from shiboken6 import delete

TODO_FILE = "todo.txt"

def main():
    while(True):
        print("""
        Select one options by selecting respective numbers
            1. View tasks
            2. Add task
            3. Complete task
            4. Delete task
            5. Clear all task
            6. Exit
        """)
        choice = int(input("Enter your choice: "))
        if choice == 1:
            show_tasks()
        elif choice == 2:
            add_task()
        elif choice == 3:
            mark_done()
        elif choice == 4:
            delete_task()
        elif choice == 5:
            clear_all()
        elif choice == 6:
            print("👋 Goodbye! Your tasks are saved in todo.txt.")
            break
        else:
            print("❌ Invalid choice! Please enter a number between 1 and 6.\n")

def load_tasks():
    """Load tasks from the todo file."""
    try:
        with open(TODO_FILE, "r") as file:
            tasks = [line.strip() for line in file.readlines()]
    except FileNotFoundError:
        tasks = []
    return tasks

def save_tasks(tasks):
    """Save tasks to the todo file."""
    with open(TODO_FILE, "w") as file:
        for task in tasks:
            file.write(task + "\n")

def show_tasks():
    """Display all tasks with numbers and status."""
    tasks = load_tasks()
    if not tasks:
        print("\n📭 No tasks found.\n")
        return
    print("\n📋 Your Tasks:")
    print("--------------")
    for i, task in enumerate(tasks, start = 1):
        print(f"{i}. {task}")
    print()

def add_task():
    """Add a new task."""
    task_name = input("Enter the task description: ").strip()
    if not task_name:
        print("⚠️  Task description cannot be empty!\n")
        return
    tasks = load_tasks()
    tasks.append(f"{task_name} - pending")
    save_tasks(tasks)
    print("✅ Task added successfully!\n")

def mark_done():
    """Mark a task as done."""
    tasks = load_tasks()
    if not tasks:
        print("\n📭 No tasks to mark as done.\n")
        return
    show_tasks()
    try:
        num = int(input("Enter the task number to mark as done: "))
        if 1 <= num <= len(tasks):
            if " - done" in tasks[num - 1]:
                print("⚠️  Task is already marked as done!\n")
            else:
                tasks[num - 1] = tasks[num - 1].replace(" - pending", "") + " - done"
                save_tasks(tasks)
                print("✅ Task marked as done!\n")
        else:
            print("❌ Invalid task number!\n")
    except ValueError:
        print("⚠️  Please enter a valid number!\n")

def delete_task():
    """Delete a specific task."""
    tasks = load_tasks()
    if not tasks:
        print("\n📭 No tasks to delete.\n")
        return
    show_tasks()
    try:
        num = int(input("Enter the task number to delete: "))
        if 1 <= num <= len(tasks):
            deleted = tasks.pop(num - 1)
            save_tasks(tasks)
            print(f"🗑️  Deleted: {deleted}\n")
        else:
            print("❌ Invalid task number!\n")
    except ValueError:
        print("⚠️  Please enter a valid number!\n")

def clear_all():
    """Clear all tasks."""
    confirm = input("Are you sure you want to delete all tasks? (y/n): ").strip().lower()
    if confirm == 'y':
        save_tasks([])
        print("🗑️  All tasks have been deleted!\n")
    else:
        print("❌ Clear all operation cancelled.\n")

if __name__ == "__main__":
    main()