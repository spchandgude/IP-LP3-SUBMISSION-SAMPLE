a=int(input('Enter the first number:'))
b=int(input('Enter the second number:'))

def check(a, b):
    if (a == 0): 
        return b; 
    return check(b%a, a); 
  
if(a>0 and a<(10**12+1) and b>=1 and b<(10**12+1)):
    count = 1
    for i in range(2, check(a, b)+1):
        if a%i==0 and b%i==0:
            count = count+1
    print(count)


