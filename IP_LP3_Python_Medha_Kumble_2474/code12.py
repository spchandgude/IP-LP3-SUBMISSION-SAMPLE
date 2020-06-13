from collections import Counter
classes={}

x=int(input("Enter number of entries:"))

for i in range(x):
    a=input("enter class name: ")
    b=int(input("enter students: "))
    classes[a]=b
    students = Counter(classes)
     
print(students)  

