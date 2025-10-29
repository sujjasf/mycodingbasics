# def main():
#     hello("world")
#     goodbye("Bro")

# def hello(name):
#     print(f"hello, {name}")


# def goodbye(name):
#     print(f"Goodbye, {name}")

# if __name__ == "__main__":
#     main()

# print(__name__)
# print(__main__)


def main():
    x = int(input("What's x? "))
    print("X is squared is ", square(x))

def square(n):
    return n * n

if __name__ == "__main__":
    main()