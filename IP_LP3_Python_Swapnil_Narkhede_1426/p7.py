celsius = float(input("Enter temperature in celsius: "))
fahrenheit1 = float(input("Enter temperature in fahrenheit: "))
fahrenheit = (celsius * 9/5) + 32
celsius1 = (fahrenheit1 - 32) * 5/9
print('%d °C is %d in Fahrenheit' %(celsius, fahrenheit))
print('%d °F is  %d in Celsius' %(fahrenheit1, celsius1))
