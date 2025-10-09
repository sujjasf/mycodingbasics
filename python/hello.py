import os

path = "/home/sujjalbtw/Projects/mycodingbasics/python/test.txt"

if os.path.exists(path):
    print(f"The path {path} exists.")
    if os.path.isfile(path):
        print("This is a file.")
else:
    print(f"The path {path} does not exist.")