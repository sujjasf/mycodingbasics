from tkinter import *

def submit():
    print("The temperature is: "+ str(scale.get()) + " degrees C.")


window = Tk()
# window.title("My First GUI Program")
scale = Scale(window, 
              from_=0, 
              to=100,
              length=600,
              orient=VERTICAL,
              font = ('Consolas', 20),
              tickinterval=10,
              #showvalue=0
              resolution=5,
              )
scale.pack()

button = Button(window, text='submit', command=submit)
button.pack()

window.mainloop()