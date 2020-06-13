def selectionSort(nlist):
   for fillslot in range(len(nlist)-1,0,-1):
       maxpos=0
       for location in range(1,fillslot+1):
           if nlist[location]>nlist[maxpos]:
               maxpos = location

       temp = nlist[fillslot]
       nlist[fillslot] = nlist[maxpos]
       nlist[maxpos] = temp

nlist=[]
n=int(input('Enter number of elements:'))
for i in range(0,n):
    ele=int(input())
    nlist.append(ele)
    
selectionSort(nlist)

print(nlist)


