#QUESTION 4

data  = input()
L = data.split()
 
K = int(L[0])
P = int(L[1])
 
def gcd(K, P):
    if (K == 0):
        return P;
    return gcd(P%K, K);
 
if (K>0 and K<(10**12+1) and P>=1 and P<(10**12+1)):
    count = 1
    for i in range(2, gcd(K, P)+1):
        if K%i==0 and P%i==0:
            count = count+1
    print(count)