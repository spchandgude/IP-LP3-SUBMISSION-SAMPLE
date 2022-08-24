c= float(input('Enter Celsius value:'))
f=float(input('Enter Fahrenheit value:'))

# calculate fahrenheit
fahrenheit = (c * 1.8) + 32
print('%0.1d°C is %0.1d in Fahrenheit' %(c,fahrenheit))

#fahrenheit to celsius
celsius=(f-32)*5/9
print('%0.1d°F is %0.1d in Celsius' %(f,celsius))