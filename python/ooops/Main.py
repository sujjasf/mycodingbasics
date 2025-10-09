from car import Car

car_1 = Car("Porsche", "911 gt3 rs", 2022, "black")
car_2 = Car("BMW", "M5", 2023, "blue")


print(car_1.make)
print(car_2.make)
print(car_1.model)
print(car_1.year)
print(car_1.color)

car_1.drive()
car_1.stop()
