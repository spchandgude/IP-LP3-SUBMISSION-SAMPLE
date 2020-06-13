def slicing(a,step):
    return [a[i::step] for i in range(step)]

def countSpecialElements(matrix):
  nRows= len(matrix)
  nCount=0
  
  for row in matrix:
    for indexCol, element in enumerate(row):
  
      if element==min(row) or element==max(row):
        if row.count(element)>1:
          return -1
        nCount=nCount+1
  
      else:
        listColumn=[]
  
        for indexRow in range(0, nRows):
          listColumn.append(matrix[indexRow][indexCol])
  
        if element==min(listColumn) or element==max(listColumn):
          if listColumn.count(element)>1:
            return -1
          nCount=nCount+1
 
  return nCount

matrixx = [] 
print("Enter the entries rowwise:") 
a=[]
for i in range(3):          
    for j in range(3):      
        a.append(int(input())) 
    matrixx.append(a) 
mat=slicing(a,3)
    
if __name__ == '__main__':
  nCount = countSpecialElements(mat)
  print(nCount)




  

             

