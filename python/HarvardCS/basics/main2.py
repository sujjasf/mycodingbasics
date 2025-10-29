# def main():
#     x = get_int("What's x?")
#     print(f"x is {x}")

# def get_int(prompt):
#     while True:
#         try:
#             return int(input(prompt))
#         except ValueError:
#             pass

# main()

# import random 
# coin = random.choice(['heads', 'tails'])
# print(coin)

# from random import choice
# from random import randint
# from random import shuffle
# coin = choice(['heads', "tails"])
# print(coin)
# randNum = randint(1,4)
# print(randNum)
# shuff = ["sujjal","dks", "dsfs"]
# shuffle(shuff)
# print(shuff)
# for words in shuff:
#     print(words)

# import statistics
# print(statistics.mean([100, 90]))

import sys
if len(sys.argv) < 2:
    sys.exit("Too few arguments")
elif len(sys.argv) > 2:
    print("Too many arguments")
else:
    print("Hello, My name is ", sys.argv[1])
# try:
#     print("Hellow, My name is", sys.argv[1])
# except IndexError:
#     print("wow")
