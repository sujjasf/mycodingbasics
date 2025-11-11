import os

# File name where tasks will be stored
TODO_FILE = "todo.txt"

def load_tasks():
    """Read tasks from file, return as a list."""
    if not os.path.exists(TODO_FILE):
        return []
    with open(TODO_FILE, "r") as file:
        tasks = [line.strip() for line in file.readlines()]
    return tasks

def save_tasks(tasks):
    """Write all tasks back to file."""
    with open(TODO_FILE, "w") as file:
        for task in tasks:
            file.write(task + "\n")

def show_tasks():
    """Display all tasks with numbers and status."""
    tasks = load_tasks()
    if not tasks:
        print("\n📭 No tasks yet.\n")
        return
    print("\n📝 Your To-Do List:")
    print("--------------------")
    for i, task in enumerate(tasks, start=1):
        print(f"{i}. {task}")
    print()

def add_task():
    """Add a new task."""
    task_name = input("Enter new task: ").strip()
    if not task_name:
        print("⚠️  Task cannot be empty!\n")
        return
    tasks = load_tasks()
    tasks.append(f"{task_name} - pending")
    save_tasks(tasks)
    print("✅ Task added successfully!\n")

def mark_done():
    """Mark a task as done."""
    tasks = load_tasks()
    if not tasks:
        print("\n📭 No tasks to mark.\n")
        return
    show_tasks()
    try:
        num = int(input("Enter task number to mark done: "))
        if 1 <= num <= len(tasks):
            if " - done" in tasks[num - 1]:
                print("⚠️  Task already marked as done!\n")
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
        num = int(input("Enter task number to delete: "))
        if 1 <= num <= len(tasks):
            deleted = tasks.pop(num - 1)
            save_tasks(tasks)
            print(f"🗑️  Deleted: {deleted}\n")
        else:
            print("❌ Invalid task number!\n")
    except ValueError:
        print("⚠️  Please enter a valid number!\n")

def clear_all():
    """Delete all tasks."""
    confirm = input("⚠️  Are you sure you want to delete ALL tasks? (y/n): ").lower()
    if confirm == "y":
        open(TODO_FILE, "w").close()
        print("🧹 All tasks cleared!\n")
    else:
        print("❌ Operation cancelled.\n")

def main():
    """Main program loop."""
    while True:
        print("======== TO-DO LIST MENU ========")
        print("1. View Tasks")
        print("2. Add Task")
        print("3. Mark Task as Done")
        print("4. Delete Task")
        print("5. Clear All Tasks")
        print("6. Exit")
        print("=================================")

        choice = input("Enter your choice (1-6): ").strip()

        if choice == "1":
            show_tasks()
        elif choice == "2":
            add_task()
        elif choice == "3":
            mark_done()
        elif choice == "4":
            delete_task()
        elif choice == "5":
            clear_all()
        elif choice == "6":
            print("👋 Goodbye! Your tasks are saved in todo.txt.")
            break
        else:
            print("❌ Invalid choice! Please enter a number between 1 and 6.\n")

if __name__ == "__main__":
    main()
