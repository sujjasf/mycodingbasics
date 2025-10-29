
# import sys

# from library import hello

# if len(sys.argv) == 2:
#     hello(sys.argv[1])


from library import square

def main():
    test_square()

def test_square():
    try:
        assert square(2) == 4
    except AssertionError:
        print("2 squared was not 4")
    try:
        assert square(3) == 9
    except AssertionError:
        print("3 squared was not 9")
    # if square(2) != 4:
    #     print("Two square was not 4")
    # if square(3) == 9:
    #     print("Three square was not Nine")

if __name__ == "__main__":
    main()
