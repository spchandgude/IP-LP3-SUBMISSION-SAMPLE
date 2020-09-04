

print("the code is Run and Executed by KARAN SHAH 1812054 ")

def classify(x,y,z):
   if x == y == z:
      return "Equilateral triangle"
   elif x==y or y==z or z==x:
      return "isosceles triangle"
   else:
      return "Scalene triangle"

print("Input lengths of the triangle sides- ")
x = int(input("x= "))
y = int(input("y= "))
z = int(input("z= "))
print(classify(x,y,z))